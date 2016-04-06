package seleniumTraining;


import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class YahooTest {
	
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("Yahoo Test Before Test Method");
		//throw new SkipException("Skipping the Yahoo test forcefully so that Yahoo test method won't be executed");
	}
	
	@Test
	public void test()
	{
		System.out.println("Yahoo test Method is executed");
		
		//Assert.assertEquals("Good", "Good");
		
		System.out.println("Before error condition");
		try
		{
		Assert.assertTrue(3<1, "Error Condition1");
		}catch(Throwable T)
		{
			System.out.println("Error caught during run time");
		}
		
		System.out.println("After the error condition");
		Assert.assertFalse(3<1, "Error Condition2");
		
	}

}
