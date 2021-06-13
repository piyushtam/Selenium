package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestRightClick {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo/sub-menus.html");
		
		WebElement button = driver.findElement(By.xpath("/html/body/div/section/div/div/div/p/span"));
		
		Actions action = new Actions(driver);
		action.contextClick(button).perform();
		
		WebElement menu = driver.findElement(By.xpath("/html/body/ul/li[6]"));
		action.moveToElement(menu).perform();
		
		WebElement submenu = driver.findElement(By.xpath("/html/body/ul/li[6]/ul/li[2]"));
		action.moveToElement(submenu).perform();
		
		driver.findElement(By.xpath("/html/body/ul/li[6]/ul/li[2]/ul/li[1]")).click();

	}

}
