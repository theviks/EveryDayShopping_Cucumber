package stepDefinitions;

import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.ProductsPage;
import pageObjects.RegistrationOrLoginPage;

public class PlaceOrderRegisterWhileCheckOut {

	WebDriver driver;
	Logger logger = BaseClass.getLogger();
	HomePage hp;
	RegistrationOrLoginPage rp;
	CartPage cp;
	ProductsPage pp;
	
	
	@Given("Navigate to Home page")
	public void navigate_to_home_page() {
	    driver = BaseClass.getDriver();
	    hp= new HomePage(driver);
	    rp = new RegistrationOrLoginPage(driver);
	    pp = new ProductsPage(driver);
	}


	@When("I add products to the cart")
	public void i_add_products_to_the_cart() {
	    pp.addProductToCart();
	}

	@When("I click on the {string} button")
	public void i_click_on_the_button(String string) {
	    hp.cartPage();
	}

	@Then("I should see the cart page")
	public void i_should_see_the_cart_page() {
	    Assert.assertEquals(true, cp.verifyCartPage());
	}
	
	@When ("I click on the Proceed To Checkout button")
	public void i_click_on_CheckOut_button() {
		cp.clikCheckOut();
	}
    @When ("I click on the Register / Login button")
    public void click_on_Register_loginButon(){
    	cp.clickRegisterLogin();
    }

	@When("I fill all required details in Signup and create an account")
	public void i_fill_all_required_details_in_signup_and_create_an_account() {
	    
	}

	@Then("I should see {string} message")
	public void i_should_see_message(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("I click on the {string} button")
	public void i_click_on_the_button1(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("I should see {string} at the top")
	public void i_should_see_at_the_top(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("I should see the Address Details and Review Your Order section")
	public void i_should_see_the_address_details_and_review_your_order_section() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I enter a comment in the comment text area")
	public void i_enter_a_comment_in_the_comment_text_area() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I enter payment details:")
	public void i_enter_payment_details(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	    throw new io.cucumber.java.PendingException();
	}

	@Then("I should see the success message {string}")
	public void i_should_see_the_success_message(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
}
