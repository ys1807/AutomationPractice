package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import testCases.TestBase;


public class Shipping {
	
	public WebDriverWait wait;
	
	public String getTermsOfService(WebDriver driver)
	{
		try
		{
			wait = new WebDriverWait(driver, 30);
			
			WebElement termsOfService = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TestBase.prop.getProperty("Shipping_TermsOfService_text"))));
						
			return (termsOfService.getText());
			
		}
		catch(Exception e)
		{
			TestBase.test.log(LogStatus.FAIL, "Exception generated in 'Shipping.getTermsOfService': " + e.getMessage());
			return null;
			
		}
			
	}
	
	
	
	public void click_Shipping_TermsOfServiceCheckbox(WebDriver driver)
	{
		
		try
		{
			wait = new WebDriverWait(driver, 30);
			
			WebElement termsOfServiceCheckbox = driver.findElement(By.id("cgv"));
			
			termsOfServiceCheckbox.click();
		}
		catch(Exception e)
		{
			TestBase.test.log(LogStatus.FAIL, "Exception generated in 'Shipping.clickTermsOfServiceCheckbox': " + e.getMessage());
			Assert.fail("Exception generated in 'Shipping.clickTermsOfServiceCheckbox': " + e.getMessage());
		}
		
	}
	
	
	public void click_Shipping_ProceedToCheckout(WebDriver driver)
	{
		try
		{
			
			wait = new WebDriverWait(driver, 30);
			
			WebElement proceedToCheckoutBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TestBase.prop.getProperty("Shipping_ProceedToCheckout_name"))));
			
			proceedToCheckoutBtn.click();
			
		}
		catch(Exception e)
		{
			TestBase.test.log(LogStatus.FAIL, "Exception generated in 'Shipping.click_Shipping_ProceedToCheckout': " + e.getMessage());
			Assert.fail("Exception generated in 'Shipping.click_Shipping_ProceedToCheckout': " + e.getMessage());
		}
	}

	
	

}
