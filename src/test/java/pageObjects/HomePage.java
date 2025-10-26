package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	//Elements
	@FindBy(xpath ="//a[normalize-space()='Signup / Login']") WebElement loginOrRegister;
	
	//Action Methods
	public void clickLoginSignUp() {
		loginOrRegister.click();
	}

}
