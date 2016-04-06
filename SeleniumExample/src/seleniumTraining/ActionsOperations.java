package seleniumTraining;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsOperations {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		
		
		//Drag and Drop operation
		driver.navigate().to("http://executeautomation.com/demosite/Dragging.html");
		WebElement source = driver.findElement(By.id("item1"));
		WebElement dest = driver.findElement(By.id("item3"));
		dragAndDrop(driver, source, dest);
		Thread.sleep(5000);
		driver.close();
		/*
		//Mouse Hover
		driver.navigate().to("http://executeautomation.com/demosite/index.html?");
		WebElement hoverElement = driver.findElement(By.id("Selenium"));
		hover(driver, hoverElement);
		Thread.sleep(5000);
		driver.close();
		
		//Mouser Hover and Click on hover Element
		driver.navigate().to("http://executeautomation.com/demosite/index.html?");
		WebElement hoverElement1 = driver.findElement(By.id("Selenium"));
		WebElement clickElement1 = driver.findElement(By.id("Selenium WebDriver"));
		hoverAndClick(driver, hoverElement1, clickElement1);
		Thread.sleep(5000);
		driver.close();
		
		//RightClick
		WebElement rightClickElement = driver.findElement(By.id("Initial"));
		rightClick(driver, rightClickElement);
		Thread.sleep(5000);
		driver.close();
		*/	
		
	}
	
	public static void dragAndDrop(WebDriver driver,WebElement source,WebElement destination)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(source, destination).perform();
	}
	
	public static void hover(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();	
	}
	
	public static void hoverAndClick(WebDriver driver,WebElement hoverElement,WebElement clickableElement)
	{
		Actions act = new Actions(driver);
		act.moveToElement(hoverElement).click(clickableElement).build().perform();
		
	}
	
	public static void rightClick(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}

}
