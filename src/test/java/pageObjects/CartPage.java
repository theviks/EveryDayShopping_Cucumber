package pageObjects;

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
	
}
