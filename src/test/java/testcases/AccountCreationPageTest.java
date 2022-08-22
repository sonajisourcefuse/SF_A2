package testcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import basetestp.BaseTest;
import pages.AccountCreationPage;

public class AccountCreationPageTest extends BaseTest {

	AccountCreationPage acp;
	public Logger log;


	public void Loader() throws IOException {

		log = LogManager.getLogger(AccountCreationPageTest.class.getName());
		acp = new AccountCreationPage(driver);

	}	//

	@Test
	public void accountCreationPageTest() throws InterruptedException, IOException {
		test = extent.createTest("Account Creation Page Test Started");
		driver.get(URL);
		acp.clickOnSignBtn();
		acp.enterEmailAddress();
		acp.selectGenderMr();
		acp.enterCustomerFirstName();
		acp.enterCustomerLastName();
		acp.scrollToPassword();
		acp.selectDateOfBirth();
		acp.enterFirstName();
		acp.enterLastName();
		acp.enterCompanyName();
		acp.enterAddress();
		acp.enterCity();
		acp.selectState();
		acp.scrollToStateDropdown();
		acp.enterPostalCode();
		acp.enterMobileNumber();
		acp.enterAliasAddress();
		acp.clickonRegisterBtn();
		
		

	}

}
