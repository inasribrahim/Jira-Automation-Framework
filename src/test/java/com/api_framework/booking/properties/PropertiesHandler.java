package com.api_framework.booking.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class PropertiesHandler {
    public PropertiesHandler(){}
    private static final String CREDENTIALS_CONFIG_PATH = "resources/config/credentials-config.properties";
    protected static Properties credentialsConfig ;

    public static Properties setCredentialsProperties() throws IOException {
        credentialsConfig = new Properties();
        FileInputStream inputStream = new FileInputStream(CREDENTIALS_CONFIG_PATH);
        credentialsConfig.load(inputStream);
        return credentialsConfig;
    }
}
