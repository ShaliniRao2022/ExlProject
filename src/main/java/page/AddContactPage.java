package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class AddContactPage extends BasePage {
	
	WebDriver driver;
	
	public AddContactPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//h5[contains(text(),'Add Contact')]") WebElement addContactHeaderElement;
	@FindBy(how = How.XPATH, using = "//input[@id='account']") WebElement fullNameElement;
	@FindBy(how = How.XPATH, using = "//select[@id='cid']") WebElement companyElement;
	@FindBy(how = How.XPATH, using = "//input[@id='email']") WebElement emailElement;
	@FindBy(how = How.XPATH, using = "//input[@id='phone']") WebElement phoneNumElement;
	@FindBy(how = How.XPATH, using = "//input[@id='address']") WebElement addressElement;
	@FindBy(how = How.XPATH, using = "//input[@id='city']") WebElement cityElement;
	@FindBy(how = How.XPATH, using = "//input[@id='state']") WebElement stateElement;
	@FindBy(how = How.XPATH, using = "//input[@id='zip']") WebElement zipcodeElement;
	@FindBy(how = How.XPATH, using = "//select[@id='country']") WebElement countryElement;
	@FindBy(how = How.XPATH, using = "//button[@id='submit']") WebElement saveButtonElement;
	
	
	
	public void validateAddContactPage(String expectedText) {
		
		Assert.assertEquals(addContactHeaderElement.getText(), expectedText, "Page not found!!");
		}
	
	public void insertFullName(String fullName) {
		
		fullNameElement.sendKeys(fullName + generateRandomNum(999));
	}
	
	public void selectCompany(String company) {
		
		selectFromDropdown(companyElement, company);
		
			}
	public void insertEmail(String email) {
		
		emailElement.sendKeys(generateRandomNum(9999) + email);
	}
	public void insertPhoneNumber(String phoneNum) {
		
		phoneNumElement.sendKeys(generateRandomNum(9999)+ phoneNum);;
	}
	public void insertAddress(String address) {
		
		addressElement.sendKeys(address);
	}
	public void insertCity(String city) {
		
		cityElement.sendKeys(city);
	}
	public void insertState(String state) {
		
		stateElement.sendKeys(state);
	}
	public void insertZipcode(String zipcode) {
		
		zipcodeElement.sendKeys(zipcode);
	}
	public void selectCountry(String country) {
	
	selectFromDropdown(countryElement, country);
	}
	public void clickSaveButton() {
		
		saveButtonElement.click();
	}
}	