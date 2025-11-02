package stepDefinitions;

import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.ContactUsPage;

public class contactUs {

	WebDriver driver;
	Logger logger = BaseClass.getLogger();
	HomePage hp;
	ContactUsPage cp;
	
	@Given("User navigates to Contact us Form")
	public void user_navigates_to_contact_us_form() {
		driver = BaseClass.getDriver();
	    hp = new HomePage(driver);
	    hp.contactUs();
	     cp = new ContactUsPage(driver);
	}

	@When("Verify Get in Touch is Visible")
	public void verify_get_in_touch_is_visible() {
	   Assert.assertEquals(true, cp.verifyGetInTouch());
	}

	@When("User Enters the contact Us form details")
	public void user_enters_the_contact_us_form_details() {
	    cp.enterName("Open_Cart");
	    cp.enterEmail("sdfgh@ssd.com");
	    cp.enterSubject("open open");
	    cp.enterMessage("dsfasfd dfadf aeregrfv  rwa sfzget ");
	    
	}

	@When("User Press the submit button")
	public void user_press_the_submit_button() {
	    cp.clickSubmit();
	}

	@Then("Verify Successful Submition message")
	public void verify_successful_submition_message() {
	    cp.verifySubmition();
	}
}
