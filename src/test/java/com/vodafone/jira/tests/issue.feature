Feature: create issue in jira using jira api

    Scenario Outline:create issues in jira board
    	Given user enter project key "<projectKey>", summary "<summary>", description "<description>" and issue type "<issueType>"

    Examples:
      | projectKey                |summary                                           | description                                  | issueType |
      | Vodafone-Test-Automation |  create any task related automation project      | create any task related automation project    |   task    |