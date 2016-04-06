package seleniumTraining;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ClickAllLinks {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	@Test
	public void clickAllLInks() throws InterruptedException
	{
		
		WebDriver driver = new FirefoxDriver();		
		String baseUrl = "http://newtours.demoaut.com/";		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		driver.get(baseUrl);		
		List<WebElement> linkElements = driver.findElements(By.tagName("a"));	
		System.out.println("NUMBER OF LINKS IN THE PAGE: "+linkElements.size());	
		String linkTexts[] = new String[linkElements.size()];	
		int i =0;	
		int brokenLinks = 0;
		//Getting all the link names
		for(WebElement name:linkElements)
		{
			linkTexts[i] = name.getText();
			System.out.println(linkTexts[i]);
			i++;
		}
		
		//Clicking on each link
		for(String t: linkTexts)
		{
			driver.findElement(By.linkText(t)).click();		
			Thread.sleep(1000);		
			System.out.println("Link is Clicked");		
			if(driver.getPageSource().contains("404"))
			{
				System.out.println(t +" is BROKEN");
				brokenLinks++;
			}		
			driver.navigate().back();			
		}
		
		System.out.println("NUMBER OF BROKEN LINKS: "+brokenLinks);
		
		driver.quit();
		
		
	}

}
