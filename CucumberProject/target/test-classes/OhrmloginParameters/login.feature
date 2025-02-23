
Feature: login functionality

  
  Scenario: Validate login functionality with valid data
  
    Given login page is open
   
    When Valid "username" and "password" is entered
    And login button is clicked
    Then home page should be displayed
    
Feature: login functionality
 
   
 