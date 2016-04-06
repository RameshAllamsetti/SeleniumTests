package seleniumTraining;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;


public class OpenBrowser {
	
	public static void main(String ar[]) throws InterruptedException, IOException
	{
	  //WebDriver d1 = new FirefoxDriver();
	  
	 // d1.get("http://www.gmail.com");
	  
	  
	  FirefoxProfile fp = new FirefoxProfile();
		fp.setPreference("intl.accept_languages","jp");
		WebDriver d1 = new FirefoxDriver(fp);
		d1.get("http://google.com");
		Thread.sleep(3000);
		System.out.println("Titel of the PAGE: "+d1.getTitle());
	  
	  /*d1.findElement(By.id("Email")).sendKeys("ramesh531@gmail.com");
	  d1.findElement(By.id("Passwd")).sendKeys("zooFoo6a@");
	  d1.findElement(By.id("signIn")).click();
	  
	//Taking the ss   
	  File file= ((TakesScreenshot)d1).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(file, new File("//Users//rallamsetti//Desktop//a.png"));

	  WebDriverWait wait = new WebDriverWait(d1, 30);
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id=':j3']/div/div")));
	  
	  Assert.assertTrue(d1.findElement(By.xpath("//div[@id=':j3']/div/div")).isDisplayed(),"Compose is displayed in the page");*/
	 
	  
//	  d1.findElement(By.xpath("//div[@id=':j3']/div/div")).click();
//	  
//	  Thread.sleep(3000);
//	  
//	  d1.findElement(By.xpath("//div[@id=':j3']/div/div")).click();
//	  
//	 d1.quit();
	  
	  
	}
	

}
