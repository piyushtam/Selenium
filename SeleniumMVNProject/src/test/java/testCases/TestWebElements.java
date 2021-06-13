package testCases;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestWebElements {
	
	public static String browser = "Chrome";
	public static WebDriver driver;
	
	public static void main(String[] args) {
		
		if (browser.equals("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		else if (browser.equals("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		//WebDriverManager.chromedriver().setup();
		
		//WebDriver driver = new ChromeDriver();
		driver.get("http://gmail.com");
		//System.out.println(driver.getTitle());
		
		String title = driver.getTitle();
		System.out.println(title);
		System.out.println(title.length());
		
		//driver.close();
		//driver.quit();
		
		Options opt = driver.manage();
		Window win=opt.window();
		win.maximize();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.cssSelector("#identifierId")).sendKeys("trainer@way2automation.com");
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/div[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("123456");
		driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/div[2]")).click();
		
		
		
	}

}
