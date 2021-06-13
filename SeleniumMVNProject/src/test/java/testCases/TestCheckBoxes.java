package testCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCheckBoxes {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://www.tizag.com/htmlT/htmlcheckboxes.php");
		
		/*driver.findElement(By.xpath("//div[4]/input[1]")).click();
		driver.findElement(By.xpath("//div[4]/input[2]")).click();
		driver.findElement(By.xpath("//div[4]/input[3]")).click();
		driver.findElement(By.xpath("//div[4]/input[4]")).click();*/
		
		/*for (int i=1; i<=4; i++)
		{
			driver.findElement(By.xpath("//div[4]/input["+i+"]")).click();
		}*/
		
		/*int i=1;
		while (true)
		{
			driver.findElement(By.xpath("//div[4]/input["+i+"]")).click();
			i++;
		}*/
		
		WebElement block = driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]"));
		List<WebElement> checkboxes  = block.findElements(By.name("sports"));
		
		System.out.println(checkboxes.size());
		
		for (WebElement checkbox: checkboxes)
		{
			checkbox.click();
			System.out.println(checkbox.getAttribute("value"));
			
		}
		
		
	}

}
