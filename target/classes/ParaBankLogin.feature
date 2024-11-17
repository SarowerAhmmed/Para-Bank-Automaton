@Smoke @Regresion @Functional
Feature: login function test
Background:
Given open browser
And go to para bank application

  @Positive @TC_BOL12
  Scenario: as para bank user, login should sucess with valid credential
    
    When put valid user name
    And put valid password
    And click login button
    Then login should pass and logout button should visible

 @Negative @TC_BOL13
  Scenario: as para bank user, login should fail with invalid credential
    
    When put invalid user name
    And put invalid password
    And click login button
    Then login should fail and error msg contains An internal error has occurred and has been logged
  
  @Negative @TC_BOL14
  Scenario: as para bank user, login should fail with null credential
   
    When put null user name
    And put null password
    And click login button
    Then login should fail and error msg contains Please enter a username and password.
    

  