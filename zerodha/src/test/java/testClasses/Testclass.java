package testClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Configuration.Configure;

public class Testclass {

	static POMclass po;
	static WebDriver driver;
	
		 
		 @BeforeClass
		 public void launchBrowser() {
			 System.setProperty("webdriver.chrome.driver", Configure.driverpath);
			 driver = new ChromeDriver();
			 po = new POMclass(driver);
			 driver.get("https://kite.zerodha.com/");
				driver.manage().window().maximize();
				
			}
		 
		 @BeforeMethod
		 public void maximize() {
			 driver.manage().window().maximize();
		 }
		 
		 @Test
		 public void tc01() throws InterruptedException {
			 po.EnterUId("qwerty");
			 po.Enterpass("123456");
			 Thread.sleep(2000);
		 }
		 
		 @Test
		 public void tc02() {
			 
			 po.ClickOnbutton();
		 }
		 
		 @AfterMethod
		 public void Screenshot(ITestResult result) throws IOException, InterruptedException {
			 if(result.getStatus() == result.SUCCESS) {
				 Utilityclass.TakeScreenshot(driver);
				 driver.navigate().refresh();
				
			 }
			 
			 
		 }
		 
		 @AfterClass
		 public void CloseBrowser() {
			 driver.close();
			 
		 }
	}

