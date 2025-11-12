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

public class AddProductAndVerifyQuantity {

	WebDriver driver;
	Logger logger = BaseClass.getLogger();
	HomePage hp;
	ProductsPage pp;
	CartPage cp;
	
	
	@Given("User is on the Home Page")
	public void user_is_on_the_home_page() {
	    driver = BaseClass.getDriver();
	    hp = new HomePage(driver);
	    pp = new ProductsPage(driver);
	    cp = new CartPage(driver);
	}

	@When("User clicks on {string} button for a specific product")
	public void user_clicks_on_button_for_a_specific_product(String string) {
		logger.info("User is on HomePage and view Product");
	    hp.productHome();
	}

	@When("User increases the quantity of the product to {int}")
	public void user_increases_the_quantity_of_the_product_to(Integer int1) {
	    pp.productQuantity("4");
	}

	@When("User clicks on {string} button")
	public void user_clicks_on_button(String string) {
	    pp.clickAddToCart();
	}

	@Then("User navigates to the Cart page")
	public void user_navigates_to_the_cart_page() {
	    pp.viewCartPage();
	}

	@Then("User verifies the cart total matches the product price multiplied by quantity")
	public void user_verifies_the_cart_total_matches_the_product_price_multiplied_by_quantity() {
	    Assert.assertEquals(true, cp.verifyProductTotal());
	}
}
