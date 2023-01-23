package com.vodafone.jira.tests;

import com.vodafone.jira.jira_api.BaseAPI;
import com.vodafone.jira.jira_api.IssuesApi;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;

import java.io.IOException;

public class IssueStepDefs {

    IssuesApi issuesApi = new IssuesApi();
    @Given("user enter project key {string}, summary {string}, description {string} and issue type {string}")
    public void userCreateIssueWithProjectKeyAndSummaryAndDescriptionAndIssueType(String projectKey, String summary, String description, String issueType) throws IOException {
        issuesApi.createIssue(projectKey,summary,description,issueType);
    }



}
