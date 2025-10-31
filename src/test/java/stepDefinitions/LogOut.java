package stepDefinitions;

import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.HomePage;
import pageObjects.RegistrationOrLoginPage;

public class LogOut {

	WebDriver driver;
	Logger logger = BaseClass.getLogger();
	HomePage hp;
	RegistrationOrLoginPage lp;
	
	
	@Given("User will login with valid credentials")
	public void user_will_login_with_valid_credentials() {
	 
		driver = BaseClass.getDriver();
		logger.info("Navigate to Login Page");
		hp = new HomePage(driver);
		hp.clickLoginSignUp();
		lp = new RegistrationOrLoginPage(driver);
		lp.login("sadagsfda@sdfa.com", "123456789");
		lp.clickLogin();
	}

	@Given("User will click logout")
	public void user_will_click_logout() {
	    hp.clickLogOut();
	}

	@Then("Verify user logout message")
	public void verify_user_logout_message() {
	    Assert.assertEquals(true,hp.vfLogout());
	}
}
