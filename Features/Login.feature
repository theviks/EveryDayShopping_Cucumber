Feature: Login user
	Scenario: Correct email and password
		Given user clicks on LoginSignUp on HomePage
		When user enters email and password
				|key     |value				|
				|email	 |dsfgdsf@gmail.com	|
				|password|Asdfghjkl@123   	| 
		And Clicks login button
		Then user login should be verified
		And user deletes the account
		
 
