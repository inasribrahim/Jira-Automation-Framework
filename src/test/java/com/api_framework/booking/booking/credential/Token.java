package com.api_framework.booking.booking.credential;

import com.api_framework.booking.endpoints.APIEndPoint;
import com.api_framework.booking.properties.PropertiesHandler;
import com.api_framework.booking.utility.RawData;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class Token {

    protected final static String token_value = "token";

    public static String getTokenKey() throws IOException {
            CredentialsPayload credentialsPayload = CredentialsBuilder.builder()
                    .setUsername(PropertiesHandler.setCredentialsProperties().getProperty("username"))
                    .setPassword(PropertiesHandler.setCredentialsProperties().getProperty("password"))
                    .perform();

            RestAssured.baseURI= APIEndPoint.BOOKING_URL;
            Response res= given().
                    header("Content-Type", ContentType.JSON)
                    .body(credentialsPayload)
                    .when()
                    .post(APIEndPoint.AUTH)
                    .then().statusCode(200)
                    .extract()
                    .response();
            return RawData.rawToJson(res).get(token_value);
    }
}
