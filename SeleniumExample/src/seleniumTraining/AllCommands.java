package seleniumTraining;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AllCommands {

	@Test
	public void allCommands() throws IOException, InterruptedException
	{

		WebDriver driver = new FirefoxDriver();
		
		//Open browser in IE
		System.setProperty("WebDriver.ie.driver","path of ie executable");
		WebDriver iedriver = new InternetExplorerDriver();
		
		//Open browser in Chrome
		System.setProperty("WebDriver.chorme.driver","path of chrome executable");
		WebDriver chromedriver = new ChromeDriver();

		WebElement welement = driver.findElement(By.id("idname"));
		List <WebElement> welements = driver.findElements(By.name("name"));

		//To open a web page
		driver.get("https://yahoo.com");
		driver.navigate().to("https://yahoo.com");

		driver.navigate().refresh();  //To refresh a web page
		driver.navigate().back(); // To go back to previous page
		driver.navigate().forward(); // To move to next page

		//Explicit Wait
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(welement));
		wait.until(ExpectedConditions.visibilityOfAllElements(welements));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("idname")));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("xpath of")));

		//implicit Wait
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		//Maximize window
		driver.manage().window().maximize();
		
		//Upload a file
		driver.findElement(By.xpath("input field")).sendKeys("path of the file which u want to upload");

		//Drag and Drop
		WebElement source = driver.findElement(By.id("source id"));
		WebElement target = driver.findElement(By.id("target id"));
		Actions act = new Actions(driver);
		act.dragAndDrop(source, target).perform();

		//Mouse Hover and Click
		WebElement mainMenu = driver.findElement(By.id("main menu id"));
		WebElement subMenu = driver.findElement(By.id("sub menu id"));
		Actions act1 = new Actions(driver);
		act1.moveToElement(mainMenu).build().perform();
		subMenu.click();
		
		//just for mouse hover on an element
		act1.moveToElement(mainMenu).perform();
		
		//mouse hover and click the element
		act1.moveToElement(mainMenu).click(subMenu).build().perform();

		//Right Click
		Actions act2 = new Actions(driver);
		act2.moveToElement(driver.findElement(By.cssSelector("css name"))).perform();
		act.contextClick().perform();
		
		//Checkbox or Radio button is selected or not
		driver.findElement(By.xpath("xpath of the checkbox/radio button")).isSelected();

		//Double Click
		WebElement ele2 = driver.findElement(By.cssSelector("css selector"));
		(new Actions(driver)).doubleClick(ele2).build().perform();
		
		//Refersh page using Actions class
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.F5).perform();
		
		//8 locators in Selenium
		//By.id(), By.name(), By.tagName(), By.className(), By.linkText(), By.partialLinkText(), By.xpath(), By.cssSelector();
		
		//Assert and Verify
		//Assert- is used to verify the result. If the test step fail then it will stop the execution of the testcase 
		//there itself and move the control to other testcase.
		//Verify- it is also used to verify the result. If the test step fail then it will not stop the execution of that test case


		//Scroll down or Scroll up
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.scrollBy(0, 4000)","");  // Scroll down value to 4000
		jsx.executeScript("window.scrollBy(4500,0", ""); // scroll up

		//WebBased Alerts
		Alert alert = driver.switchTo().alert();
		alert.accept(); // To click on OK in the alert 
		alert.dismiss() ; // To click on Cancel in the alert
		alert.sendKeys("Hello"); // To write in the alert popup
		driver.switchTo().window(driver.getWindowHandle()); //To navigate back to main page

		//Navigate between windows
		String windowName = driver.getWindowHandle();
		driver.switchTo().window(windowName);
		for(String handle: driver.getWindowHandles())
		{
			driver.switchTo().window(handle);
		}
		
		//*******
		//Total no.of links in page	
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
			Thread.sleep(3000);		
			System.out.println("Link is Clicked");		
			if(driver.getPageSource().contains("404 NOT Found"))
			{
				System.out.println(t +"is BROKEN");
				brokenLinks++;
			}		
			driver.navigate().back();			
		}
		
		System.out.println("NUMBER OF BROKEN LINKS: "+brokenLinks);	
		
		//*******
		
		//Total no.of rows in a table 
		List <WebElement> rows = driver.findElements(By.className("class name"));
		int totalrows = rows.size();

		//Get number of options are available in drop down
		Select sel= new Select(driver.findElement(By.id("drop down ID")));
		int  totalOption  = sel.getOptions().size();
		
		//Select the value from drop down or menu item
		sel.selectByVisibleText("Pass your desire Text");
		sel.selectByIndex (0);
		sel.selectByValue("Pass your desire Text");
		
		//Deselect all from the dropdown
		sel.deselectAll();
		
		//Which options are selected
		//SelctedOptions<List>  selOptions= sel.getAllSelectedOptions();
		
		//Getting typed text from a textfiled
		String typedText = driver.findElement(By.xpath("xpath of box")).getText();
		
		//clear the contents of a text field
		driver.findElement(By.id("idname")).clear();
		
		//Checking an element is Visibale on the webpage or not
		driver.findElement(By.name("name of the locator")).isDisplayed();
		
		//Button is enabled or not
		driver.findElement(By.xpath("xpath of button")).isEnabled();
		
		//difference between close() and quit()
		driver.close(); //closes the currently opened browser where the control is 
		driver.quit(); // closes all the browsers opened by webdriver
		

		
		/*Achieving synchronization in webDriver 
		Here it will wait for 10sec if while execution driver did not find the element in the page immediately. 
		This code will attach with each and every line of the script automatically. 
		It is not required to write every time. Just write it once after opening the browser
		*/
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		//Verify dropdown supported multiple options or not
		Select sel1= new Select(driver.findElement(By.id("drop down ID")));
		Boolean status = sel1.isMultiple();
		
		//Different exceptions in WebDriver
		//ElementNotVisibleException, ElementNotSelectableException, NoAlertPresentException,
		//NoSuchAttributeException, NoSuchWindowException, TimeoutException, WebDriverException 
		
		//Handling Auto complete box 
		driver.findElement(By.id("your searchbox")).sendKeys("Partila keyword");
		Thread.sleep(3000);
		List<WebElement> listItems = driver.findElements(By.xpath(".//*[@id='sbtc']/div[2]/div[2]/div[1]/div/ul"));
		listItems.get(0).click();
		driver.findElement(By.id("Your search button")).click();
	
		//To take the screen shot
		EventFiringWebDriver eDriver=new EventFiringWebDriver(driver);
		File srcFile = eDriver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("path"));

		File srcFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); //now we can do anything with this screenshot
		FileUtils.copyFile(srcFile1,new File("path"));

		//To get font size and color details
		driver.findElement(By.xpath("xpath")).getCssValue("font-size"); //font size
		driver.findElement(By.xpath("xpath")).getCssValue("font-colour"); //font color
		driver.findElement(By.xpath("xpath")).getCssValue("font-type"); //font type
		driver.findElement(By.xpath("xpath")).getCssValue("background-colour"); //background color
		driver.findElement(By.xpath("xpath")).getSize().getHeight();  //Height of the text filed
		driver.findElement(By.xpath("xpath")).getSize().getWidth(); //Width of the text field

		//To open browser in other language
		FirefoxProfile fp = new FirefoxProfile();
		fp.setPreference("intl.accept_languages","jp");
		WebDriver d1 = new FirefoxDriver(fp);
		d1.get("http://google.com"); //will open google in japanese language

		//To get the browser name
		String s = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;");
		System.out.println("Browser name : " + s);

		//Get text from Captcha image
		driver.findElement(By.xpath(".//*[@id='SkipCaptcha']")).click();
		String attr = driver.findElement(By.xpath(".//*[@id='SkipCaptcha']")).getAttribute("value");
		System.out.println(attr);
		
		//Changing user agent
		FirefoxProfile fp2 = new FirefoxProfile();
		fp2.setPreference("general.useragent.override", "some UA String");
		WebDriver d01 = new FirefoxDriver(fp2);


		//Click hidden link
		WebElement Block1 = driver.findElement(By.id("element ID"));
		JavascriptExecutor js1=(JavascriptExecutor)driver;
		js1.executeScript("$("+Block1+").css({'display':'block'});");

		//disable cookies
		driver.manage().deleteAllCookies();

		//Handling https websites 
		FirefoxProfile profile = new FirefoxProfile();
		profile.setAcceptUntrustedCertificates(false);
		WebDriver driver5 = new FirefoxDriver(profile);
		driver5.get("url");

		//To Click Enter or TAB button
		Actions act3 = new Actions(driver);
		act3.sendKeys(Keys.ENTER);
		act3.sendKeys(Keys.TAB);
		act3.sendKeys(Keys.F1);

		//Switch back from a frame
		driver.switchTo().defaultContent();
		
		//Overloaded methods in WebDriver
		driver.switchTo().frame(5); //integer
		driver.switchTo().frame("2ndwindow"); //String
		driver.switchTo().frame(source);  //WebElement
		
		//Exceptions in WebDriver
	//     throw new WebDriverException();
	  //   throw new ElementNotVisibleException("not visible");

		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability("chrome.switches", Arrays.asList("--user-data-dir=/path/to/profile/directory"));
		WebDriver driver0 = new ChromeDriver(capabilities);

		
		//Running testng.xml from command line
		// java -cp bin;jars/* org.testng.TestNG testng.xml

		//http://username:password@url  login into any site if its showing any authetication popup 

		//Default Port number for Selenium is = 4444

		//Default IDle timeout in Selenium is 30 seconds

		//Webdriver version 2.52.0

/*
		//Read the data from xl file
		FileInputStream fis = new FileInputStream("c:/ab.xls");
		
		Workbook wb = Workbook.create(fis);
		Sheet s = wb.getSheet("sheetName");
		String value = s.getRow(rowNum).getCell(cellNum).getString().cellValue(); //read data
		s.getRow(rowNum).getCell(cellNum).setCellValue("value to be set"); //write data

 		FileOutputStream fos = new FileOutputStream(“path of file”);

 		wb.write(fos); //save file
 		
 		//CONNECTING TO DB
 		
 			//Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"        
		String dbUrl = "jdbc:mysql://localhost:3036/emp";                   

		//Database Username     
		String username = "root";   

		//Database Password     
		String password = "guru99";             

		//Query to Execute      
		String query = "select *  from employee;";  

		//Load mysql jdbc driver        
		Class.forName("com.mysql.jdbc.Driver");         

		//Create Connection to DB       
		Connection con = DriverManager.getConnection(dbUrl,username,password);

		//Create Statement Object       
		Statement stmt = con.createStatement();                  

		// Execute the SQL Query. Store results in ResultSet        
		ResultSet rs= stmt.executeQuery(query);                         

		// While Loop to iterate through all data and print results     
		while (rs.next()){
			String myName = rs.getString(1);                                        
			String myAge = rs.getString(2);                                                
			System. out.println(myName+"  "+myAge);     
		}       
		// closing DB Connection       
	*/	
		//To design test scripts that will run on the grid, we need to use DesiredCapabilites and the RemoteWebDriverobjects.
		//	DesiredCapabilites is used to set the type of browser and OS that we will automate
		//	RemoteWebDriver is used to set which node (or machine) that our test will run against.
		
		//SEtting up the selenium server as node and hub
		// Configure selenium server as  hub
		//c:/> java -jar selenium-server-stanalone-2.46.0.jar -role hub 
				
		//Configure selenium server as  node
		//c:/> java -jar selenium-server-stanalone-2.46.0.jar -role webdriver -hub http://hubip:4444/grid/register -port 5666
				
		DesiredCapabilities capability = DesiredCapabilities.firefox();
		capability.setBrowserName("firefox");
		capability.setPlatform(Platform.WIN8);
		
		RemoteWebDriver wd = new RemoteWebDriver(new URL("http://192.168.1.1.4:5566/wd/hub"), capability);
	
		//What Is StaleElementReferenceException?
		//Stale means old or we can say no longer fresh element. Let me describe you In very simple words. Example : 
		//You have a search text box on software web page. When you search for some keyword, text box's position get changed on page. 
		//So In this case, Look and feel, Identifiers etc. of text box will remain same but what Internally happened 
		//Is -> JS library has deleted previous text box and replaced It with new same text box. 
		//So now If you will go to use same text box using previously located reference In your software test,
		//You will get StaleElementReferenceException
			/*
		 * The Hub
•	The hub is the central point where you load your tests into.
•	There should only be one hub in a grid.
•	The hub is launched only on a single machine, say, a computer whose O.S is Windows 7 and whose browser is IE.
•	The machine containing the hub is where the tests will be run, but you will see the browser being automated on the node.
The Nodes
•	Nodes are the Selenium instances that will execute the tests that you loaded on the hub.
•	There can be one or more nodes in a grid.
•	Nodes can be launched on multiple machines with different platforms and browsers.
•	The machines running the nodes need not be the same platform as that of the hub.
*/
		
	/*	TestNG has an inbuilt reporting ability in it.
		After a complete execution of test cases TestNG generates test-output folder in root of project.
		In test-output folder there are two main reports, index.html and emailable-report.html.
		To customize TestNG report we need to implement two interfaces, ITestListener and IReporter.
		If we need to get report in between execution, we need ITestListener.
		For creating final report after complete execution we need to implement IReporter.
		Taking screen shot in Selenium WebDriver, we need to type cast WebDriver to TakesScreenShot interface.
		To generate pdf reports we need to add IText jar in project.
*/
		/*
		@DataProvider
		public Object[][] readData() throws IOException
		{
			File inputxl = new File("src//test//resources//TestData//legacyaccounts.xlsx");
			FileInputStream fis = new FileInputStream(inputxl);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet ws =  wb.getSheet("padaccountswithbufs");

			int rows = ws.getLastRowNum();
			int columns = ws.getRow(rows).getLastCellNum();
			
			System.out.println("No of Rows in XL : "+rows);
			System.out.println("No of Columns in XL : "+columns);
			
			Object[][] data = new Object[rows][columns];
			
			for(int row=0; row<ws.getLastRowNum();row++)
			{
				for(int column=0;column<ws.getRow(row).getLastCellNum();column++)
				{
					data[row][column] = ws.getRow(row).getCell(column).getStringCellValue();		
				}	
			}
			return data;
		}
		
		@Test(dataProvider="readData")
		public void ecFlow(String countryName,String buyerEmail,String currencyCode,String sellerEmail) throws Exception
		{
		
			System.out.println(countryName +"----"+buyerEmail+"----"+currencyCode+"----"+sellerEmail);
		}
		 
   */


	}


}
