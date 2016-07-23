package network;

import java.net.Socket;
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
            _socket.getOutputStream().write("testing".getBytes());
            counter--;
        } while (counter > 0);
        return RESPONSE_CODE;
    }
}
