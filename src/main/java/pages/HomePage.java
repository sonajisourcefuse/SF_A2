package pages;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import objects.ObjectRepo;
import utility.EleActions;

public class HomePage extends ObjectRepo {
	
	WebDriver driver;
	EleActions ele_Actions;
	
	By women;
	By dresses;
	By m_SizeCheckbox;
	By summer_Dresses_Submenu;
	By sortBy_Dropdown;
	By continue_Shopping;
	By item_1;
	By item_2;
	By addToCart1;
	By addToCart2;
	By cart;
	By proceedToCheckout;
	By newsletter;
	By summerDressesHeading;
	By addToCartMessage;
	
	
	public HomePage(WebDriver driver) throws IOException {
		super("HomePage.properties");
		
		this.driver=driver;
		
		ele_Actions=new EleActions(driver);
		
		women = By.xpath(config.getProperty("women"));
		dresses = By.xpath(config.getProperty("dresses"));
		m_SizeCheckbox = By.xpath(config.getProperty("m_SizeCheckbox"));
		summer_Dresses_Submenu= By.xpath(config.getProperty("summer_Dresses_Submenu"));
		sortBy_Dropdown= By.xpath(config.getProperty("sortBy_Dropdown"));
		continue_Shopping = By.xpath(config.getProperty("continue_Shopping"));
		item_1= By.xpath(config.getProperty("item_1"));
		item_2 = By.xpath(config.getProperty("item_2"));
		addToCart1 = By.xpath(config.getProperty("addToCart1"));
		addToCart2 = By.xpath(config.getProperty("addToCart2"));
		cart = By.xpath(config.getProperty("cart"));
		proceedToCheckout = By.xpath(config.getProperty("proceedToCheckout"));
		newsletter = By.xpath(config.getProperty("newsletter"));
		summerDressesHeading=By.xpath(config.getProperty("summerDressesHeading"));
		addToCartMessage = By.xpath(config.getProperty("addToCartMessage"));
	}
	
	public void clickOnWomenTab() {
		ele_Actions.waitUntilVisibilityLocated(women);
		ele_Actions.findElement(women);
		ele_Actions.mouseHover();
	}
	
	public void clickOnDresses() {
		ele_Actions.waitUntilVisibilityLocated(dresses);
		ele_Actions.findElement(dresses);
		ele_Actions.Click();
	}
	
	public void selectOnSummerDressesSubmenu() {
		ele_Actions.waitUntilVisibilityLocated(summer_Dresses_Submenu);
		ele_Actions.findElement(summer_Dresses_Submenu);
		ele_Actions.click_JS();
		//li[@class='sfHoverForce sfHover']/ul//a[@title='Summer Dresses']
	}
	public void scrollToSortByDropdown() {

		ele_Actions.waitUntilVisibilityLocated(sortBy_Dropdown);
		ele_Actions.findElement(sortBy_Dropdown);
		ele_Actions.scrollElementIntoView();
		
	}
	
	public String validateAddTocart() {
		ele_Actions.waitUntilVisibilityLocated(addToCartMessage);
		ele_Actions.findElement(addToCartMessage);
		return ele_Actions.getElementText();
		
	}
	
	public void scrollToSummerDressesHeading() {
		
		ele_Actions.waitUntilVisibilityLocated(summerDressesHeading);
		ele_Actions.findElement(summerDressesHeading);
		ele_Actions.scrollElementIntoView();

	}
	
	public void cliclOnMSizeCheckbox() {

		ele_Actions.waitUntilVisibilityLocated(m_SizeCheckbox);
		ele_Actions.findElement(m_SizeCheckbox);
		ele_Actions.Click();
	}
	public void selectLowestFirstFromSortByDropdown() {
		ele_Actions.waitUntilInVisibilityLocated(sortBy_Dropdown);
		//ele_Actions.waitUntilVisibilityLocated(sortBy_Dropdown);
		ele_Actions.findElement(sortBy_Dropdown);
		ele_Actions.Click();
		ele_Actions.selectValueFromDropdown("Price: Lowest first");
	
	}
	public void scrollToItem1() {

		ele_Actions.waitUntilVisibilityLocated(item_1);
		ele_Actions.findElement(item_1);
		ele_Actions.scrollElementIntoView();

	}
	public void selectItem1() {

		ele_Actions.waitUntilVisibilityLocated(item_1);
		ele_Actions.findElement(item_1);
		ele_Actions.mouseHover();
		ele_Actions.waitUntilVisibilityLocated(addToCart1);
		ele_Actions.findElement(addToCart1);
		ele_Actions.Click();
	
	}
	public void scrollToItem2() {

		ele_Actions.waitUntilInVisibilityLocated(item_2);
		ele_Actions.findElement(item_2);
		ele_Actions.scrollElementIntoView();

	}
	public void selectItem2() {
		

		ele_Actions.waitUntilVisibilityLocated(item_2);
		ele_Actions.findElement(item_2);
		ele_Actions.mouseHover();
		ele_Actions.findElement(addToCart2);
		ele_Actions.click_JS();	
	}
	
	public void cliclOnContinueShopping() {

		ele_Actions.waitUntilVisibilityLocated(continue_Shopping);
		ele_Actions.findElement(continue_Shopping);
		ele_Actions.Click();
	}//
	
	
	
public void scrollToCart() {
		
		ele_Actions.waitUntilVisibilityLocated(cart);
		ele_Actions.findElement(cart);
		ele_Actions.scrollElementIntoView();

	}
	public void clickOnCart() {
		ele_Actions.waitUntilVisibilityLocated(cart);
		ele_Actions.findElement(cart);
		ele_Actions.Click();
	}
	
	public void clickOnProceedToCheckout() {
		ele_Actions.waitUntilVisibilityLocated(proceedToCheckout);
		ele_Actions.findElement(proceedToCheckout);
		ele_Actions.Click();
	}
	

}
