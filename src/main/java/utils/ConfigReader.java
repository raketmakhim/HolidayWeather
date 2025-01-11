package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static String getProperties(String propertyName) throws IOException {
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String appConfigPath = rootPath + "config.properties";

        Properties properties = new Properties();
        properties.load(new FileInputStream(appConfigPath));

        return  properties.getProperty(propertyName);
    }
}
