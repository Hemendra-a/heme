Feature: Login

  Scenario: user Login with valid credentials
    Given user is on login page
    When user add login_id "test" and password "test1234"
    And click on login button
    Then user successfully logged in and navigate to task screen

  Scenario: user Login failed with invalid loginId
    Given user is on login page
    When user add login_id "xyz" and password "test@1234"
    And click on login button
    Then user get an error message failed to login
    
  Scenario: user Login failed with invalid password
    Given user is on login page
    When user add login_id "test" and password "Pass@12345"
    And click on login button
    Then user get an error message failed to login
    
  Scenario: user Login failed with invalid loginId and invalid password
    Given user is on login page
    When user add login_id "test" and password "test12345"
    And click on login button
    Then user get an error message failed to login