package seleniumTraining;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserExample {
	
	WebDriver driver;	
  
  @BeforeTest
  @Parameters("browser")
  public void setup(String browser) throws Exception {
	  if(browser.equalsIgnoreCase("firefox"))
	  {
		  driver = new FirefoxDriver();
	  }
	  else if(browser.equalsIgnoreCase("chrome"))
	  {
		  System.setProperty("webdriver.chrome.driver", "//Users//rallamsetti//Desktop//chromedriver");
		  driver = new ChromeDriver();
	  }
	  
	  else if(browser.equalsIgnoreCase("ie"))
	  {
		  System.setProperty("webdriver.ie.driver", "//Users//rallamsetti//Desktop//iexploerdriver");
		  driver = new InternetExplorerDriver();
	  }
	  
	  else 
	  {
		  throw new Exception("Browser is not correct");
	  }
	  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }
  
  @Test
  public void testParameterWithXml() {
	  driver.get("http://demo.guru99.com/V4/");
	  
      //Find user name
	  	WebElement userName = driver.findElement(By.name("uid"));

      //Fill user name
	  	userName.sendKeys("guru99");

      //Find password
	  	WebElement password = driver.findElement(By.name("password"));

      //Fill password
	  	password.sendKeys("guru99");
  }

}
