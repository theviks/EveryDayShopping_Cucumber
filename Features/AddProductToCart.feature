Feature: Adding Products to Cart and Verifying Cart Page

  Scenario: User adds Products to Cart
    Given user navigates to product page
    When user adds product to cart
    And user navigates to cart page
    Then verify both products added to cart
    Then verify products in cart and the details
