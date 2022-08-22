package testcases;


import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import basetestp.BaseTest;
import pages.HomePage;



public class HomePageTest extends BaseTest {
	
	HomePage hp;
	public Logger log;

//
	public void Loader() throws IOException {

		log = LogManager.getLogger(HomePageTest.class.getName());
		hp= new HomePage(driver);

	}	
	@Test
	public void homepageTest() throws InterruptedException, IOException {
		test = extent.createTest("Home Page Test Started");
		String addtocartmessage="Product successfully added to your shopping cart";
		driver.get(URL);

		hp.clickOnWomenTab();
		Thread.sleep(2000);
		hp.selectOnSummerDressesSubmenu();
		hp.cliclOnMSizeCheckbox();
		hp.scrollToSummerDressesHeading();
		hp.selectLowestFirstFromSortByDropdown();
		hp.selectItem1();
		Thread.sleep(2000);
	    Assert.assertEquals(hp.validateAddTocart(),addtocartmessage, "Product successfully added to your shopping cart");
	    Reporter.log("Product 1 successfully added to your shopping car",true);
		hp.cliclOnContinueShopping();
		hp.selectItem2();
		Thread.sleep(2000);
	    Assert.assertEquals(hp.validateAddTocart(),addtocartmessage, "Product successfully added to your shopping cart");
	    Reporter.log("Product 2 successfully added to your shopping car",true);
		hp.cliclOnContinueShopping();
		hp.scrollToCart();
		hp.clickOnCart();
		Thread.sleep(3000);
		hp.clickOnProceedToCheckout();
		Thread.sleep(3000);


	}

}



