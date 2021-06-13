package testNGlearning;

import java.util.Date;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestParameters {
	
	@Parameters({"browser", "url"})
	@Test
	public void doLogin(String browser, String url) throws InterruptedException {
		
		Date d = new Date();
		System.out.println(d.toString());
		
		System.out.println(browser+"---"+url);
		
		Thread.sleep(2000);
	}
	
	

}
