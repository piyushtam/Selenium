package testNGlearning;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase3 {
	
	
	@Test(priority = 1)
	public void registerUser()
	{
		System.out.println("Executing register user test");
		Assert.fail("Submit button is missing");
	}

	@Test(priority = 2, dependsOnMethods = "registerUser")
	public void doLogin()
	{
		System.out.println("Executing Login test");
	}

}

