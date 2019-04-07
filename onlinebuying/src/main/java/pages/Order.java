package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import testCases.TestBase;

public class Order {
	
	WebDriverWait wait;
	
	public void clickProceedToCheckout(WebDriver driver)
	{
		try
		{
			
			wait = new WebDriverWait(driver, 30);
			
			WebElement proceedToCheckoutBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TestBase.prop.getProperty("Order_ProceedToCheckout_text"))));
				
			TestBase.scrollingToElement(driver, proceedToCheckoutBtn);
			
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", proceedToCheckoutBtn);
			
		}
		catch(Exception e)
		{
			TestBase.test.log(LogStatus.FAIL, "Exception generated in 'Order.clickProceedToCheckout': " + e.getMessage());
		}
		
		
		
	}

}
