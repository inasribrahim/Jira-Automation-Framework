package com.vodafone.jira.payload;

public class Payload {

    private String summary;
    private String description;
    private IssueType issueType ;
    private Project project;

    public Payload(Project key, String summary , String description , IssueType issueType) {
        this.project = key;
        this.summary = summary;
        this.description = description;
        this.issueType = issueType;
    }

    public String getSummary() {
        return summary;
    }

    public String getDescription() {
        return description;
    }

    public IssueType getIssueType() {
        return issueType;
    }

    public Project getProject() {
        return project;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIssueType(IssueType issueType) {
        this.issueType = issueType;
    }

    public void setProject(Project project) {
        this.project = project;
    }

}
