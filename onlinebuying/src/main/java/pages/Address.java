package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import testCases.TestBase;

public class Address {
	
	public WebDriverWait wait;
	
	public void click_Address_ProceedToCheckout(WebDriver driver)
	{
		try
		{
			
			wait = new WebDriverWait(driver, 30);
			
			WebElement proceedToCheckoutBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TestBase.prop.getProperty("Address_ProceedToCheckout_name"))));
			
			proceedToCheckoutBtn.click();
			
		}
		catch(Exception e)
		{
			TestBase.test.log(LogStatus.FAIL, "Exception generated in 'Address.click_Address_ProceedToCheckout': " + e.getMessage());
			Assert.fail("Exception generated in 'Address.click_Address_ProceedToCheckout': " + e.getMessage());
		}
	}

}
