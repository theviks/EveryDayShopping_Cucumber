package stepDefinitions;

import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.RegistrationOrLoginPage;

public class existingEmail {

	WebDriver driver;
	Logger logger = BaseClass.getLogger();
	HomePage hp;
	RegistrationOrLoginPage lp;
	
	@Given("User enters Name and Email to Register User")
	public void user_enters_name_and_email_to_register_user() {
	    logger.info("User Navigates to SignUp Page");
	    driver = BaseClass.getDriver();
	    hp = new HomePage(driver);
	    hp.clickLoginSignUp();
	    lp = new RegistrationOrLoginPage(driver);
	    lp.enterName("abcd");
	    lp.enterEmail("sadagsfda@sdfa.com");
	}

	@When("User click SignUp")
	public void user_click_sign_up() {
	    lp.clickSignUp();
	}

	@Then("Error message displays Email already exists")
	public void error_message_displays_email_already_exists() {
	    Assert.assertEquals(true, hp.vfExistingUser());
	}
}
