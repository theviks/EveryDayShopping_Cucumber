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

public class SearchProduct {

	WebDriver driver;
	Logger logger = BaseClass.getLogger();
	HomePage hp;
	ProductsPage pp;
	
	@Given("User navigates to the product page")
	public void user_navigates_to_the_product_page() {
		logger.info("User Navigates to Product page to search for Product");
	    driver = BaseClass.getDriver();
	    hp = new HomePage(driver);
	    
	    hp.productsPage();
	    pp = new ProductsPage(driver);
	}

	@When("User enters a valid product name in the search box")
	public void user_enters_a_valid_product_name_in_the_search_box() {
	    pp.search("t-shirt");
	}

	@When("User clicks on the search button")
	public void user_clicks_on_the_search_button() {
	    pp.clickSearch();
	}

	@Then("The system should display the product that matches the searched name")
	public void the_system_should_display_the_product_that_matches_the_searched_name() {
	    Assert.assertEquals(true, pp.verifySearchResult());
	}
}
