package pages;

import static org.testng.Assert.expectThrows;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import objects.ObjectRepo;
import utility.EleActions;



public class AccountCreationPage extends ObjectRepo {
	
	WebDriver driver;
	EleActions ele_Actions;

	By signIn;
	By enter_Email_Address;
	By create_An_Account;
	By gender;
	By cFirstname;
	By cLastname;
	By password;
	By date_Dropdown;
	By month_Dropdown;
	By years_Dropdown;
	By firstname;
	By lastname;
	By compony_Name;
	By address;
	By city;
	By state_Dropdown;
	By postalcode;
	By country_Dropdown;
	By mobile_Number;
	By alias_Address;
	By register_Btn;
	public AccountCreationPage(WebDriver driver) throws IOException {
		super("AccountCreationPage.properties");
		// TODO Auto-generated constructor stub
		this.driver=driver;
		ele_Actions=new EleActions(driver);
		
		signIn = By.xpath(config.getProperty("signIn"));
		enter_Email_Address = By.xpath(config.getProperty("enter_Email_Address"));
		create_An_Account = By.xpath(config.getProperty("create_An_Account"));
		gender = By.xpath(config.getProperty("gender"));
		cFirstname = By.xpath(config.getProperty("cFirstname"));
		cLastname = By.xpath(config.getProperty("cLastname"));
		password = By.xpath(config.getProperty("password"));
		date_Dropdown = By.xpath(config.getProperty("date_Dropdown"));
		month_Dropdown = By.xpath(config.getProperty("month_Dropdown"));
		years_Dropdown =By.xpath(config.getProperty("years_Dropdown"));
		firstname= By.xpath(config.getProperty("firstname"));
		lastname = By.xpath(config.getProperty("lastname"));
		compony_Name= By.xpath(config.getProperty("compony_Name"));
		address =By.xpath(config.getProperty("address"));
		city = By.xpath(config.getProperty("city"));
		state_Dropdown= By.xpath(config.getProperty("state_Dropdown"));
		postalcode = By.xpath(config.getProperty("postalcode"));
		country_Dropdown = By.xpath(config.getProperty("country_Dropdown"));
		mobile_Number= By.xpath(config.getProperty("mobile_Number"));
		alias_Address= By.xpath(config.getProperty("alias_Address"));
		register_Btn=By.xpath(config.getProperty("register_Btn"));
	}
	public void clickOnSignBtn() {
		ele_Actions.findElement(signIn);
		ele_Actions.Click();
	}

	public void enterEmailAddress() {
		ele_Actions.waitUntilVisibilityLocated(enter_Email_Address);
		ele_Actions.findElement(enter_Email_Address);
		ele_Actions.SendKeys("kakdesonaji77@gmail.com");
		ele_Actions.findElement(create_An_Account);
		ele_Actions.Click();
	}
	
	public void selectGenderMr() {
		ele_Actions.waitUntilVisibilityLocated(gender);
		ele_Actions.findElement(gender);
		ele_Actions.Click();
	}
	
	public void enterCustomerFirstName() {
		ele_Actions.waitUntilVisibilityLocated(cFirstname);
		ele_Actions.findElement(cFirstname);
		ele_Actions.SendKeys("Sonaji");
	}
	
	public void enterCustomerLastName() {
		ele_Actions.waitUntilVisibilityLocated(cLastname);
		ele_Actions.findElement(cLastname);
		ele_Actions.SendKeys("kakde");
	}
	
	public void enterPassword() {
		ele_Actions.waitUntilVisibilityLocated(password);
		ele_Actions.findElement(password);
		ele_Actions.SendKeys("123456789");
	}
	
	public void selectDateOfBirth() {
		ele_Actions.findElement(date_Dropdown);
		ele_Actions.selectValueFromDropdown("9");
		ele_Actions.findElement(month_Dropdown);
		ele_Actions.selectValueFromDropdown("August");
		ele_Actions.findElement(years_Dropdown);
		ele_Actions.selectValueFromDropdown("1997");
		
	}
	
	public void enterFirstName() {
		ele_Actions.waitUntilVisibilityLocated(firstname);
		ele_Actions.findElement(firstname);
		ele_Actions.SendKeys("sonaji");
	}
	
	public void enterLastName() {
		ele_Actions.waitUntilVisibilityLocated(lastname);
		ele_Actions.findElement(lastname);
		ele_Actions.SendKeys("kakde");
	}
	
	public void enterCompanyName() {
		ele_Actions.waitUntilVisibilityLocated(compony_Name);
		ele_Actions.findElement(compony_Name);
		ele_Actions.SendKeys("SourceFuse");
	}//
	
	public void enterAddress() {
		ele_Actions.waitUntilVisibilityLocated(address);
		ele_Actions.findElement(address);
		ele_Actions.SendKeys("Karve Nagar Pune");
	}
	
	public void enterCity() {
		ele_Actions.waitUntilVisibilityLocated(city);
		ele_Actions.findElement(city);
		ele_Actions.SendKeys("Chicago");
	}
	
	public void selectState() {
		ele_Actions.waitUntilVisibilityLocated(state_Dropdown);
		ele_Actions.findElement(state_Dropdown);
		ele_Actions.selectValueFromDropdown("Alaska");
		
		
	}
	
	public void scrollToPassword() {

		ele_Actions.waitUntilVisibilityLocated(password);
		ele_Actions.findElement(password);
		ele_Actions.scrollElementIntoView();
		
	}
	public void scrollToStateDropdown() {

		ele_Actions.waitUntilVisibilityLocated(state_Dropdown);
		ele_Actions.findElement(state_Dropdown);
		ele_Actions.scrollElementIntoView();
		
	}
	public void enterMobileNumber() {
		ele_Actions.waitUntilVisibilityLocated(mobile_Number);
		ele_Actions.findElement(mobile_Number);
		ele_Actions.SendKeys("9834173275");
	}
	
	public void enterPostalCode() {
		ele_Actions.waitUntilVisibilityLocated(postalcode);
		ele_Actions.findElement(postalcode);
		ele_Actions.SendKeys("411052");
	}
	
	public void enterAliasAddress() {
		ele_Actions.waitUntilVisibilityLocated(alias_Address);
		ele_Actions.findElement(alias_Address);
		ele_Actions.SendKeys("pune");
	}
	
	public void clickonRegisterBtn() {
		ele_Actions.waitUntilVisibilityLocated(register_Btn);
		ele_Actions.findElement(register_Btn);
		ele_Actions.Click();
	}

}
