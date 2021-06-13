package testCases;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNaukricom {
	
	public static WebDriver driver;


	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.naukri.com/");
		
		Set<String> winids = driver.getWindowHandles();
		Iterator<String> iterator = winids.iterator();
		String firstWindow = iterator.next();
		System.out.println(firstWindow);
		
	 	winids = driver.getWindowHandles();
	 	iterator = winids.iterator();
	 	iterator.next();
	 	String secondWindow = iterator.next();
	 	
	 	winids = driver.getWindowHandles();
	 	iterator = winids.iterator();
	 	iterator.next();
	 	iterator.next();
	 	String thirdWindow = iterator.next();
	 	
	 	winids = driver.getWindowHandles();
	 	iterator = winids.iterator();
	 	iterator.next();
	 	iterator.next();
	 	iterator.next();
	 	String fourthWindow = iterator.next();
	 	
	 	WebDriver win2 = driver.switchTo().window(secondWindow);
	 	System.out.println(win2.getTitle());
	 	driver.close();
	 	
	 	WebDriver win3 = driver.switchTo().window(thirdWindow);
	 	System.out.println(win3.getTitle());
	 	driver.close();
	 	
	 	WebDriver win4 = driver.switchTo().window(fourthWindow);
	 	System.out.println(win4.getTitle());
	 	driver.close();
	 	
	}
	 	
	 	public static void captureScreenshot() throws IOException {
	 		
	 		Date d = new Date();
	 		String fileName=d.toString().replace(":", "_").replace(" ", "_")+".png";
	 		
	 		File Screenshotfile= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	 		FileUtils.copyFile(Screenshotfile, new File("./screenshot/"+fileName));
	 		
	 	}
	 	
	 

	


}
