package testNGlearning;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase1 {
	
	@BeforeTest
	public void createDBConnection()
	{
		System.out.println("Create DB conn");
	}
	
	@AfterTest
	public void closeDBConnection()
	{
		System.out.println("Close DB conn");
	}
	
	@BeforeMethod
	public void launchBrowser()
	{
		System.out.println("launching Browser");
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		System.out.println("Closing Browser");
	}
	
	@Test(priority = 1)
	public void registerUser()
	{
		System.out.println("Executing register user test");
		
		//Reporter.log("Test case Pass");
	}

	@Test(priority = 2)
	public void doLogin()
	{
		System.out.println("Executing Login test");
	}
	
	
}
