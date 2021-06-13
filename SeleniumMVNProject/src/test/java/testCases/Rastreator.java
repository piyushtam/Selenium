package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Rastreator {
	
	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		
		driver.get("https://seguros-coche.rastreator.com/datos-comparativa.aspx#Q1");
		driver.findElement(By.id("li00008")).click();
		driver.findElement(By.id("li001")).click();
		driver.findElement(By.id("D")).click();
		driver.findElement(By.id("70")).click();
		driver.findElement(By.id("Maindriver")).click();
		driver.findElement(By.id("NewCar")).click();
		driver.findElement(By.id("PrivateWeekend")).click();
		driver.findElement(By.id("StreetParking")).click();
		driver.findElement(By.id("KM3000")).click();
		driver.findElement(By.id("labelYesCar")).click();
		driver.findElement(By.id("Two")).click();
		driver.findElement(By.id("CJDriverDetailsDateOfBirth_Day")).sendKeys("18");
		
	
		WebElement dropdown = driver.findElement(By.id("CJDriverDetailsDateOfBirth_Month"));
		Select select = new Select(dropdown);
		select.selectByVisibleText("Noviembre");
		
		driver.findElement(By.id("CJDriverDetailsDateOfBirth_Year")).sendKeys("1993");
		driver.findElement(By.id("btn_submit")).click();
		
		driver.findElement(By.id("image724")).click();
		
		WebElement dropdown1 = driver.findElement(By.id("CJDriverDetailsLicenceDate_Month"));
		new Select(dropdown1).selectByVisibleText("Enero");
		
		WebElement dropdown2 = driver.findElement(By.id("CJDriverDetailsLicenceDate_Year"));
		new Select(dropdown2).selectByVisibleText("2013");
		
		driver.findElement(By.id("btn_submit")).click();
		driver.findElement(By.id("image724")).click();
		driver.findElement(By.id("image_Male")).click();
		driver.findElement(By.id("Single")).click();
		driver.findElement(By.id("span_No")).click();
		driver.findElement(By.id("TechnicianAdministrativeClerk")).click();
		driver.findElement(By.id("txtPostalCode")).sendKeys("08009");
		Thread.sleep(3000);
		driver.findElement(By.id("btnPostalCodeClick")).click();
		driver.findElement(By.id("btnSkipAddress")).click();
		driver.findElement(By.id("LessThan1")).click();
		driver.findElement(By.id("MainDriver")).click();
		driver.findElement(By.id("txtDniNumber")).sendKeys("55555555k");
		driver.findElement(By.id("btnDniClick")).click();
		driver.findElement(By.id("defaulterNo")).click();
		driver.findElement(By.id("No")).click();
		driver.findElement(By.id("No")).click();
		driver.findElement(By.id("spanNo")).click();
		
		//WebDriverWait wait = new WebDriverWait(driver, 5);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inputRadioYes"))).click();
		
		driver.findElement(By.xpath("//*[@id=\"divYes\"]/label/div/span")).click();
	
		driver.findElement(By.id("count-plus-1")).click();
		driver.findElement(By.id("count-plus-2")).click();
		driver.findElement(By.id("btnFinesConfirmClicked")).click();
		
		WebElement dropdown3 = driver.findElement(By.id("CJCarInsuranceDetailsExpectedPolicyBuyDate_Day"));
		new Select(dropdown3).selectByVisibleText("10");
		
		WebElement dropdown4 = driver.findElement(By.id("CJCarInsuranceDetailsExpectedPolicyBuyDate_Month"));
		new Select(dropdown4).selectByVisibleText("Febrero");
		
		WebElement dropdown5 = driver.findElement(By.id("CJCarInsuranceDetailsExpectedPolicyBuyDate_Year"));
		new Select(dropdown5).selectByVisibleText("2021");
		
		driver.findElement(By.id("btn_submit")).click();
		driver.findElement(By.id("ThirdParty")).click();
		driver.findElement(By.id("txtEmail")).sendKeys("piyush.tamrakar@inspopindia.com");
		driver.findElement(By.id("txtphone")).sendKeys("983766312");
		driver.findElement(By.xpath("//*[@id=\"frmEmail\"]/div/div[1]/div[3]/label/div/span[1]")).click();
		
		
		
		
		
		
		
	}

}
