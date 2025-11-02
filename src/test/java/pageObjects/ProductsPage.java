package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage {

	public ProductsPage(WebDriver driver) {
		super(driver);
	}
	
	//Elements
	@FindBy(xpath="//h2[normalize-space()='All Products']") WebElement vfProductPage;
	@FindBy(css="a[href='/product_details/1']") WebElement viewProduct;
	@FindBy(xpath="//div[@class='product-information']") WebElement productInformation;
	
	
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
	
}
