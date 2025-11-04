package stepDefinitions;

import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;

public class SubscriptionHomePage {

	WebDriver driver;
	Logger logger = BaseClass.getLogger();
	HomePage hp;
	
	@Given("User Navigates to HomePage Subscription Input")
	public void user_navigates_to_home_page_subscription_input() {
		logger.info("User Navigates to the Subscription Input");
	    driver = BaseClass.getDriver();
	    hp = new HomePage(driver);
	}

	@When("User enters email")
	public void user_enters_email() {
	    hp.subscription("sdsfgh@gmail.com");
	}

	@When("User Clicks Arrow button")
	public void user_clicks_arrow_button() {
	    hp.clickSubscription();
	}

	@Then("Verify Subscription successful")
	public void verify_subscription_successful() {
	    Assert.assertEquals(true,hp.verifySubscription());
	}
}
