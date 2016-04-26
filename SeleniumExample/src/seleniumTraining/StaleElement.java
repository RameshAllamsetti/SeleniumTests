package seleniumTraining;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class StaleElement
{
	WebDriver driver;
	@BeforeTest
	public void setup()
	{
		
		driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://www.github.com");
		
	}
	
	@Test
	public void get() throws InterruptedException
	{
			
		WebElement searchBox = driver.findElement(By.xpath("//input[@name='q']"));
		searchBox.sendKeys("hello");
		searchBox.sendKeys(Keys.ENTER);
		
		Thread.sleep(5000);
		
		//After serach opeartion element position is changed.Now i'm using same reference variable to clear search
		//text box . so here WebDriver won't be able to locate element using the same reference and it will throw 
		//StaleElementReferenceException
		searchBox.clear();
	}
}