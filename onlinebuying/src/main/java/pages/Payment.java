package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import testCases.TestBase;

public class Payment {
	
	public WebDriverWait wait;
	
	public String getProductName(WebDriver driver)
	{
		try
		{
			wait = new WebDriverWait(driver, 30);
			
			WebElement productName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TestBase.prop.getProperty("Payment_ProductName_class"))));

			return (productName.getText().trim());			
			
		}
		catch(Exception e)
		{
			TestBase.test.log(LogStatus.FAIL, "Exception generated in 'Payment.getProductName': " + e.getMessage());
			return null;		
		}
	}
	
	
	public String getProductSize(WebDriver driver)
	{
		try
		{
			wait = new WebDriverWait(driver, 30);
			
			WebElement productSize = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TestBase.prop.getProperty("Payment_ProductColourAndSize_class"))));
			
			String[] txt = productSize.getText().split(",");
			
			return (txt[1].trim());			
			
		}
		catch(Exception e)
		{
			TestBase.test.log(LogStatus.FAIL, "Exception generated in 'Payment.getProductSize': " + e.getMessage());
			return null;		
		}
	}
	
	
	public String getProductPrice(WebDriver driver)
	{
		try
		{
			wait = new WebDriverWait(driver, 30);
			
			WebElement productPrice = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TestBase.prop.getProperty("Payment_ProductPrice_class"))));

			return (productPrice.getText().trim());			
			
		}
		catch(Exception e)
		{
			TestBase.test.log(LogStatus.FAIL, "Exception generated in 'Payment.getProductPrice': " + e.getMessage());
			return null;		
		}
	}
	
	
	public String getProductQuantity(WebDriver driver)
	{
		try
		{
			wait = new WebDriverWait(driver, 30);
			
			WebElement productQuantity = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TestBase.prop.getProperty("Payment_Quantity_class"))));

			return (productQuantity.getText().trim());			
			
		}
		catch(Exception e)
		{
			TestBase.test.log(LogStatus.FAIL, "Exception generated in 'Payment.getProductQuantity': " + e.getMessage());
			return null;		
		}
	}
	
	

}
