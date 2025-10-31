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

public class IncorrectEmailOrPassword {

	WebDriver driver;
	HomePage hp;
	RegistrationOrLoginPage lp;
	Logger logger = BaseClass.getLogger();
	
	@Given("the user is on the Login or SignUp page")
	public void the_user_is_on_the_login_or_sign_up_page() {
	   driver = BaseClass.getDriver();
	   logger.info("Navigate to Login Account Page");
	   hp = new HomePage(driver);
	   hp.clickLoginSignUp();
	   lp = new RegistrationOrLoginPage(driver);
	}

	@When("the user enters an invalid email and\\/or invalid password")
	public void the_user_enters_an_invalid_email_and_or_invalid_password() {
	    lp.login("sdfasfd@gmail.comn", "sadfasdf");
	}

	@When("the user clicks on the Login button")
	public void the_user_clicks_on_the_login_button() {
	    lp.clickLogin();
	}

	@Then("an error message should be displayed indicating {string}")
	public void an_error_message_should_be_displayed_indicating(String string) {
		Assert.assertEquals(true, lp.vfIncorrectData());
	}
}
