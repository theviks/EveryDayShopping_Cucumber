package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class Registration {

	WebDriver driver;
	HomePage hp;
	AccountRegistrationPage ap ;
	
	@Given("the user navigates to Register Account Page")
	public void the_user_navigates_to_register_account_page() {
		driver= BaseClass.getDriver();
		hp = new HomePage(driver);
		hp.clickLoginSignUp();
		
		ap = new AccountRegistrationPage(driver);
	}

	@When("the user enters the details into below fields")
	public void the_user_enters_the_details_into_below_fields() {
	    ap.enterName("sadfasdf");
	    ap.enterEmail("dfgdasfgds@gmail.com");
	}

	@When("the user clicks in SignUp button")
	public void the_user_clicks_in_sign_up_button() {
	    ap.clickSignUp();
	}

	@When("the user will fill form for account cration")
	public void the_user_will_fill_form_for_account_cration() {
	    ap.enterFname("John");
	    ap.enterLname("Kenedy");
	    ap.selectGender();
	    ap.enterPassword("sdfasdfasdfadsf");
	    ap.enterAddress("sadfa", "sdfas", "asdfsadf", "asdfsadf");
	    ap.enterPhoneNo("11234567780");
	    ap.clickRegister();
	}

	@Then("account created successfully message")
	public void account_created_successfully_message() {
		Assert.assertEquals(true,ap.verifyRegistration());
	}
}
