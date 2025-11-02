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
	@FindBy(xpath = "//a[normalize-space()='Logout']") WebElement logout;
	@FindBy(xpath="//p[normalize-space()='Email Address already exist!']") WebElement emailExist;
	@FindBy(xpath="//a[normalize-space()='Contact us']") WebElement contactUs;
	
	//Action Methods
	public void clickLoginSignUp() {
		loginOrRegister.click();
	}
	
	public void clickLogOut() {
		logout.click();
	}

	//Verify logOut
	public boolean vfLogout() {
		return loginOrRegister.isDisplayed();
	}
	
	//Verify Existing user
	public boolean vfExistingUser() {
		return emailExist.isDisplayed();
	}
	
	//contactUs
	public void contactUs() {
		contactUs.click();
	}
}
