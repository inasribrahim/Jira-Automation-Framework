package com.vodafone.jira.jira_api;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vodafone.jira.payload.Fields;
import com.vodafone.jira.payload.IssueType;
import com.vodafone.jira.payload.Payload;
import com.vodafone.jira.payload.Project;

public class BaseAPI{
    protected final String JIRA_URL = "http://localhost:8080";
    protected final String RESOURCE_AUTH = "/rest/auth/1/session";
    protected final String CREATE_ISSUE = "/rest/api/2/issue/";
    protected final String CONTENT_TYPE_JSON = "application/json";
    protected final String SESSION_ID = "JSESSIONID=";
    protected final int OK_STATUS_CODE = 200;
    protected final int CREATED_STATUS_CODE = 201;
    protected final int BAD_REQUEST = 400;
    protected final int UNAUTHORIZED = 401;
    protected final int FORBIDDEN = 403;
    protected final int NOT_FOUND = 404;
    protected final int METHOD_NOT_ALLOWED = 405;
    String WksMASDL212321312= "";
    CredentialsPayload credentialsPayload ;
    Project project ;
    IssueType issueType ;
    Payload payload ;
    Fields fields;

    protected void isSuccessfulResponse(int actualStatusCode) throws IOException {
        if (actualStatusCode != OK_STATUS_CODE) {
            throw new IOException("Request Failed with status code= "+actualStatusCode);
        }
    }

    protected void isBadRequest(int actualStatusCode) throws IOException {
        if (actualStatusCode == BAD_REQUEST) {
            throw new IOException("Request Failed with status code= "+actualStatusCode);
        }
    }

    protected void isUnAuthorizedRequest(int actualStatusCode) throws IOException {
        if (actualStatusCode == UNAUTHORIZED) {
            throw new IOException("Request Failed with status code= "+actualStatusCode);
        }
    }

    protected void isNotFoundResponse(int actualStatusCode) throws IOException {
        if (actualStatusCode == NOT_FOUND) {
            throw new IOException("Request Failed with status code= "+actualStatusCode);
        }
    }

    protected void isMethodNotAllowedResponse(int actualStatusCode) throws IOException {
        if (actualStatusCode == METHOD_NOT_ALLOWED) {
            throw new IOException("Request Failed with status code= "+actualStatusCode);
        }
    }

    protected void isForbiddenResponse(int actualStatusCode) throws IOException {
        if (actualStatusCode == FORBIDDEN) {
            throw new IOException("Request Failed with status code= "+actualStatusCode);
        }
    }

    protected void isCreatedResponse(int actualStatusCode) throws IOException {
        if (actualStatusCode == CREATED_STATUS_CODE) {
            throw new IOException("Request Failed with status code= "+actualStatusCode);
        }
    }

    protected String createAuthenticateLoginJsonPayload(String username, String password){
        credentialsPayload = new CredentialsPayload(username,password);
        ObjectMapper objMapper = new ObjectMapper();
        String username_password_json = null ;
        try {
            username_password_json = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(credentialsPayload);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return username_password_json;
    }

    protected String createIssueJsonPayload(String key , String summaryName , String descriptionName , String issueTypeName){
        project = new Project(key);
        issueType = new IssueType(issueTypeName);
        payload = new Payload(project,summaryName,descriptionName,issueType);
        fields = new Fields(payload);
        ObjectMapper objMapper = new ObjectMapper();
        String issue_json = null ;
        try {
            issue_json = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(fields);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return issue_json;
    }
//any thing
}
