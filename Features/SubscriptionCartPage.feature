Feature: Verify Subscription on CartPage
	Scenario: User Enters Email for subscription
		Given User Navigates to CartPage Subscription Input
		When User enters email for Subscription
		And User Clicks Arrow button to Subscribe
		Then Verify Subscription successful Message
