@Smoke @Regresion @Functional
Feature: Login function
 

  @Positive @TC_BOL12
  Scenario Outline: As a user of Para bank, login should pass with valid credential
    Given open browser
	  And go to para bank application
    When put valid user name "<User>"
    And put valid password "<Password>"
    And click login button
    Then login should pass and logout button should visible

    Examples: 
       | User      | Password  |
       | Row2_Col1 | Row2_Col2 |
       | Row3_Col1 | Row3_Col2 |
       | Row4_Col1 | Row4_Col2 |
       
