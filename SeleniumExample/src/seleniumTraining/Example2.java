package seleniumTraining;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;



public class Example2 {

 @Test	
 public void openBrowser2() throws InterruptedException, IOException
 {
	 WebDriver d1 = new FirefoxDriver();
	  
	  d1.get("https://www.stage2p2032.qa.paypal.com/cmd=_login-run");
	  System.out.println("Titel of the PAGE: "+d1.getTitle());
	 
	  //Explicit wait
//	  WebDriverWait wait = new WebDriverWait(d1, 30);
//	  wait.until(ExpectedConditions.visibilityOf(d1.findElement(By.id("login_email"))));
	  
	  //implict wait
	  d1.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  
	  System.out.println(d1.findElement(By.id("login_email")).isDisplayed());
	  
	  Assert.assertTrue(d1.findElement(By.id("login_email")).isDisplayed(), "Email Text field presented");
	  
	  d1.findElement(By.id("login_email")).sendKeys("ramesh-bmlbuyer@paypal.com");
	  d1.findElement(By.id("login_password")).sendKeys("11111111");
	  d1.findElement(By.name("submit.x")).click();
	
	
	  
	  //Explicit wait
//	  WebDriverWait wait1 = new WebDriverWait(d1, 30);
//	  wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Send Money')]")));
//	  
	//Taking the ss   
	  File file= ((TakesScreenshot)d1).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(file, new File("//Users//rallamsetti//Desktop//a.png"));
	  
	  
	  d1.findElement(By.xpath("//a[contains(text(),'Send Money')]")).click();
	  
	//  wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
	  
	//Taking the ss   
	  File file1= ((TakesScreenshot)d1).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(file1, new File("//Users//rallamsetti//Desktop//a2.png"));
	  
	  d1.findElement(By.id("email")).sendKeys("ramesh-bmlseller@paypal.com");
	  d1.findElement(By.id("amount")).sendKeys("50");
	  
	  Select s1 = new Select(d1.findElement(By.id("amount_ccode")));
	 // s1.selectByValue("GBP — British Pounds");
	  s1.selectByVisibleText("GBP — British Pounds");
	  
	 // Assert.assertTrue(d1.getPageSource().contains("Review your payment and send"));
	  d1.findElement(By.id("GoodsServices")).click();
	  d1.findElement(By.id("submit")).click();
	  
	//  wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#navigational-links > a")));
	  
	  Assert.assertTrue(d1.getPageSource().contains("Review your payment and send"));
	 
	
	  Thread.sleep(9000);
	  d1.quit();
	
 }

}
