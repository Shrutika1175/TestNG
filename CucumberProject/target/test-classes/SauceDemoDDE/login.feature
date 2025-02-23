
Feature: login functionality

  
  Scenario Outline: Validate login functionality with valid date
  
    Given login page is open
   
    When Valid "<username>" and "<password>" is entered
    And login button is clicked
    Then home page should be displayed
    
    Examples:
    | username | password |
    |standard_user| secret_sauce |
    |locked_out_user | secret_sauce |
    |problem_user | secret_sauce |
    |performance_glitch_user | secret_sauce |
    |error_user | secret_sauce |
    |visual_user | secret_sauce |