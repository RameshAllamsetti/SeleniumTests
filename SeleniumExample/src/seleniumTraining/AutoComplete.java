package seleniumTraining;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class AutoComplete {
	
	@Test
	public void open() throws InterruptedException
	{
		
		WebDriver d = new FirefoxDriver();
		d.get("http://www.google.co.in");
		
	    d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    d.findElement(By.name("q")).sendKeys("Sele");
	    Thread.sleep(6000);
	    List<WebElement> acb =d.findElements(By.xpath("//*[@id='sbtc']/div[2]/div[2]/div[1]/div/ul"));
	    System.out.println("Size: "+acb.size());
	    acb.get(0).click();
	    d.findElement(By.name("btnG")).click();
	    
	    String s = (String) ((JavascriptExecutor) d).executeScript("return navigator.userAgent;");
		System.out.println("Browser name : " + s);
		
		d.quit();
	    
		
		
	}

}
