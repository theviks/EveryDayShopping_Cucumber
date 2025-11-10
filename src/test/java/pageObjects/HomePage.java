package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	//Elements
	@FindBy(xpath ="//a[normalize-space()='Signup / Login']") WebElement loginOrRegister;
	@FindBy(xpath = "//a[normalize-space()='Logout']") WebElement logout;
	@FindBy(xpath="//p[normalize-space()='Email Address already exist!']") WebElement emailExist;
	@FindBy(xpath="//a[normalize-space()='Contact us']") WebElement contactUs;
	@FindBy(xpath="//a[@href='/products']") WebElement products;
	@FindBy(xpath="//input[@id='susbscribe_email']") WebElement subscriptionInput;
	@FindBy(xpath="//button[@id='subscribe']") WebElement subscriptionBtn;
	@FindBy(xpath="//div[@class='alert-success alert']") WebElement vfSubscription;
	@FindBy(xpath="//a[normalize-space()='Cart']") WebElement cartPage;
	@FindBy(xpath="(//div[@class='choose'])[position()=1]//a[contains(.,'View Product')]") WebElement productHome;
 	
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
	//products Page
	public void productsPage() {
		products.click();
	}
	//Subscription
	public void subscription(String mail) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", subscriptionInput);
		subscriptionInput.sendKeys(mail);
	}
	
	public void clickSubscription() {
		subscriptionBtn.click();
	}
	
	public boolean verifySubscription() {
		return vfSubscription.isDisplayed();
	}
	
	public void cartPage() {
		cartPage.click();
	}
	
	public void productHome() {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", productHome);
		WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(10));
		myWait.until(ExpectedConditions.elementToBeClickable(productHome)).click();
	}
	
}
