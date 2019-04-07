package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.Address;
import pages.HomePage;
import pages.Login;
import pages.Order;
import pages.Payment;
import pages.Shipping;
import pages.SummerDresses;

public class BuyOnline extends TestBase{

	WebDriverWait wait;
	
	@Test
	public void buySummerDress() throws InterruptedException
	{
		HomePage homepage = new HomePage();
		
		test = report.startTest("onlineShopping: Buying the product >> Summer Dress");
		
		driver.get(prop.getProperty("homePageURL"));
		
		wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(prop.getProperty("SignIn_class"))));
		
		String homePageTitle = driver.getTitle();
		
		if(homePageTitle.equals("My Store"))
		{
			Assert.assertEquals(homePageTitle, "My Store");
			test.log(LogStatus.PASS, "Navigated to the specified page with title: " + homePageTitle);
		}
		else
		{
			test.log(LogStatus.FAIL, "Navigated to the specified page with title: " + homePageTitle);
		}
		
		homepage.hoverOverTopMenu(driver, "Women");
		homepage.womenSubMenuClick(driver, "Summer Dresses");
		
		
		String summerDressPageTitle = driver.getTitle();
		
		if(summerDressPageTitle.equals("Summer Dresses - My Store"))
		{
			Assert.assertEquals(summerDressPageTitle, "Summer Dresses - My Store");
			test.log(LogStatus.PASS, "Navigated to the specified page with title: " + summerDressPageTitle);
			
		}
		else
		{
			test.log(LogStatus.FAIL, "Navigated to the specified page with title: " + summerDressPageTitle);
		}
		
			
		// Summer Dresses page
		
		String productToBuy = "Printed Chiffon Dress";
		
		SummerDresses summerdresses = new SummerDresses();
		
		summerdresses.hoverOverProduct(driver, productToBuy);
		summerdresses.clickQuickView(driver, productToBuy);
		
		boolean productPageWindow = summerdresses.visibilitySizeDropdown(driver);
		
		if(productPageWindow==true)
		{
			Assert.assertEquals(productPageWindow, true);
			test.log(LogStatus.PASS, productToBuy + " window opened");
		}
		else
		{
			Assert.fail(productToBuy + " window not opened");
			test.log(LogStatus.FAIL, productToBuy + " window not opened");
		}
		
		String selectSize = "M";
		
		summerdresses.selectProductSize(driver, selectSize);
		test.log(LogStatus.PASS, "Selected the desired size '" + selectSize + "' of the product");
		
		String price_product = summerdresses.getProductPrice(driver);	// Fetching price to compare on Payment page
		String quantity_product = summerdresses.getProductQuantity(driver);		// Fetching quantity to compare on Payment page
		
		summerdresses.clickAddToCart(driver);	// Step 4 [Add to cart]
		
		boolean productAddedToCartMessage = summerdresses.productAddedSuccessfully(driver);
		
		if(productAddedToCartMessage==true)
		{
			Assert.assertEquals(productAddedToCartMessage, true);
			test.log(LogStatus.PASS, productToBuy + " added to cart successfully");	
		}
		else
		{
			test.log(LogStatus.FAIL, productToBuy + " not added to cart successfully");
		}
			
		summerdresses.clickContinueShopping(driver);	// Step 5 [Click on 'Continue shopping']
		
		homepage.hoverOverCart(driver);		// Step 6 [Go to 'Cart']
		homepage.clickCheckout(driver); 	// Step 6 [Click 'Check out']
		
		String checkOutPageTitle = driver.getTitle();
		
		if(checkOutPageTitle.equals("Order - My Store"))
		{
			Assert.assertEquals(checkOutPageTitle, "Order - My Store");
			test.log(LogStatus.PASS, "Checkout button clicked and landed on page with title: " + checkOutPageTitle);
		}
		else
		{
			test.log(LogStatus.FAIL, "Checkout button not clicked and thus not landed on page with title: " + checkOutPageTitle);
			Assert.fail("Check out button not clicked and thus not landed on page with title: " + checkOutPageTitle);
		}
		
		
		Order order = new Order();
		
		order.clickProceedToCheckout(driver); 	// Step 7 [Click 'Proceed to checkout']
		
		Login login = new Login();
		
		login.create_email(driver, prop.getProperty("Email_ID"));	// Step 8 [Enter an email ]
		login.clickCreateAnAccount(driver); 	// Step 8 [Click on 'Create an Account']
		
		login.enterFirstName(driver, prop.getProperty("FirstName"));
		login.enterLastName(driver, prop.getProperty("LastName"));
		login.enterPassword(driver, prop.getProperty("Password"));
		login.enterAddressAddress(driver, prop.getProperty("Address"));	// Step 9 [Fill in mandatory fields]
		login.enterAddressCity(driver, prop.getProperty("City"));
		login.selectAddressState(driver, prop.getProperty("State"));
		login.enterAddressPostalCode(driver, prop.getProperty("PostalCode"));
		login.selectAddressCountry(driver, prop.getProperty("Country"));
		login.enterMobileNumber(driver, prop.getProperty("Mobile"));
		login.enterAddressAlias(driver, prop.getProperty("AddressAlias"));

		String add_Firstname = login.getAddressFirstname(driver);
		String add_Lastname = login.getAddressLastname(driver);
		
		if(add_Firstname.equals(prop.getProperty("FirstName")))
		{
			test.log(LogStatus.PASS, "Pre-filled Firstname in 'Address' section: " + add_Firstname);
			Assert.assertEquals(add_Firstname, prop.getProperty("FirstName"));	// Pre-filled Firstname in 'Address' section
		}
		else
		{
			test.log(LogStatus.PASS, "Pre-filled Firstname in 'Address' section not match: " + add_Firstname);
			Assert.fail("Pre-filled Firstname in 'Address' section not match: " + add_Firstname);	// Pre-filled Firstname in 'Address' section
		}
				
		
		if(add_Lastname.equals(prop.getProperty("LastName")))
		{
			test.log(LogStatus.PASS, "Pre-filled Lastname in 'Address' section: " + add_Lastname);
			Assert.assertEquals(add_Lastname, prop.getProperty("LastName"));	// Pre-filled Lastname in 'Address' section
		}
		else
		{
			test.log(LogStatus.PASS, "Pre-filled Lastname in 'Address' section not match: " + add_Lastname);
			Assert.fail("Pre-filled Lastname in 'Address' section not match: " + add_Lastname);		// Pre-filled Lastname in 'Address' section
		}

		login.clickRegister(driver);	// Step 9 [ Click 'Register']
		
		Address address = new Address();
		
		address.click_Address_ProceedToCheckout(driver);  	// Step 10 [Click 'Proceed to checkout' on Address tab]
		
		Shipping shipping = new Shipping();
		
		String text_TermsOfService = shipping.getTermsOfService(driver);
		
		if(text_TermsOfService.equals("Terms of service"))
		{
			test.log(LogStatus.PASS, "Redirected from Address page to Shipping page having section: " + text_TermsOfService);
			Assert.assertEquals(text_TermsOfService, "Terms of service");	
		}
		else
		{
			test.log(LogStatus.FAIL, "Did not redirected from Address page to Shipping page having section: " + text_TermsOfService);
			Assert.fail("Did not redirected from Address page to Shipping page having section: " + text_TermsOfService);
		}
		
		shipping.click_Shipping_TermsOfServiceCheckbox(driver);		// Step 11 [Agree to 'Terms of service' on Shipping tab]
		shipping.click_Shipping_ProceedToCheckout(driver);		// Step 11 [Click 'Proceed to checkout' on Shipping tab]
		
		
		Payment payment = new Payment();
		
		// Step 12 [Confirm the correct order on 'Payment' tab ]
		
		String expectedProductName = payment.getProductName(driver);
		
		if(expectedProductName.equals(productToBuy))
		{
			test.log(LogStatus.PASS, "Product ordered was '" + productToBuy +"' and name of product on Payment page is: " + expectedProductName);
			Assert.assertEquals(productToBuy, expectedProductName);
		}
		else
		{
			test.log(LogStatus.FAIL, "Product ordered was '" + productToBuy +"' and name of product on Payment page is: " + expectedProductName);
			Assert.assertEquals(productToBuy, expectedProductName);
		}
		
		String actualProductSize = "Size : " + selectSize;
		String expectedProductSize = payment.getProductSize(driver);
		
		if(expectedProductSize.equals(actualProductSize))
		{
			test.log(LogStatus.PASS, "Product size ordered was '" + actualProductSize +"' and product size on Payment page is: " + expectedProductSize);
			Assert.assertEquals(actualProductSize, expectedProductSize);
		}
		else
		{
			test.log(LogStatus.FAIL, "Product size ordered was '" + actualProductSize +"' and product size on Payment page is: " + expectedProductSize);
			Assert.assertEquals(actualProductSize, expectedProductSize);
		}
		
		
		String expectedProductPrice = payment.getProductPrice(driver);
		
		if(expectedProductPrice.equals(price_product))
		{
			test.log(LogStatus.PASS, "Product ordered price was '" + price_product +"' and price of product on Payment page is: " + expectedProductPrice);
			Assert.assertEquals(price_product, expectedProductPrice);
		}
		else
		{
			test.log(LogStatus.FAIL, "Product ordered price was '" + price_product +"' and price of product on Payment page is: " + expectedProductPrice);
			Assert.assertEquals(price_product, expectedProductPrice);
		}
		
		
		String expectedProductQuantity = payment.getProductQuantity(driver);
		
		if(expectedProductQuantity.equals(quantity_product))
		{
			test.log(LogStatus.PASS, "Product quantity ordered was '" + quantity_product +"' and quantity of product on Payment page is: " + expectedProductQuantity);
			Assert.assertEquals(quantity_product, expectedProductQuantity);
		}
		else
		{
			test.log(LogStatus.PASS, "Product quantity ordered was '" + quantity_product +"' and quantity of product on Payment page is: " + expectedProductQuantity);
			Assert.assertEquals(quantity_product, expectedProductQuantity);
		}

	} // end of Test Case
	
		
}
