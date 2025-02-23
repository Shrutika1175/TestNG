
Feature: Validation of links on the page
  Background: 
    Given Google page is open

  Scenario: Validation of About link
    When About Link is clicked
    Then It should navigate to about page

  Scenario: validation of Business link
    When Business link is clicked
    Then It should navigate to Business page
