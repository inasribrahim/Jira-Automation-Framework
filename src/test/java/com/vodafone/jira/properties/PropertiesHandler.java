package com.vodafone.jira.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHandler {

    private static final String CREDENTIALS_CONFIG_PATH = "resources/config/credentials-config.properties";
    protected static Properties credentialsConfig ;

    public static Properties getCredentialsConfig() {
        return credentialsConfig;
    }

    public static Properties setCredentialsProperties() throws IOException {
        credentialsConfig = new Properties();
        FileInputStream inputStream = new FileInputStream(CREDENTIALS_CONFIG_PATH);
        credentialsConfig.load(inputStream);
        return credentialsConfig;
    }


}
