package seleniumTraining;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class iFrameCount {

	@Test
	public void countFrames()
	{
		WebDriver d = new FirefoxDriver();
		d.get("http://www.eenadu.net");
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Total frames
		int totalFrames = d.findElements(By.tagName("iframe")).size();
		System.out.println("Total Frames: "+totalFrames);
		
		//Total links
				int totalLinks = d.findElements(By.tagName("a")).size();
				System.out.println("Total Links: "+totalLinks);
		
		d.quit();
	
	}
}
