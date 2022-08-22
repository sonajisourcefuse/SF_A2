package basetestp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;

public class BaseTest {
	
	
	public String reporturl;
	public WebDriver driver;
	public Properties config;
	public FileInputStream propertiesFile;

	
	public String URL;
	public String ByPassURL;
	
	//
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public ExtentTest test;
	
	
	String report_Dir = "Reports/ExtentReport";
	String automation_Test_Report = report_Dir + "/TestReport.html";
	String email_Content = "target/surefire-reports/EmailableReport.html";
	
	@BeforeTest (alwaysRun = true)
	
	public void iniExtentReport() throws IOException {
		
		
		File file = new File(report_Dir);
		File TestsScreenshots = new File(report_Dir + "/TestsScreenshots");
		if (file.exists()) {
			FileUtils.cleanDirectory(file);
			file.mkdir();
			if (!TestsScreenshots.exists()) {
				TestsScreenshots.mkdir();
			}
		}
		File report = new File(automation_Test_Report);
		System.out.println("Automation report is generated at location: " + file.getAbsolutePath());
		
		
		htmlReporter = new ExtentSparkReporter(report);
		List<ViewName> DEFAULT_ORDER = Arrays.asList(ViewName.DASHBOARD, ViewName.CATEGORY, ViewName.TEST);
		htmlReporter.viewConfigurer().viewOrder().as(DEFAULT_ORDER);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("Host Name", "PWS");
		extent.setSystemInfo("Browser Name", "Chrome");
		extent.setSystemInfo("Environment", "DEV");
		
		
		htmlReporter.config().setDocumentTitle("SF Assignment Test Report");
		htmlReporter.config().setReportName("Automation Test Report :: PWS");
		htmlReporter.config().setTheme(Theme.DARK);
		
		
	}
	
	@AfterTest(alwaysRun = true)
	public void closeSuite() throws Exception {
		
		extent.flush();
		
		
	}
	
	
	
	@AfterMethod
	   public void tearDown(ITestResult result) throws Exception {
			
		    if (result.getStatus() == ITestResult.FAILURE)
		    	
		    {
		    	test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Test case FAILED due to below issues:" ,ExtentColor.RED));
		    	test.fail(result.getThrowable().getMessage());
		    	try 
		    	{
		    		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		    		TakesScreenshot ts = (TakesScreenshot) driver;
		    		File source = ts.getScreenshotAs(OutputType.FILE);
		    		String image_name = result.getName() + "_" + timeStamp + "_fail" + ".png";
		    		
		    		
		    		String filename = "TestsScreenshots/" + image_name;
                    File destinationScreenShot = new File(report_Dir + "/" + filename);
                    FileUtils.copyFile(source, destinationScreenShot);
		    		System.out.println("Screenshot taken");
		    		test.addScreenCaptureFromPath(filename);
		    
		    	}
		    	
		    	catch (Exception e) {
		    		System.out.println("Exception while taking screenshot " +e.getMessage());
		    	}
		    	
		    }
			
			
		}
	
	@BeforeClass (alwaysRun = true)
	public void setUp() throws Exception {
		config = new Properties();
		propertiesFile = new FileInputStream("src/test/resources/Properties/SF.properties");
		config.load(propertiesFile);

		executionBrowser();
		EnvironmentalDetails();
		Loader();

	}
	
	public void Loader() throws IOException {
		
	}

	public void executionBrowser()
	{
		if(config.getProperty("browser").contains("Chrome"));
		{
			ChromeOptions options = new ChromeOptions();
			
			options.addArguments("--headless");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--window-size=1920,1080");
			System.setProperty("webdriver.chrome.driver", "src/test/resources/Executable/chromedriver.exe");
			
			driver = new ChromeDriver(); 
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			
		}
		
		
	}
	
public void EnvironmentalDetails() {
		
		URL = config.getProperty("url");
		ByPassURL = config.getProperty("bypassURL");
		
		
	}



 @AfterClass
   public void tearDown() throws InterruptedException {
	 driver.quit();
	  
	  
	}
	
  
  
  
  public void closeSession() throws InterruptedException{
		
	  driver.quit();
	}
  
  
}
