Feature: Account Registration

  Scenario: Successful account registration and deletion
    Given the user navigates to Register Account Page
    When the user enters the details into below fields
    And the user clicks on SignUp button
    And the user fills the account creation form
    Then account created successfully message should be displayed
    And the user deletes the account
    And account deleted successfully message should be displayed
