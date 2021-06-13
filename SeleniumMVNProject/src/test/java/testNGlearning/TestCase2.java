package testNGlearning;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCase2 {
	
	@Test
	public void validateTitle()
	{
		System.out.println("Beginning");
		String expected_title = "Gmail.com";
		String actual_title = "Google.com";
		
		SoftAssert assrt = new SoftAssert();
		
		assrt.assertEquals(actual_title, expected_title);
		assrt.fail("Forcefully failing the test");
		
		//To check if submit button present or not
		//isElementpresent(xpath of submit)--true/false
		
		assrt.assertTrue(false, "Failing the test as button is missing");
		
		System.out.println("Ending");
		
		assrt.assertAll();
	}

}
