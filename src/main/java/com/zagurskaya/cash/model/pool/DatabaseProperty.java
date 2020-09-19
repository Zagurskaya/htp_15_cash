package com.zagurskaya.cash.model.pool;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

class DatabaseProperty {
    private static final Logger logger = LogManager.getLogger(ConnectionPool.class);
    private static DatabaseProperty instance;
    private static Properties properties;

    private static final String PROPERTY_NAME = "database.properties";
    private static final String DRIVER = "database.driver.name";
    private static final String URL = "database.url";
    private static final String USER = "database.username";
    private static final String PASSWORD = "database.password";

    private DatabaseProperty() {
    }

    static DatabaseProperty getInstance() {
        if (instance == null) {
            instance = new DatabaseProperty();
            createProperties();
            return instance;
        }
        return instance;
    }

    String getDriver() {
        return properties.getProperty(DRIVER);
    }

    String getUrl() {
        return properties.getProperty(URL);
    }

    String getUser() {
        return properties.getProperty(USER);
    }

    String getPassword() {
        return properties.getProperty(PASSWORD);
    }

    private static void createProperties() {
        properties = readProperties();
    }

    private static Properties readProperties() {
        try (InputStream input = ConnectionPool.class.getClassLoader().getResourceAsStream(DatabaseProperty.PROPERTY_NAME)) {

            if (input == null) {
                logger.log(Level.ERROR, "no properties file found");
                throw new RuntimeException("no properties file found");
            }

            Properties properties = new Properties();
            properties.load(input);
            return properties;
        } catch (IOException ex) {
            logger.log(Level.ERROR, "no properties file found");
            throw new RuntimeException("no properties file found");
        }
    }
}
