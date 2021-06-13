package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestProperties {
	
	public static WebDriver driver;
	public static Properties OR = new Properties(); //for loading OR properties
	public static Properties config = new Properties(); //for loading config properties
	public static Logger log = Logger.getLogger(TestProperties.class.getSimpleName());
	
	public static void quit()
	{
		driver.quit();
		log.info("Test execution completed!!");
	}
	
	public static void click(String locator)
	{
		if (locator.endsWith("_XPATH")) {
		driver.findElement(By.xpath(OR.getProperty(locator))).click();
		}else if (locator.endsWith("_ID")) {
		driver.findElement(By.id(OR.getProperty(locator))).click();
		}else if (locator.endsWith("_CSS")) {
		driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
		}
		log.info("Clicking on an element: "+locator);
	}
	
	public static void type(String locator, String value)
	{
		if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
			}else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).sendKeys(value);
			}else if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
			}
		log.info("Typing of an element: "+locator+" entered type value as: "+value);
	}

	public static void main(String[] args) throws IOException {
		
		PropertyConfigurator.configure(".\\src\\test\\resources\\properties\\log4j.properties");
		
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\properties\\OR.properties");
		OR.load(fis);
		log.info("OR properties loaded!!");
		
		
		fis = new FileInputStream(".\\src\\test\\resources\\properties\\Config.properties");
	    config.load(fis);
	    log.info("Config properties loaded!!");
	    
	    System.out.println(OR.getProperty("email_XPATH"));
	    System.out.println(config.getProperty("testsiteurl"));
	    
	    if (config.getProperty("browser").equals("chrome"))
	    {
	    	WebDriverManager.chromedriver().setup();
	    	driver = new ChromeDriver();
	    	log.info("Chrome browser launched!!");
	    }
	    
	    else if (config.getProperty("browser").equals("edge"))
	    {
	    	WebDriverManager.edgedriver().setup();
	    	driver = new EdgeDriver();
	    	log.info("Edge browser launched!!");
	    }
	    
	    driver.get(config.getProperty("testsiteurl"));
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
	    
	    //driver.findElement(By.xpath(OR.getProperty("email_XPATH"))).sendKeys("pyush1811@gmail.com");
	    //driver.findElement(By.id(OR.getProperty("password_ID"))).sendKeys("123456");
	    
	    //By providing key driven approach or typing the same code again and again we can create a method of click and type.
	    
	    type("email_XPATH","pyush1811@gmail.com");
	    type("password_ID","123456");
	    click("loginbtn_CSS");
	    quit();
	    

	}

}
