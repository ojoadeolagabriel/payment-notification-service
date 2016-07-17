package payment.processor;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Adeola.Ojo on 7/17/2016.
 */
@Component
public class DefaultPaymentProcessor {

    @Scheduled(fixedRate = 5000)
    public void reportStatus() {

        SimpleDateFormat format = new SimpleDateFormat();
        System.out.println("the time is: " + format.format(new Date()));
    }
}
