package testCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDropDown {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//driver.get("http://www.echoecho.com/htmlforms11.htm");
		//driver.findElement(By.xpath("//td[3]/select")).sendKeys("Milk");
		
		driver.get("https://www.wikipedia.org/");
		
		WebElement dropdown = driver.findElement(By.id("searchLanguage"));
		Select select = new Select(dropdown);
		//select.selectByVisibleText("Dansk");
		select.selectByValue("hi");
		
		//To print the count and all the dropdown option present:
		
		List<WebElement> values = driver.findElements(By.tagName("option"));
		System.out.println(values.size());
		
		for (int i=0; i<values.size(); i++)
		{
			System.out.println(values.get(i).getAttribute("lang"));
		}
		
		//To print the count of all the links, we have a common tag 'a'
		
		/*List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total links present: "+links.size());
		
		for (WebElement link: links )
		{
			System.out.println(link.getText()+"--URL--"+link.getAttribute("href"));
		}*/
		
		WebElement block = driver.findElement(By.xpath("//*[@id=\"www-wikipedia-org\"]/div[9]/div[3]"));
		List<WebElement> sublinks = block.findElements(By.tagName("a"));
		
        System.out.println("Total links present: "+sublinks.size());
		
		for (WebElement sublink: sublinks )
		{
			System.out.println(sublink.getText()+"--URL--"+sublink.getAttribute("href"));
		}
		
		
	

	}

}
