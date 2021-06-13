package testCases;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestTabsAndPopups {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://www.way2automation.com/");
		
		Set<String> winids = driver.getWindowHandles(); //1
		Iterator<String> iterator = winids.iterator();
		String firstWindow = iterator.next();
		
		System.out.println(firstWindow);//-to get the first window
		
		driver.findElement(By.xpath("//*[@id=\"wrapper\"]/header/div[2]/div/div[2]/div/a[1]")).click();
		
		winids = driver.getWindowHandles(); //2
		iterator = winids.iterator();
		
		System.out.println(iterator.next());
		
		String secondWindow = iterator.next(); //2nd
		System.out.println(secondWindow);
		
		
		driver.switchTo().window(secondWindow);
		
		driver.findElement(By.id("user_email")).sendKeys("pyush1811@gmail.com");
		
		
		

	}

}
