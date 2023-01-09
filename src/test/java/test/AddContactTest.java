package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddContactPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddContactTest {

	WebDriver driver;

	ExcelReader exlRead = new ExcelReader("testData\\TF_TestData.xlsx");

	String userName = exlRead.getCellData("LoginInfo", "UserName", 2);
	String password = exlRead.getCellData("LoginInfo", "Password", 2);
	String dashboardValidationText = exlRead.getCellData("ValidationText", "Text", 2);
	String addContactValidationText = exlRead.getCellData("ValidationText", "Text", 3);
	String fullName = exlRead.getCellData("AddContactInfo", "FullName", 2);
	String company = exlRead.getCellData("AddContactInfo", "CompanyName", 2);
	String email = exlRead.getCellData("AddContactInfo", "Email", 2);
	String phoneNum = exlRead.getCellData("AddContactInfo", "Phone", 2);
	String address = exlRead.getCellData("AddContactInfo", "Address", 2);
	String city = exlRead.getCellData("AddContactInfo", "City", 2);
	String state = exlRead.getCellData("AddContactInfo", "State", 2);
	String zipcode = exlRead.getCellData("AddContactInfo", "Zip", 2);
	String country = exlRead.getCellData("AddContactInfo", "Country", 2);

	@Test
	public void userShouldBeAbleToAddCustomer() throws InterruptedException {

		driver = BrowserFactory.init();

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clickSignInButton();

		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage(dashboardValidationText);
		dashboardPage.clickCustomersButton();
		dashboardPage.clickAddCustomerButton();

		AddContactPage addContactPage = PageFactory.initElements(driver, AddContactPage.class);
		addContactPage.validateAddContactPage(addContactValidationText);
		addContactPage.insertFullName(fullName);
		addContactPage.selectCompany(company);
		addContactPage.insertEmail(email);
		addContactPage.insertPhoneNumber(phoneNum);
		addContactPage.insertAddress(address);
		addContactPage.insertCity(city);
		addContactPage.insertState(state);
		addContactPage.insertZipcode(zipcode);
		addContactPage.selectCountry(country);
		addContactPage.clickSaveButton();
		
		dashboardPage.clickListCustomersButton();

	}
	
	
}
