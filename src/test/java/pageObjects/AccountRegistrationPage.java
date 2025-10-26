package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	//Elements 
	@FindBy(xpath="//input[@placeholder='Name']") WebElement name;
	@FindBy(xpath="//input[@data-qa='signup-email']") WebElement email;
	@FindBy(xpath="//button[normalize-space()='Signup']") WebElement signUp;
	//FormsPage
	@FindBy(xpath="//div[@class='radio-inline']//input[@id='id_gender1']") WebElement gender;
	@FindBy(xpath="//input[@id='password']") WebElement password;
	@FindBy(xpath="//select[@id='days']") WebElement day;
	@FindBy(xpath="//select[@id='months']") WebElement month;
	@FindBy(xpath="//select[@id='years']") WebElement year;
	@FindBy(xpath="//input[@id='first_name']") WebElement firstName;
	@FindBy(xpath="//input[@id='last_name']") WebElement lastName;
	@FindBy(xpath="//p[@class='required form-group']//input[@id='address1']") WebElement address1;
	@FindBy(xpath="//select[@id='country']") WebElement country;
	@FindBy(xpath="//input[@id='state']") WebElement state;
	@FindBy(xpath="//input[@id='city']") WebElement city;
	@FindBy(xpath="//input[@id='zipcode']") WebElement zipCode;
	@FindBy(xpath="//input[@id='mobile_number']") WebElement mobileNo;
	@FindBy(xpath="//button[normalize-space()='Create Account']") WebElement registrationBtn;
	//Verification
	@FindBy(xpath="//b[normalize-space()='Account Created!']") WebElement success;

	//ActionMethods
	public void enterName(String Name) {
		name.sendKeys(Name);
	}
	
	public void enterEmail(String Email) {
		email.sendKeys(Email);
	}
	
	public void clickSignUp() {
		signUp.click();
	}
	
	public void selectGender() {
		gender.click();
	}
	
	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void selectDateOfBirth() {
		Select sc = new Select(day);
		sc.selectByVisibleText("13");
		sc=new Select(month);
		sc.selectByVisibleText("July");
		sc=new Select(year);
		sc.selectByVisibleText("1998");
	}
	public void enterFname(String fName) {
		firstName.sendKeys(fName);
	}
	
	public void enterLname(String lName) {
		lastName.sendKeys(lName);
	}
	
	public void enterAddress(String add,String State,String City,String code) {
		address1.sendKeys(add);
		Select sc=new Select(country);
		sc.selectByVisibleText("Canada");
		state.sendKeys(State);
		city.sendKeys(City);
		zipCode.sendKeys(code);
	}
	
	public void enterPhoneNo(String no) {
		mobileNo.sendKeys(no);
	}
	
	public void clickRegister() {
		JavascriptExecutor js =  (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", registrationBtn);
		registrationBtn.click();
	}
	
	public boolean verifyRegistration() {
		return success.isDisplayed();
	}
	
	
}
