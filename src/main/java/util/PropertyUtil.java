package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Adeola.Ojo on 7/17/2016.
 */
public class PropertyUtil {

    public static String propertyPath = "C:\\Users\\adeola.ojo\\Downloads\\disruptor-examples-master\\payment-notification-service\\target\\classes\\app.config";

    /**
     * read Property
     *
     * @param key
     * @return
     * @throws IOException
     */
    public String readProperty(String key) throws IOException {
        Properties prop = new Properties();
        prop.load(new FileInputStream(propertyPath));
        return prop.getProperty(key);
    }
}
