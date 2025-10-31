Feature: Registering User with Existing Email Id
	Scenario: User try register new account with existing Email
		Given User enters Name and Email to Register User
		When User click SignUp
		Then Error message displays Email already exists