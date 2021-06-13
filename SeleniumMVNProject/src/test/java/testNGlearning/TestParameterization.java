package testNGlearning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ExcelReader;

public class TestParameterization {
	
	public static WebDriver driver;
	
	@BeforeTest
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
	
	@Test(dataProvider = "dp")
	public void doLogin(String UserName, String Password) {
		
		//System.out.println(UserName+"----"+Password);
		
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys(UserName);
		driver.findElement(By.id("pass")).sendKeys(Password);
		//driver.findElement(By.id("u_0_b")).click();
		
	}
	
	@DataProvider(name = "dp")
	public Object[][] getData() {
		
		ExcelReader excel = new ExcelReader(".\\src\\test\\resources\\excel\\TestData.xlsx");
		
		String sheetname = "LoginTest";
		
		int rows = excel.getRowCount(sheetname);
		int cols = excel.getColumnCount(sheetname);
		
		System.out.println(excel.getCellData(sheetname, 0, 3));
		System.out.println("Total rows are: "+rows+"---Total Cols are: "+cols);
		
		Object[][] data = new Object[rows-1][cols];
		
		for(int rowNum=2; rowNum<=rows; rowNum++ )
		{
			for(int colNum=0; colNum<cols; colNum++)
			{
				//data[0][0] = excel.getCellData(sheetname, 0, 2);
				data[rowNum-2][colNum] = excel.getCellData(sheetname, colNum, rowNum);
			}
		}
		
		/*data[0][0] = excel.getCellData(sheetname, 0, 2);
		data[0][1] = excel.getCellData(sheetname, 1, 2);
		
		data[1][0] = excel.getCellData(sheetname, 0, 3);
		data[1][1] = excel.getCellData(sheetname, 1, 3);
		
		data[2][0] = excel.getCellData(sheetname, 0, 4);
		data[2][1] = excel.getCellData(sheetname, 1, 4);
		*/
		return data;
		
	}

}
