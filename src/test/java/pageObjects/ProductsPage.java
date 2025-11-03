package pageObjects;

import java.util.ArrayList;
import java.util.List;

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
	@FindBy(xpath="//input[@id='search_product']") WebElement searchBar;
	@FindBy(xpath="//button[@id='submit_search']") WebElement searchButton;
	@FindBy(xpath="//div[@class='col-sm-4']//div[@class='productinfo text-center']/p") List<WebElement> vfSearchResult;
	
	
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
}
