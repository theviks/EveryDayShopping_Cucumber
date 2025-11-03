Feature: Search Product and Verify Result

  Scenario: Search Product
    Given User navigates to the product page
    When User enters a valid product name in the search box
    And User clicks on the search button
    Then The system should display the product that matches the searched name
