package utility;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EleActions {
	WebDriver driver;
	JavascriptExecutor executor;
	WebDriverWait wait;
	WebElement element;	
	
	@SuppressWarnings("deprecation")
	public EleActions(WebDriver driver) {

		this.driver = driver;
		wait = new WebDriverWait(driver,20);
		
	}
	
	public WebElement findElement(By by) {
		
		element = driver.findElement(by);
		return element;
		
	}
	
	
	public void waitUntilVisibilityLocated(By by) {
		wait.until(ExpectedConditions.elementToBeClickable(wait.until(ExpectedConditions.visibilityOfElementLocated(by))));
	}
	
	
	
	
	public void waitUntilInVisibilityLocated(By by) {
		//driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}
	
	
	
	
	
	
	
	
	public void SendKeys(String text) {
		element.sendKeys(text);
		
	}
	
	
	public void Click() {
		element.click();
		
	}
	
	public void click_JS() {
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	
	
	
	public void selectValueFromDropdown(String dropdown_Value) {
		
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(dropdown_Value);
	}
	 
	
	
	public void mouseHover() {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		
	}
	
	public String getAttributeValue() {
		
		return element.getAttribute("value");
	}

	public String getElementText() {
		
		return element.getText();
		
	}//
	
	public void acceptWindowAlert() throws IOException {
		
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
	
	
	public void switchToDefault() throws IOException {
		driver.switchTo().defaultContent();
	}
	
	
	
	public void scrollElementIntoView() {
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	
	
	

	public void SendKeys(Keys arrowDown) {
		element.sendKeys(arrowDown);
	}


}
