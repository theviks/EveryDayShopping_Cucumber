package stepDefinitions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CartPage;
import pageObjects.HomePage;

public class SubscriptionCartPage {

	WebDriver driver;
	Logger logger = BaseClass.getLogger();
	HomePage hp;
	CartPage cp;
	
	@Given("User Navigates to CartPage Subscription Input")
	public void user_navigates_to_cart_page_subscription_input() {
	    
	}

	@When("User enters email for Subscription")
	public void user_enters_email_for_subscription() {
	    
	}

	@When("User Clicks Arrow button to Subscribe")
	public void user_clicks_arrow_button_to_subscribe() {
	    
	}

	@Then("Verify Subscription successful Message")
	public void verify_subscription_successful_message() {
	    
	}
}
