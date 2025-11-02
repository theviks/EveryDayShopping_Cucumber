package stepDefinitions;

import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.ProductsPage;

public class Products {

	WebDriver driver;
	Logger logger = BaseClass.getLogger();
	HomePage hp;
	ProductsPage pp;
	
	@Given("User navigates to the Products page")
	public void user_navigates_to_the_products_page() {
	    driver = BaseClass.getDriver();
	    logger.info("User Navigates to Products Page");
	    hp = new HomePage(driver);
	    
	    hp.productsPage();
	    
	    pp = new ProductsPage(driver);
	}

	@When("User verifies that they are on the All Products page")
	public void user_verifies_that_they_are_on_the_all_products_page() {
	    Assert.assertEquals(true, pp.verifyProductPage());
	}

	@When("User clicks on the {string} button of the first product")
	public void user_clicks_on_the_viewButton_of_the_first_product(String string) {
	   pp.clickViewProduct();
	}


	@Then("All product details such as name, category, price, availability, condition and brand")
	public void all_product_details_such_as_name_category_price_availability_condition_and_brand() {
	    Assert.assertEquals(true, pp.productInf());
	}
}
