package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestW2A {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://qa.way2automation.com");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		
		
		driver.findElement(By.xpath("//*[@id=\"load_form\"]/fieldset[3]/input")).sendKeys("trainer@way2automation.com");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class=\"ajaxsubmit\"]/fieldset[1]/input"))).sendKeys("Piyush");
		//driver.findElement(By.xpath("//*[@class=\"ajaxlogin\"]/fieldset[1]/input")).sendKeys("piyush");
		//driver.findElement(By.xpath("//*[//*[@class=\"ajaxsubmit\"]/div/div[2]/input")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class=\"ajaxsubmit\"]/div/div[2]/input"))).click();
		
	}

}
