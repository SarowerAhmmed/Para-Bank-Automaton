@Smoke @Regresion @Functional
Feature: Login function
 

  @Positive @TC_BOL12
  Scenario Outline: As a user of Para bank, login should Fail with invalid credential
    Given open browser
	  And go to para bank application
    When put invalid user name "<User>"
    And put invalid password "<Password>"
    And click login button
    Then login should pass and logout button should visible

    Examples: 
       | User      | Password  |
       |safdsfsadf | wefsac    |
       |bbsxdkad   | defea     |
       
       
# 6 steps x 2 (Data set 2)
