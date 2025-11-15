package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends BasePage {

	public PaymentPage(WebDriver driver) {
		super(driver);
	}
	//Elements
	@FindBy(xpath="//form[@action='/payment']//input[@name='name_on_card']") WebElement nameOnCard;
	@FindBy(xpath="//form[@action='/payment']//input[@name='card_number']") WebElement cardNo;
	@FindBy(xpath="//form[@action='/payment']//input[@name='cvc']") WebElement cvc;
	@FindBy(xpath="//form[@action='/payment']//input[@name='expiry_month']") WebElement expiryMonth;
	@FindBy(xpath="//form[@action='/payment']//input[@name='expiry_year']") WebElement expiryYear;
	@FindBy(xpath="//form[@action='/payment']//button[@id='submit']") WebElement paymentBtn;
	@FindBy(xpath="//p[normalize-space()='Congratulations! Your order has been confirmed!']") WebElement orderConfirmation;
	@FindBy(xpath="//a[normalize-space()='Continue']") WebElement confirmationCtnu;
	@FindBy(xpath="//a[normalize-space()='Download Invoice']") WebElement downloadInvoice;
	
	//Action Methods
	public void cardDetails(String name, String cardNum, String cvcNum, String expiryMon, String expiryYr) {
		nameOnCard.clear();
		cardNo.clear();
		cvc.clear();
		expiryMonth.clear();
		expiryYear.clear();
		
		nameOnCard.sendKeys(name);
		cardNo.sendKeys(cardNum);
		cvc.sendKeys(cvcNum);
		expiryMonth.sendKeys(expiryMon);
		expiryYear.sendKeys(expiryYr);
	}
	
	public void clickPayment() {
		paymentBtn.click();
	}
	
	public boolean verifyOrderConfirmation() {
		return orderConfirmation.isDisplayed();
	}
	
	public void clickCtnu() {
		confirmationCtnu.click();
	}
	
	public void invoice() {
		downloadInvoice.click();
	}
	
	
	
	
	
	
}
