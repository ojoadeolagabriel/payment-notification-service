import data.AutogateProcessor;
import data.BankHandler;
import data.DaoUtil;
import data.PaymentNotification;
import network.SoapUtil;
import network.SocketProcessor;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import util.PropertyUtil;
import util.TestWebServer;
import webapi.BankHealth;
import webapi.RestApiHelper;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Program {

    static Logger logger = Logger.getLogger(Program.class);

    public static void main(String[] args) throws Exception {

        SoapUtil.call("IBM");

        String json = RestApiHelper.call("https://www.paydirectonline.com/paydirect/autopay_paydirect/autogateservice/GetSystemLog", null, "", "GET");
        JSONArray arr = new JSONObject(json).getJSONArray("BankHealthInformation");
        List<BankHealth.BankInformation> collBank = new ArrayList<>();

        for (int i = 0; i < arr.length(); i++) {

            BankHealth.BankInformation bank = new BankHealth.BankInformation();
            bank.setBankDescription(arr.getJSONObject(i).getString("BankDescription"));
            bank.setLastEventDescription(arr.getJSONObject(i).getString("LastEventDescription"));
            bank.setLastEventDescription(arr.getJSONObject(i).getString("LastEventDescription"));
            bank.setProcessorEnabled(arr.getJSONObject(i).getBoolean("IsProcessorEnabled"));
            collBank.add(bank);
        }

        int totalPermissibleConnection = 2;
        ExecutorService networkExecutorService = Executors.newFixedThreadPool(totalPermissibleConnection);
        List<FutureTask<String>> coll = new ArrayList<>();

        List<Socket> sockColl = new ArrayList<>();
        String message = "";
        try (ServerSocket socket = new ServerSocket(9000)) {
            while (!"STOP".equals(message) || totalPermissibleConnection > 0) {
                System.out.println("waiting for connection!");
                Thread.sleep(1000);

                try {

                    Socket clientConn = socket.accept();
                    DataInputStream incomming = new DataInputStream(clientConn.getInputStream());
                    DataOutputStream outbound = new DataOutputStream(clientConn.getOutputStream());

                    sockColl.add(clientConn);
                    FutureTask<String> mTask = null;
                    mTask = new FutureTask<>(new SocketProcessor(clientConn));
                    networkExecutorService.execute(mTask);

                    coll.add(mTask);
                    System.out.println("accepted connection...");
                    outbound.writeUTF("\\welcome to synapse\n");
                } catch (Exception exc) {
                    exc.printStackTrace();
                }

                totalPermissibleConnection--;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        //get all processors
        List<AutogateProcessor> bankProcessors = DaoUtil.getAutogateProcessors(null);
        logger.debug(String.format("found: [%d] processors!", bankProcessors.size()));
        ExecutorService service = Executors.newFixedThreadPool(bankProcessors.size());
        FutureTask<String> bankTask = null;

        //load all processors
        for (AutogateProcessor processor : bankProcessors) {
            BankHandler proc = new BankHandler(1000, processor);
            bankTask = new FutureTask<>(proc);
            service.execute(bankTask);
        }

        //while loop.
        while (true) {
            System.out.println("awaiting ");
            if (bankTask.isDone()) {
                String asyncTaskResult = bankTask.get(200L, TimeUnit.MILLISECONDS);
                System.out.println("task result: " + asyncTaskResult);
                break;
            }
        }
    }

}
