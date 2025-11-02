Feature: Contact Us Form
	Scenario: User fills the contact us form
		Given User navigates to Contact us Form
		When Verify Get in Touch is Visible
		When User Enters the contact Us form details
		And User Press the submit button
		Then Verify Successful Submition message
