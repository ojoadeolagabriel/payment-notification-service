package network;

import au.com.bytecode.opencsv.CSVReader;

import java.io.FileReader;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by Adeola.Ojo on 7/23/2016.
 */
public class SocketProcessor implements Callable<String> {

    final String RESPONSE_CODE = "70025";

    Socket _socket;

    public SocketProcessor(Socket socket) {
        _socket = socket;
    }

    @Override
    public String call() throws Exception {
        int counter = 10000;
        do {
            CSVReader reader = new CSVReader(new FileReader("C:\\Users\\adeola.ojo\\Downloads\\CodeBag\\a.csv"));
            List data = reader.readAll();
            String[] n = (String[]) data.get(1);

            String outData = n[2];
            _socket.getOutputStream().write(n[2].getBytes());
            counter--;
        } while (counter > 0);
        return RESPONSE_CODE;
    }
}
