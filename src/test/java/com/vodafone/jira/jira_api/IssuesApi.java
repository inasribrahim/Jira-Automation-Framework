package com.vodafone.jira.jira_api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class IssuesApi extends BaseAPI{

    Session session = new Session();
    private String SESSION_KEY_VALUE = null;

    public Response createIssue(String key, String summary, String description, String issueType) throws IOException {
        SESSION_KEY_VALUE = session.getSessionKey();
        RestAssured.baseURI= JIRA_URL;
        Response response =
                given().
                        header("Content-Type", CONTENT_TYPE_JSON).
                        header("Cookie",SESSION_ID+SESSION_KEY_VALUE).
                        body(createIssue(key,summary,description,issueType)).log().all().
                        when().
                        post(CREATE_ISSUE).
                        then().assertThat().statusCode(CREATED_STATUS_CODE).and().contentType(ContentType.JSON).
                        extract().response();
        isCreatedResponse(response.getStatusCode());
        return response;
    }
}
