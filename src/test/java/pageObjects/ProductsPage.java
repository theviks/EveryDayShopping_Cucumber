package pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage extends BasePage {

	public ProductsPage(WebDriver driver) {
		super(driver);
	}
	
	//Elements
	@FindBy(xpath="//h2[normalize-space()='All Products']") WebElement vfProductPage;
	@FindBy(css="a[href='/product_details/1']") WebElement viewProduct;
	@FindBy(xpath="//div[@class='product-information']") WebElement productInformation;
	@FindBy(xpath="//input[@id='search_product']") WebElement searchBar;
	@FindBy(xpath="//button[@id='submit_search']") WebElement searchButton;
	@FindBy(xpath="//div[@class='col-sm-4']//div[@class='productinfo text-center']/p") List<WebElement> vfSearchResult;
	
	@FindBy(xpath="(//div[@class='productinfo text-center'])[position() <= 2]//a[contains(.,'Add to cart')]") List<WebElement> addToCart;
	@FindBy(xpath="//button[normalize-space()='Continue Shopping']") WebElement continueShopping;
	@FindBy(xpath="//input[@id='quantity']") WebElement inputQuantity;
	@FindBy(xpath="//button[normalize-space()='Add to cart']") WebElement addToCartBtn;
	@FindBy(xpath="//u[normalize-space()='View Cart']") WebElement viewCart;
	
	
	//Action Methods
	public boolean verifyProductPage() {
		return vfProductPage.isDisplayed();
	}
	
	public void clickViewProduct() {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", viewProduct);
		viewProduct.click();
	}
	
	public boolean productInf() {
		return productInformation.isDisplayed();
	}
	
	String productName;
	
	public void search(String productName) {
		this.productName=productName;
		searchBar.clear();
		searchBar.sendKeys(productName);
	}
	public void clickSearch() {
		searchButton.click();
	}
	
	public boolean verifySearchResult() {
		
		if (!vfSearchResult.isEmpty()) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", vfSearchResult.get(0));
        }
		
		ArrayList<String> product = new ArrayList<>();
		for(WebElement vfSearch : vfSearchResult) {
			product.add(vfSearch.getText());
		}
		
		return product.stream().allMatch(p->p.toLowerCase().contains(productName.toLowerCase()));
		
 	}
	
	public void addProductToCart() {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		for(int i=0;i<addToCart.size();i++) {
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",addToCart.get(i));
			
			wait.until(ExpectedConditions.elementToBeClickable(addToCart.get(i))).click();
			if(continueShopping.isEnabled()) {
				continueShopping.click();
			}
		}

	}
	
	public void productQuantity(String qty) {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",inputQuantity);
		inputQuantity.clear();
		inputQuantity.sendKeys(qty);
	}
	public void clickAddToCart() {
		addToCartBtn.click();
	}
	public void viewCartPage() {
		viewCart.click();
	}
	
}
