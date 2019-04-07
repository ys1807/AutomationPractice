package testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TestBase {
	
	public WebDriver driver;
	public ExtentReports report;
	public static ExtentTest test;
	public FileInputStream file;
	public static Properties prop;


	@BeforeSuite
	public void initReport()
	{
	
		report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReport\\ExtentReportResults.html");
		
	}
	
	@BeforeClass
	@Parameters("browser")
	public void initBrowser(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\browsers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	@BeforeTest
	public void initProperties() throws IOException
	{
		file = new FileInputStream(new File (System.getProperty("user.dir") + "\\src\\test\\resources\\PropertiesFiles\\onlineShopping.properties"));
		
		prop = new Properties();
		prop.load(file);
		
	}
	
	
	public static void scrollingToElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	@AfterTest
	public void endProperties() throws IOException
	{
		file.close();
	}
	
	
	@AfterClass
	public void endBrowser()
	{
		driver.quit();
	}
	

	@AfterSuite
	public void endReport()
	{
		report.endTest(test);
		report.flush();
	}
	
}
