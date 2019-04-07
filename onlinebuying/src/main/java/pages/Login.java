package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import testCases.TestBase;

public class Login {
	
	public WebDriverWait wait;
	
	public void create_email(WebDriver driver, String emailID)
	{
		try
		{
			wait = new WebDriverWait(driver, 30);
			
			WebElement emaildIDTextbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(TestBase.prop.getProperty("Login_Create_Email_id"))));
			
			emaildIDTextbox.sendKeys(emailID);
			
		}
		catch(Exception e)
		{
			TestBase.test.log(LogStatus.FAIL, "Exception generated in 'Login.create_email': " + e.getMessage());
			Assert.fail("Exception generated in 'Login.create_email': " + e.getMessage());
		}
				
	}
	
	
	public void clickCreateAnAccount(WebDriver driver)
	{
		try
		{
			
			wait = new WebDriverWait(driver, 30);
			
			WebElement createAccountBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(TestBase.prop.getProperty("Login_CreateAccount_id"))));
			
			createAccountBtn.click();
			
		}
		catch(Exception e)
		{
			TestBase.test.log(LogStatus.FAIL, "Exception generated in 'Login.clickCreateAnAccount': " + e.getMessage());
			Assert.fail("Exception generated in 'Login.clickCreateAnAccount': " + e.getMessage());
		}
	}
	
	
	public void enterFirstName(WebDriver driver, String firstName)
	{
		try
		{
			wait = new WebDriverWait(driver, 30);
			
			WebElement firstNameTextbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(TestBase.prop.getProperty("Login_FirstName_id"))));
			
			firstNameTextbox.sendKeys(firstName);
			
		}
		catch(Exception e)
		{
			TestBase.test.log(LogStatus.FAIL, "Exception generated in 'Login.enterFirstName': " + e.getMessage());
			Assert.fail("Exception generated in 'Login.enterFirstName': " + e.getMessage());
			
		}
		
	}
	
	
	public void enterLastName(WebDriver driver, String lastName)
	{
		try
		{
			wait = new WebDriverWait(driver, 30);
			
			WebElement lastNameTextbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(TestBase.prop.getProperty("Login_LastName_id"))));
			
			lastNameTextbox.sendKeys(lastName);
			
		}
		catch(Exception e)
		{
			TestBase.test.log(LogStatus.FAIL, "Exception generated in 'Login.enterLastName': " + e.getMessage());
			Assert.fail("Exception generated in 'Login.enterLastName': " + e.getMessage());
			
		}
	}
		
		
	public void enterPassword(WebDriver driver, String password)
	{
		try
		{
			wait = new WebDriverWait(driver, 30);
			
			WebElement passwordTextbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(TestBase.prop.getProperty("Login_Password_id"))));
			
			passwordTextbox.sendKeys(password);
			
		}
		catch(Exception e)
		{
			TestBase.test.log(LogStatus.FAIL, "Exception generated in 'Login.enterPassword': " + e.getMessage());
			Assert.fail("Exception generated in 'Login.enterPassword': " + e.getMessage());
			
		}
			
	}
	
	
	
	public void enterAddressAddress(WebDriver driver, String address)
	{
		try
		{
			wait = new WebDriverWait(driver, 30);
			
			WebElement addressTextbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(TestBase.prop.getProperty("Login_Address_Address_id"))));
			
			addressTextbox.sendKeys(address);
			
		}
		catch(Exception e)
		{
			TestBase.test.log(LogStatus.FAIL, "Exception generated in 'Login.enterAddressAddress': " + e.getMessage());
			Assert.fail("Exception generated in 'Login.enterAddressAddress': " + e.getMessage());
			
		}
			
	}
	
	
	public void enterAddressCity(WebDriver driver, String city)
	{
		try
		{
			wait = new WebDriverWait(driver, 30);
			
			WebElement cityTextbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(TestBase.prop.getProperty("Login_Address_City_id"))));
			
			cityTextbox.sendKeys(city);
			
		}
		catch(Exception e)
		{
			TestBase.test.log(LogStatus.FAIL, "Exception generated in 'Login.enterAddressCity': " + e.getMessage());
			Assert.fail("Exception generated in 'Login.enterAddressCity': " + e.getMessage());
			
		}
			
	}
	
	
	public void selectAddressState(WebDriver driver, String state)
	{
		try
		{
			Select selectState = new Select(driver.findElement(By.id(TestBase.prop.getProperty("Login_Address_State_id"))));
			selectState.selectByVisibleText(state);
			
		}
		catch(Exception e)
		{
			TestBase.test.log(LogStatus.FAIL, "Exception generated in 'Login.selectAddressState': " + e.getMessage());
			Assert.fail("Exception generated in 'Login.selectAddressState': " + e.getMessage());
			
		}
			
	}
	
	public void enterAddressPostalCode(WebDriver driver, String postalcode)
	{
		try
		{
			wait = new WebDriverWait(driver, 30);
			
			WebElement postalCodeTextbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(TestBase.prop.getProperty("Login_Address_PostalCode_id"))));
			
			postalCodeTextbox.sendKeys(postalcode);
			
		}
		catch(Exception e)
		{
			TestBase.test.log(LogStatus.FAIL, "Exception generated in 'Login.enterAddressPostalCode': " + e.getMessage());
			Assert.fail("Exception generated in 'Login.enterAddressPostalCode': " + e.getMessage());
			
		}
			
	}
	
	
	public void selectAddressCountry(WebDriver driver, String country)
	{
		try
		{
			Select selectCountry = new Select(driver.findElement(By.id(TestBase.prop.getProperty("Login_Address_Country_id"))));
			selectCountry.selectByVisibleText(country);
			
		}
		catch(Exception e)
		{
			TestBase.test.log(LogStatus.FAIL, "Exception generated in 'Login.selectAddressCountry': " + e.getMessage());
			Assert.fail("Exception generated in 'Login.selectAddressCountry': " + e.getMessage());
			
		}
			
	}
	
	
	public void enterMobileNumber(WebDriver driver, String mobileNumber)
	{
		try
		{
			wait = new WebDriverWait(driver, 30);
			
			WebElement mobileTextbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(TestBase.prop.getProperty("Login_Address_Mobile_id"))));
			
			mobileTextbox.sendKeys(mobileNumber);
			
		}
		catch(Exception e)
		{
			TestBase.test.log(LogStatus.FAIL, "Exception generated in 'Login.enterMobileNumber': " + e.getMessage());
			Assert.fail("Exception generated in 'Login.enterMobileNumber': " + e.getMessage());
			
		}
			
	}
	
	
	public void enterAddressAlias(WebDriver driver, String alias)
	{
		try
		{
			wait = new WebDriverWait(driver, 30);
			
			WebElement aliasTextbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(TestBase.prop.getProperty("Login_Address_AddressAlias_id"))));
			
			aliasTextbox.clear();
			aliasTextbox.sendKeys(alias);
			
		}
		catch(Exception e)
		{
			TestBase.test.log(LogStatus.FAIL, "Exception generated in 'Login.enterAddressAlias': " + e.getMessage());
			Assert.fail("Exception generated in 'Login.enterAddressAlias': " + e.getMessage());
			
		}
			
	}
	
	
	public void clickRegister(WebDriver driver)
	{
		try
		{
			
			wait = new WebDriverWait(driver, 30);
			
			WebElement registerBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(TestBase.prop.getProperty("Login_Register_id"))));
			
			registerBtn.click();
			
		}
		catch(Exception e)
		{
			TestBase.test.log(LogStatus.FAIL, "Exception generated in 'Login.clickRegister': " + e.getMessage());
			Assert.fail("Exception generated in 'Login.clickRegister': " + e.getMessage());
		}
	}
	
	
	public String getAddressFirstname(WebDriver driver)
	{
		try
		{
			wait = new WebDriverWait(driver, 30);
			
			WebElement addressFirstnameTextbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(TestBase.prop.getProperty("Login_Address_Firstname_id"))));
			
			return (addressFirstnameTextbox.getAttribute("value"));
			
		}
		catch(Exception e)
		{
			TestBase.test.log(LogStatus.FAIL, "Exception generated in 'Login.getAddressFirstname': " + e.getMessage());
			return null;
			
		}
			
	}
	
	
	public String getAddressLastname(WebDriver driver)
	{
		try
		{
			wait = new WebDriverWait(driver, 30);
			
			WebElement addressLastnameTextbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(TestBase.prop.getProperty("Login_Address_Lastname_id"))));
						
			return (addressLastnameTextbox.getAttribute("value"));
			
		}
		catch(Exception e)
		{
			TestBase.test.log(LogStatus.FAIL, "Exception generated in 'Login.getAddressLastname': " + e.getMessage());
			return null;
			
		}
			
	}
	
	
	
	
	

} // end of class
