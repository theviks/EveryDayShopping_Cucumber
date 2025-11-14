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
	
	
	
}
