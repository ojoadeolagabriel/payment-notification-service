import data.AutogateProcessor;
import data.BankHandler;
import data.DaoUtil;
import data.PaymentNotification;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import util.PropertyUtil;
import util.TestWebServer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.*;

public class Program {

    static Logger logger = Logger.getLogger(Program.class);

    public static void main(String[] args) throws Exception {

        //ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring/app-services.xml");
        TestWebServer.init();

        //get all processors
        List<AutogateProcessor> bankProcessors = DaoUtil.getAutogateProcessors(null);
        logger.debug(String.format("found: [%d] processors!", bankProcessors.size()));
        ExecutorService service = Executors.newFixedThreadPool(bankProcessors.size());
        FutureTask<String> bankTask = null;

        //load all processors
        for (AutogateProcessor processor : bankProcessors) {
            BankHandler proc = new BankHandler(1000, processor);
            bankTask = new FutureTask<String>(proc);
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
