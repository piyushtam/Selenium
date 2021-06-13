package testCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestIframe {

	public static void main(String[] args) {

		
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
			
			driver.switchTo().frame("iframeResult");
			driver.findElement(By.xpath("/html/body/button")).click();
			
			/*Set<String> winids = driver.getWindowHandles();
			Iterator<String> iterator = winids.iterator();
			String firstWindow = iterator.next();*/
			
			//Instead of this above handles we can use:
			
			driver.switchTo().defaultContent();
			
			//driver.switchTo().window(firstWindow);
			
			List<WebElement> frames = driver.findElements(By.tagName("iframe"));
			System.out.println(frames.size());
			
			for (WebElement frame : frames)
			{
				System.out.println(frame.getAttribute("id"));
			}
			
			

	}

}
