@UI @Regression @Products
Feature: Verify All Products and Product Details Page
  As a user
  I want to view all available products
  So that I can verify their details on the product details page

  Background:
    Given User navigates to the Products page

  Scenario: Verifying Product Details on the Product Details Page
    When User verifies that they are on the All Products page
    And User clicks on the 'View Product' button of the first product
    And All product details such as name, category, price, availability, condition and brand
