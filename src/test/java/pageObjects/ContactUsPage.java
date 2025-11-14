package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends BasePage {

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}
	
	//Elements 
	@FindBy(xpath="//h2[normalize-space()='Get In Touch']") WebElement vfGetInTouch;
	@FindBy(xpath="//input[@placeholder='Name']") WebElement name;
	@FindBy(xpath="//input[@placeholder='Email']") WebElement email;
	@FindBy(xpath="//input[@placeholder='Subject']") WebElement subject;
	@FindBy(xpath="//textarea[@id='message']") WebElement message;
	@FindBy(xpath="//input[@name='upload_file']") WebElement uploadFile;
	@FindBy(xpath="//input[@name='submit']") WebElement submit;
	@FindBy(xpath="//div[@class='status alert alert-success']") WebElement vfSubmition;
	
	//Action Methods
	public boolean verifyGetInTouch() {
		return vfGetInTouch.isDisplayed();
	}
	
	public void enterName(String Name) {
		this.name.sendKeys(Name);
	}
	
	public void enterEmail(String Email) {
		this.email.sendKeys(Email);
	}
	
	public void enterSubject(String sub) {
		this.subject.sendKeys(sub);
	}
	
	public void enterMessage(String msg) {
		this.message.sendKeys(msg);
	}
	
	public void file() {
		this.uploadFile.sendKeys("");
	}
	public void clickSubmit() {
		submit.click();
		driver.switchTo().alert().accept();
	}
	
	public boolean verifySubmition() {
		return vfSubmition.isDisplayed();
	}
	
}

