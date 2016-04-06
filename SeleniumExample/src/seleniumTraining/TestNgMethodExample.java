package seleniumTraining;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestNgMethodExample {
	
	@BeforeMethod
	public void openBrowser()
	{
		System.out.println("Open the browser");
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		System.out.println("Closing the browser");
	}
	
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("Connect to DB");
	}
	
	@AfterTest
	public void afterTest()
	{
		System.out.println("Close the DB connection");
	}
	
	@Test
	public void sendEmail()
	{
		System.out.println("Sending the Email");
	}
	
	@Test
	public void ReceiveEmail()
	{
		System.out.println("Receiving the Email");
	}

	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("Initialize Selenium");
	}
	
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("Destroy Selenium");
	}
}
