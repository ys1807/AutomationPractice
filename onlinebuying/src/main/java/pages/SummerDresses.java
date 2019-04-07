package pages;

import java.awt.Desktop.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import testCases.TestBase;

public class SummerDresses {
	
	public WebDriverWait wait;
	
	public void hoverOverProduct(WebDriver driver, String title)
	{
		
		wait = new WebDriverWait(driver, 30);
		
//		System.out.println(TestBase.prop.getProperty("SummerDress_productTitle")+ title +"')]");
		
		try
		{
			WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TestBase.prop.getProperty("SummerDress_productTitle")+ title +"')]")));
			
			TestBase.scrollingToElement(driver,product);
			
			Actions action = new Actions(driver);
			
			action.moveToElement(product).build().perform();
		}
		catch(Exception e)
		{
			TestBase.test.log(LogStatus.FAIL, "Exception generated in 'SummerDresses.hoverOverProduct': " + e.getMessage());
		}
	}
	
	
	public void clickQuickView(WebDriver driver, String title)
	{
		try
		{
			wait = new WebDriverWait(driver, 30);
			
			WebElement quickview = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TestBase.prop.getProperty("SummerDress_QuickViewTitle_Part1") + title + TestBase.prop.getProperty("SummerDress_QuickViewTitle_Part2"))));
			
			quickview.click();
		}
		catch(Exception e)
		{
			TestBase.test.log(LogStatus.FAIL, "Exception generated in 'SummerDresses.clickQuickView': " + e.getMessage());
		}
	}
	
	public boolean visibilitySizeDropdown(WebDriver driver)
	{
		
		try
		{
			driver.switchTo().frame(0);
			
			WebElement sizeDD = driver.findElement(By.cssSelector(TestBase.prop.getProperty("SummerDress_Size_css")));
			
			if(sizeDD!=null)
			{
				driver.switchTo().defaultContent();
				return true;

			}
			else
			{
				driver.switchTo().defaultContent();
				return false;
			}
		}
		catch(Exception e)
		{
			driver.switchTo().defaultContent();
			TestBase.test.log(LogStatus.FAIL, "Exception generated in 'SummerDresses.visibilitySizeDropdown': " + e.getMessage());
			return false;
		}
		
	}
	
	
	public void selectProductSize(WebDriver driver, String sizeText)
	{
		
		try
		{
			driver.switchTo().frame(0);
			
			WebElement sizeDD = driver.findElement(By.cssSelector(TestBase.prop.getProperty("SummerDress_Size_css")));
			
			Select sel = new Select(sizeDD);
			sel.selectByVisibleText(sizeText);
			
			driver.switchTo().defaultContent();
		}
		catch(Exception e)
		{
			driver.switchTo().defaultContent();
			TestBase.test.log(LogStatus.FAIL, "Exception generated in 'SummerDresses.selectProductSize': " + e.getMessage());
		}
			
	}
	
	public String getProductPrice(WebDriver driver)
	{
		
		try
		{
			driver.switchTo().frame(0);
			
			WebElement productPrice = driver.findElement(By.xpath(TestBase.prop.getProperty("SummerDress_ProductPrice_id")));
			
			String price = productPrice.getText().trim();
			
			driver.switchTo().defaultContent();
			
			return price;
		}
		catch(Exception e)
		{
			driver.switchTo().defaultContent();
			TestBase.test.log(LogStatus.FAIL, "Exception generated in 'SummerDresses.getProductPrice': " + e.getMessage());
			return null;
		}
			
	}
	
	
	public String getProductQuantity(WebDriver driver)
	{
		
		try
		{
			driver.switchTo().frame(0);
			
			WebElement productQuantity = driver.findElement(By.xpath(TestBase.prop.getProperty("SummerDress_ProductQuantity")));
			
			String quantity = productQuantity.getAttribute("value").trim();
			
			driver.switchTo().defaultContent();
			
			return quantity;
		}
		catch(Exception e)
		{
			driver.switchTo().defaultContent();
			TestBase.test.log(LogStatus.FAIL, "Exception generated in 'SummerDresses.getProductQuantity': " + e.getMessage());
			return null;
		}
	}
	
		

	public void clickAddToCart(WebDriver driver)
	{
		try
		{
			driver.switchTo().frame(0);
			
			WebElement addtocart = driver.findElement(By.xpath(TestBase.prop.getProperty("SummerDress_AddToCart_text")));
			
			addtocart.click();
			
			driver.switchTo().defaultContent();
		}
		catch(Exception e)
		{
			driver.switchTo().defaultContent();
			TestBase.test.log(LogStatus.FAIL, "Exception generated in 'SummerDresses.clickAddToCart': " + e.getMessage());
		}
		
	}
	
	public boolean productAddedSuccessfully(WebDriver driver)
	{
		try
		{
			wait = new WebDriverWait(driver, 30);
			
			WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TestBase.prop.getProperty("SummerDress_ProductAddedSuccessfully_text"))));
			
			if(successMessage!=null)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception e)
		{
			TestBase.test.log(LogStatus.FAIL, "Exception generated in 'SummerDresses.productAddedSuccessfully': " + e.getMessage());
			return false;
		} 
		
	}
	
	
	public void clickContinueShopping(WebDriver driver)
	{
		try
		{
			wait = new WebDriverWait(driver, 30);
			
			WebElement contShoppingBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TestBase.prop.getProperty("SummerDress_ContinueShopping_title"))));
				
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", contShoppingBtn);
			
			
		}
		catch(Exception e)
		{
			TestBase.test.log(LogStatus.FAIL, "Exception generated in 'SummerDresses.clickContinueShopping': " + e.getMessage());
		}
	}
	
	
	
	
	
	
	
}
