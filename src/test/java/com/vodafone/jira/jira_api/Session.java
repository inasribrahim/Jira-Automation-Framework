package com.vodafone.jira.jira_api;

import com.vodafone.jira.properties.PropertiesHandler;
import com.vodafone.jira.utility.RawData;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class Session extends BaseAPI{

    protected final String SESSION_VALUE = "session.value";
    RawData rawToData = new RawData();
    Properties properties;

    public String getSessionKey() throws IOException {
        RestAssured.baseURI= JIRA_URL;
        PropertiesHandler.setCredentialsProperties();
        properties = PropertiesHandler.getCredentialsConfig();
        Response res=
                given().
                        header("Content-Type", CONTENT_TYPE_JSON).
                        body(createAuthenticateLoginJsonPayload(properties.getProperty("username"),properties.getProperty("password"))).
                        when().
                        post(RESOURCE_AUTH).
                        then().statusCode(OK_STATUS_CODE).extract().response();
        return rawToData.rawToJson(res).get(SESSION_VALUE);
    }

}
