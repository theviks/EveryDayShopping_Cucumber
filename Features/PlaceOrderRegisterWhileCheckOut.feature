Feature: Place order with registration and delete account
  As a new user
  I want to register while placing an order
  So that I can buy products and then delete my account

  Scenario: Register during checkout and place order successfully
    Given Navigate to Home page

    When I add products to the cart
    And I click on the "Cart" button
    Then I should see the cart page

    When I click on the Proceed To Checkout button
    And I click on the Register / Login button
    And I fill all required details in Signup and create an account
    Then I should see "ACCOUNT CREATED!" message
    And I click on the "Continue" button
    And I should see "Logged in as <username>" at the top

    When I click on the "Cart" button
    And I click on the "Proceed To Checkout" button
    Then I should see the Address Details and Review Your Order section

    When I enter a comment in the comment text area
    And I click on the "Place Order" button
    And I enter payment details:
      | field           | value              |
      | Name on Card    | Test User          |
      | Card Number     | 4111111111111111   |
      | CVC             | 123                |
      | Expiration Month| 12                 |
      | Expiration Year | 2028               |
    And I click on the "Pay and Confirm Order" button
    Then I should see the success message "Your order has been placed successfully!"

    When I click on the "Delete Account" button
    Then I should see "ACCOUNT DELETED!" message
    And I click on the "Continue" button
