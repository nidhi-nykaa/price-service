package com.nykaa.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Component
public class ConfigReaderUtil {
    @Autowired
    private Environment environment;
    private static Properties properties = new Properties();
    private static Logger logger = LogManager.getLogger(ConfigReaderUtil.class);

    @PostConstruct
    public void init() throws IOException {
   /*     InputStream input = null;
        try {
            String configFilename = "conf-"+environment.getActiveProfiles()+".properties";
            System.out.println("Config Filename: " + configFilename);
            input = Thread.currentThread().getContextClassLoader().getResourceAsStream(configFilename);
            properties.load(input);
        } catch (IOException e) {
            logger.error("Error while reading the config: ", e);
            throw e;
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    logger.error("Error while closing the connection: ", e);
//					e.printStackTrace();
                }
            }
        }*/
    }

    public static String getValue(String key) {
        return properties.getProperty(key);
    }

}