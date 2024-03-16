Feature: Functionality for Amazon E-commerce Website

Background:
Given I am on the Amazon Home page

Scenario: Adding a “Monitor” Item in Cart and verifying sub total

When I have entered product 'Monitor' and press enter
Then I select and click first item of the list
Then Add the item to cart by clicking on Add to Cart on Products details Page
Then click on cart to open cart page
Then verify that item price and sub total price are same


Scenario: Adding a “Laptop” Item in Cart and verifying sub total

When I have entered product 'Laptop' and press enter
Then I select and click second item of the list
Then Add the item to cart by clicking on Add to Cart on Products details Page
Then click on cart to open cart page
Then verify that item price and sub total price are same



Scenario: Adding two items in Cart and verifying sub total

When I have entered product 'Headphones' and press enter
Then I select and click first item of the list
Then Add the item to cart by clicking on Add to Cart on Products details Page
Then click on cart to open cart page
When I have entered product 'Keyboard' and press enter
Then I select and click first item of the list
Then Add the item to cart by clicking on Add to Cart on Products details Page
Then click on cart to open cart page
Then verify that item price and sub total price are calculated correctly