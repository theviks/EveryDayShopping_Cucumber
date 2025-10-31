Feature: Logout user
	Scenario: Exesting user will logout
		Given  User will login with valid credentials
		And User will click logout
		Then Verify user logout message
