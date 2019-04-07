package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import testCases.TestBase;

public class HomePage {
	
	public WebDriverWait wait;
		
	public void hoverOverTopMenu(WebDriver driver, String title)
	{
		try
		{
			wait = new WebDriverWait(driver, 30);
			
	//		System.out.println("XPath: " + TestBase.prop.getProperty("TopMenuTab_title") + title + "']");
			
			WebElement tab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TestBase.prop.getProperty("TopMenuTab_title") + title + "']")));
			
			Actions action = new Actions(driver);
			action.moveToElement(tab).build().perform();
		}
		catch(Exception e)
		{
			TestBase.test.log(LogStatus.FAIL, "Exception generated in 'HomePage.hoverOverTopMenu': " + e.getMessage());
		}
	}
	
	
	public void womenSubMenuClick(WebDriver driver, String title)
	{
		try
		{
			wait = new WebDriverWait(driver, 30);
			
			WebElement subMenulink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TestBase.prop.getProperty("Women_subMenu_title") + title + "'][1]")));
			
			subMenulink.click();
		}
		catch(Exception e)
		{
			TestBase.test.log(LogStatus.FAIL, "Exception generated in 'HomePage.womenSubMenuClick': " + e.getMessage());
		}
	}
	
	
	
	public void hoverOverCart(WebDriver driver)
	{
		
		try
		{
			wait = new WebDriverWait(driver, 30);
		
			WebElement cart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TestBase.prop.getProperty("HomePage_Cart_title"))));
			
			Actions action = new Actions(driver);
			
			action.moveToElement(cart).build().perform();
			
		}
		catch(Exception e)
		{
			TestBase.test.log(LogStatus.FAIL, "Exception generated in 'HomePage.hoverOverCart': " + e.getMessage());
		}
		
		
	}
	
	
	
	
	public void clickCheckout(WebDriver driver)
	{
		try
		{
			
			wait = new WebDriverWait(driver, 30);
			
			WebElement checkOutBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TestBase.prop.getProperty("HomePage_Cart_Checkout_text"))));
				
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", checkOutBtn);
	
		}
		catch(Exception e)
		{
			TestBase.test.log(LogStatus.FAIL, "Exception generated in 'HomePage.clickCheckout': " + e.getMessage());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
