package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	//Elements
	@FindBy(xpath="//input[@id='susbscribe_email']") WebElement subscription;
	@FindBy(xpath="//button[@id='subscribe']") WebElement subscriptionButton;
	@FindBy(xpath="//div[@class='alert-success alert']") WebElement vfSubscription;
	@FindBy(xpath="//td[@class='cart_description']") List<WebElement> vfProductAdded;
	@FindBy(xpath="//td[@class='cart_price']//p") List<WebElement> prices;
	@FindBy(xpath="//td[@class='cart_quantity']/button") List<WebElement> quantities;
	@FindBy(xpath="//td[@class='cart_total']/p") List<WebElement> cartTotals;
	
	
	//Action Methods
	public void subscription(String email) {
		subscription.sendKeys(email);
	}
	
	public void subscriptionBtn() {
		subscriptionButton.click();
	}
	
	public boolean verifySubscription() {
		return vfSubscription.isDisplayed();
	}
	
	public boolean verifyProductAdded() {
		
	    for (WebElement vfProductAdd : vfProductAdded) {
	         if(!vfProductAdd.isDisplayed()) {
	        	 return false;
	         }
	    }
	    return true;
	}
	
	public boolean verifyProductDescription() {
	    for (WebElement total : cartTotals) {
	        if (total.isDisplayed()) {
	            return true;
	        }
	    }
	    return false;
	}

	
}
