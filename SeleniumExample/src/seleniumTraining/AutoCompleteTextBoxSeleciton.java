package seleniumTraining;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AutoCompleteTextBoxSeleciton {

 @Test
public void auto() throws InterruptedException
{
	WebDriver d1 = new FirefoxDriver();
	
	d1.manage().deleteAllCookies();
	
	d1.get("http://www.google.co.in/");
	
	Thread.sleep(6000);
	
	System.out.println("ELE IS ENABLED : "+ d1.findElement(By.xpath("//input[@id='lst-ib']")).isEnabled());
	
	WebDriverWait wait = new WebDriverWait(d1, 10);
	wait.until(ExpectedConditions.visibilityOf(d1.findElement(By.xpath("//input[@id='lst-ib']"))));
	
	d1.findElement(By.xpath("//input[@id='lst-ib']")).sendKeys("java");
	
	Thread.sleep(4000);
	
	List<WebElement> l1 = d1.findElements(By.xpath(".//*[@id='sbse1']/div[2]"));
	l1.get(0).click();
	
	Thread.sleep(4000);
	
	d1.findElement(By.xpath(".//*[@id='sblsbb']/button")).click();
	
	d1.close();
	
}

}
