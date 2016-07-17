import data.PaymentNotification;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

public class Program {

    static Logger logger = Logger.getLogger(Program.class);
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/job/job-report.xml");

        try {
            if (context.getBean("paymentData") instanceof PaymentNotification) {
                logger.debug(String.format("paymentData found"));
            }
        } catch (NoSuchBeanDefinitionException exc) {
            logger.error("no such bean deola");
        }
    }

}
