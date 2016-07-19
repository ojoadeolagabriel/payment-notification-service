package data;

import java.util.concurrent.Callable;

/**
 * Created by Adeola.Ojo on 7/19/2016.
 */
public class BankHandler implements Callable<String> {

    int _timeOut;
    AutogateProcessor _processor;

    public BankHandler(int timeOut, AutogateProcessor processor) {
        _timeOut = timeOut;
        _processor = processor;
    }

    public String call() throws InterruptedException {
        Thread.sleep(_timeOut);
        return "done with " + _processor.getDescription();
    }
}
