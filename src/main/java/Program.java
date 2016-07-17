import data.DaoUtil;
import data.PaymentNotification;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import util.PropertyUtil;

import java.io.IOException;
import java.sql.SQLException;

public class Program {

    static Logger logger = Logger.getLogger(Program.class);

    public static void main(String[] args) throws IOException {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/app-services.xml");
        PropertyUtil prop = new PropertyUtil();
        String iswBin = prop.readProperty("isw.bin");
        String gtbBin = prop.readProperty("gtb.bin");

        try {
            if (context.getBean("paymentData") instanceof PaymentNotification) {

                PaymentNotification notification = (PaymentNotification) context.getBean("paymentData");
                if (notification.getCardPan().startsWith(iswBin)) {
                    logger.debug("your card pan starts with: " + iswBin);
                }
                logger.debug(String.format("paymentData found"));
            }
        } catch (NoSuchBeanDefinitionException exc) {
            logger.error("no such bean...");
        }
    }

}
