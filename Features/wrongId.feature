Feature: User Login with Invalid Credentials
  As an application user
  I want to be notified when I enter incorrect email or password
  So that I can correct my login details

  Scenario: Login attempt with incorrect email or password
    Given the user is on the Login or SignUp page
    When the user enters an invalid email and/or invalid password
    And the user clicks on the Login button
    Then an error message should be displayed indicating "email or password is incorrect"
