Feature: Verify Subscription on HomePage
	Scenario: User Enters Email for subscription
		Given User Navigates to HomePage Subscription Input
		When User enters email
		And User Clicks Arrow button
		Then Verify Subscription successful
