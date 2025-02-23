Feature: Search Functionality

Scenario: Validating the search functionality with valid query

Given google search page is open
When Query is entered in search
And  enter key is pressed
Then the searched results appear on screen