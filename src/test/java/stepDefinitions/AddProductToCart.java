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

public class AddProductToCart {

	WebDriver driver;
	Logger logger = BaseClass.getLogger();
	HomePage hp;
	ProductsPage pp;
	CartPage cp;
	
	@Given("user navigates to product page")
	public void user_navigates_to_product_page() {
	    logger.info("User Navigates to Products Page");
		driver = BaseClass.getDriver();
	    hp = new HomePage(driver);
	    hp.productsPage();
	    pp = new ProductsPage(driver);
	    cp = new CartPage(driver);
	}

	@When("user adds product to cart")
	public void user_adds_product_to_cart() {
	    pp.addProductToCart();
	}

	@When("user navigates to cart page")
	public void user_navigates_to_cart_page() {
	    hp.cartPage();
	}
	
	@Then("verify both products added to cart")
	public void verify_product_added_to_cart() {
		Assert.assertEquals(true, cp.verifyProductAdded());
	}

	@Then("verify products in cart and the details")
	public void verify_products_in_cart_and_the_details() {
		Assert.assertEquals(true, cp.verifyProductDescription());
	}



}
