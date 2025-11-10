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
	@FindBy(xpath="//td[@class='cart_price']") List<WebElement> productPrice;
	
	
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
	
	public boolean verifyProductTotal() {
		int quantity = 0;
		int total = 0;
		int cartTotal=0;
		boolean flag = false;
		for(WebElement qty : quantities) {
			quantity = Integer.parseInt(qty.getText());
		}
		for(WebElement pp :productPrice) {
			total = Integer.parseInt(pp.getText().replace("Rs. ", ""));
		}
		for(WebElement ct : cartTotals) {
			cartTotal = Integer.parseInt(ct.getText().replace("Rs. ", ""));
		}
		
		if(quantity*total == cartTotal) {
			flag = true;
		}
		
		return flag;
		
	}

	
}
