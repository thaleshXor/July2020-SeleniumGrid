package package1;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitFormClass {

	static
	{
		System.out.println("Starting .............");
	}

	static WebDriver driver=null;
	
	private static String firstName="subham";
	private static String lastName="sharma";
	private static String sex="Male";
	private static String experience="4";
	static DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
	static Date date=new Date();
	private static String todaysDate=dateFormat.format(date);
	private static String profession="Automation Tester";
	private static String automationTool1="QTP";
	private static String automationTool2="Selenium Webdriver";
	private static String continent="Europe";
	private static String seleniumCommand="Browser Commands";
	private static String filePath="C:\\thalesh\\Automation\\Selenium\\Demo\\Capture.JPG";

	
	private static String xpath_firstName="//input[@name='firstname']";
	private static String xpath_lastName="//input[@name='lastname']";
	private static String xpath_Sex="//input[@value='" + sex + "']";
	private static String xpath_Exp="//input[@value='" + experience + "']";
	private static String xpath_Date="//input[@id='datepicker']";
	private static String xpath_AutomationTool1="//input[@value='" + automationTool1 + "']";
	private static String xpath_AutomationTool2="//input[@value='" + automationTool2 + "']";
	private static String xpath_Profession="//input[@value='" + profession + "']";
	private static String xpath_Continent="//select[@name='continents']";
	private static String xpath_SeleniumCommand="//select[@name='selenium_commands']";
	private static String xpath_UploadImage="//input[@name='photo']";
	private static String xpath_Submit="//button[@name='submit']";
	
	//String osName=System.getProperty("osName");
	String browser=System.getProperty("browser");
	//String browser="chrome";
	
	//	String url="http://localhost:4444/wd/hub";
	//String url="http://10.52.122.67:4444/wd/hub";
	String url="http://localhost:4444/wd/hub";



@BeforeMethod
void setUp() throws MalformedURLException {
		System.out.println("inside BeforeMethod");
		DesiredCapabilities dc=new DesiredCapabilities();
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.out.println("About to generate chrome options");
			dc.setBrowserName("chrome");
			ChromeOptions options=new ChromeOptions();
			/*
			options.addArguments("-headless");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");

			 */

			System.out.println("About to merge desired capabilities");
			options.merge(dc);
			System.out.println("About to define cdriver");
			driver=new RemoteWebDriver(new URL(url), options);
			System.out.println("Before method is over");
			
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			dc.setBrowserName("firefox");
			System.out.println("About to generate firefox options");
			FirefoxOptions options = new FirefoxOptions();
			
			System.out.println("going to run on headless firefox");
			options.addArguments("-headless");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
			
			options.merge(dc);
			driver=new RemoteWebDriver(new URL(url), options);
		}
	
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
				
    }	

@AfterMethod
void tearDown() {
		

		driver.quit();
		
}

		
@Test
void fillForm1() {

	
		System.out.println("---------------------------Website navigated-----------------------");
		driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
		
		System.out.println("-------------------------WebElement interactions--------------------------");
		
		driver.findElement(By.xpath(xpath_firstName)).sendKeys(firstName);
		driver.findElement(By.xpath(xpath_lastName)).sendKeys(lastName);
		driver.findElement(By.xpath(xpath_Sex)).click();
		driver.findElement(By.xpath(xpath_Exp)).click();
		driver.findElement(By.xpath(xpath_Date)).sendKeys(todaysDate);
		driver.findElement(By.xpath(xpath_AutomationTool1)).click();
		driver.findElement(By.xpath(xpath_AutomationTool2)).click();
		driver.findElement(By.xpath(xpath_Profession)).click();
		Select select=new Select(driver.findElement(By.xpath(xpath_Continent)));
		select.selectByVisibleText(continent);
		select=new Select(driver.findElement(By.xpath(xpath_SeleniumCommand)));
		select.selectByVisibleText(seleniumCommand);
		//driver.findElement(By.xpath(xpath_UploadImage)).sendKeys(filePath);
		driver.findElement(By.xpath(xpath_Submit)).click();
		
		System.out.println("-------------Test1 Ends-------------------------");
}	


@Test
void fillForm2() {
	
	
		//---------------------------Website navigated-----------------------
		driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
		
		//----------------------------------WebElement interactions--------------------------------
		
		driver.findElement(By.xpath(xpath_firstName)).sendKeys(firstName);
		driver.findElement(By.xpath(xpath_lastName)).sendKeys(lastName);
		driver.findElement(By.xpath(xpath_Sex)).click();
		driver.findElement(By.xpath(xpath_Exp)).click();
		driver.findElement(By.xpath(xpath_Date)).sendKeys(todaysDate);
		driver.findElement(By.xpath(xpath_AutomationTool1)).click();
		driver.findElement(By.xpath(xpath_AutomationTool2)).click();
		driver.findElement(By.xpath(xpath_Profession)).click();
		Select select=new Select(driver.findElement(By.xpath(xpath_Continent)));
		select.selectByVisibleText(continent);
		select=new Select(driver.findElement(By.xpath(xpath_SeleniumCommand)));
		select.selectByVisibleText(seleniumCommand);
		//driver.findElement(By.xpath(xpath_UploadImage)).sendKeys(filePath);
		driver.findElement(By.xpath(xpath_Submit)).click();
		
		System.out.println("-------------Test2 Ends-------------------------");
	}	

}
