package stepDefinitions;

import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.RegistrationOrLoginPage;

public class Login {

	WebDriver driver;
	Logger logger = BaseClass.getLogger();
	HomePage hp;
	RegistrationOrLoginPage lp;
	
	
	@Given("user clicks on LoginSignUp on HomePage")
	public void user_clicks_on_login_sign_up_on_home_page() {
	    driver =BaseClass.getDriver();
	    logger.info("Navigate to Login Account Page");
	    hp = new HomePage(driver);
	    hp.clickLoginSignUp();
	    lp = new RegistrationOrLoginPage(driver);
	}

	@When("user enters email and password")
	public void user_enters_email_and_password(DataTable dataTable) {
		
		Map<String,String> dataMap=dataTable.asMap(String.class,String.class);
		
		lp.login(dataMap.get("email"), dataMap.get("password"));
	}

	@When("Clicks login button")
	public void clicks_login_button() {
	   lp.clickLogin();
	}

	@Then("user login should be verified")
	public void user_login_should_be_verified() {
	    String name = lp.verifyLogin();
	    if(name.equals("opencart_bash")) {
	    	Assert.assertTrue(true);
	    }else {
	    	Assert.assertTrue(false);
	    }
	    
	}

	@Then("user deletes the account")
	public void user_deletes_the_account() {
		lp.deleteAccountClick();
		Assert.assertEquals(true, lp.vfDeleteMessage());
	}
}
