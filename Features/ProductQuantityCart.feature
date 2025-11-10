Feature: Verify product quantity and total price in cart

  Scenario: User adds product to cart and verifies cart total
    Given User is on the Home Page
    When User clicks on "View Product" button for a specific product
    And User increases the quantity of the product to 4
    And User clicks on "Add to Cart" button
    Then User navigates to the Cart page
    And User verifies the cart total matches the product price multiplied by quantity
