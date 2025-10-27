package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.RegistrationOrLoginPage;
import pageObjects.HomePage;
import org.apache.logging.log4j.Logger;

public class Registration {

    WebDriver driver;
    HomePage hp;
    RegistrationOrLoginPage ap;
    Logger logger = BaseClass.getLogger();

    String name = BaseClass.randomeString();

    @Given("the user navigates to Register Account Page")
    public void the_user_navigates_to_register_account_page() {
        driver = BaseClass.getDriver();
        logger.info("Navigating to Register Account Page");
        hp = new HomePage(driver);
        hp.clickLoginSignUp();
        ap = new RegistrationOrLoginPage(driver);
    }

    @When("the user enters the details into below fields")
    public void the_user_enters_the_details_into_below_fields() {
        logger.info("Entering Name and Email");
        ap.enterName(name);
        ap.enterEmail(name + "@gmail.com");
    }

    @When("the user clicks on SignUp button")
    public void the_user_clicks_on_sign_up_button() {
        logger.info("Clicking on SignUp Button");
        ap.clickSignUp();
    }

    @When("the user fills the account creation form")
    public void the_user_fills_the_account_creation_form() {
        logger.info("Filling account creation form");
        ap.enterFname(name);
        ap.enterLname(BaseClass.randomeString());
        ap.selectGender();
        ap.enterPassword(BaseClass.randomAlphaNumeric());
        ap.enterAddress("Street 1", "City", "State", "12345");
        ap.enterPhoneNo(BaseClass.randomeNumber());
        ap.clickRegister();
    }

    @Then("account created successfully message should be displayed")
    public void account_created_successfully_message_should_be_displayed() {
        logger.info("Verifying account creation success message");
        Assert.assertTrue(ap.verifyRegistration());
        ap.clickCtnu();
        Assert.assertEquals(name, ap.verifyLogin());
    }

    @When("the user deletes the account")
    public void the_user_deletes_the_account() {
        logger.info("Deleting the account");
        ap.deleteAccountClick();
    }

    @Then("account deleted successfully message should be displayed")
    public void account_deleted_successfully_message_should_be_displayed() {
        logger.info("Verifying account deletion success message");
        Assert.assertTrue(ap.vfDeleteMessage());
    }
}
