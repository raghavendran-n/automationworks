Feature: Developing automation framework for Automation Exercise site
  @TC_01
  Scenario: Automation Exercise Site
    Given user is on automation exercise site
    When user hits sign in
    And enters username and password
    And hits login button
    Then user lands in homepage
		When user navigates to PDP
		And adds product into cart
		Then navigates to cart page
		When user verifies cart addition
		And navigates to checkout
		Then verifies checkout details