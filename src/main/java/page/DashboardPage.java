package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class DashboardPage {
	
	WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'Dashboard')]") WebElement dashBoardHeaderElement;
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Customers')]") WebElement customersElement;
	@FindBy(how = How.XPATH, using = "//a[text()='Add Customer']") WebElement addCustomerElement;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'List Customers')]") WebElement listCustomersElement;
	
	public void validateDashboardPage(String expectedText) {
		
		Assert.assertEquals(dashBoardHeaderElement.getText(), expectedText, "Page not found!!");
	
	}
	public void clickCustomersButton() {
		
		customersElement.click();
	}
    public void clickAddCustomerButton() {
		
		addCustomerElement.click();
	}
    public void clickListCustomersButton() throws InterruptedException {
    	    	
    	Thread.sleep(2000);
		listCustomersElement.click();
	}
	
}

