package seleniumTraining;



import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//Method- If the SAME DataProvider should behave differently with different test method , use Method parameter.

/*
 ITestContext- It can used to create different parameters for test cases based on groups.

In real-life , you can use ITestContext to vary parameter values based on Test Methods , hosts , configurations of the test.
 */



public class DataProviderWithMethodParam {
	
	WebDriver driver;
	
	 @DataProvider(name="SerachProvider")
	  public Object[][] getDataFromDataProvider(Method m)
	  {
		  if(m.getName().equalsIgnoreCase("testMethodA"))
		  {
			  return new Object[][] 
					  {		  
					  	{"Ramesh","India"},
					  	{"Srinu","US"},
					  	{"Viajy","Dubai"}
					  };
			  }
		  else
		  {
			  
	          return new Object[][] {
	                  {"India"},
	                  {"US"},
	                  {"Dubai"}
	              };

	      }
		  
	     }
	

	
	@BeforeTest
	public void setup()
	{
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://google.com");
		
	}
	
	
	@Test(dataProvider= "SerachProvider")
	public void testMethodA(String name,String country) throws InterruptedException
	{
		 WebElement searchText = driver.findElement(By.name("q"));		 
         //Search text in search box
         searchText.sendKeys(name);
         //Print author and search string
         System.out.println("Welcome ->"+name+" Your search key is->"+country);

         Thread.sleep(3000);

         String testValue = searchText.getAttribute("value");

         System.out.println(testValue +"::::"+name);
         searchText.clear();
         //Verify if google text box is showing correct value
         Assert.assertTrue(testValue.equalsIgnoreCase(name));
       
	}
	
	@Test(dataProvider= "SerachProvider")
	public void testMethodB(String country) throws InterruptedException
	{
		 WebElement searchText = driver.findElement(By.name("q"));		 
         //Search text in search box
         searchText.sendKeys(country);
         //Print author and search string
         System.out.println("Welcome NoName Your search key is->"+country);

         Thread.sleep(3000);

         String testValue = searchText.getAttribute("value");

         System.out.println(testValue +"::::"+country);
         searchText.clear();
         //Verify if google text box is showing correct value
         Assert.assertTrue(testValue.equalsIgnoreCase(country));
         
	}
	
	@AfterTest
	public void afterTest()
	{
		driver.quit();
	}
	
 
}
  
