package testClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClasses.BaseClass;
import baseClasses.Utility;
import pomClasses.KiteHomePom;
import pomClasses.KiteLoginPinPom;
import pomClasses.KiteLoginPom;

public class KitePositiveLoginTest {
	WebDriver driver;
	KiteLoginPom login1;
	KiteLoginPinPom pin1;
	KiteHomePom home;
	BaseClass base;
	String tcId;
	@BeforeClass
	public void launchBrowser() {
		base=new BaseClass();
		driver=base.initializeBrowser();
		login1=new KiteLoginPom(driver);
		pin1=new KiteLoginPinPom(driver);
		home=new KiteHomePom(driver);
	}
	@BeforeMethod
	public void loginToApplication() throws InterruptedException {
		login1.enterUserId("DAA677");
		login1.enterPassword("Velocity@123");
		login1.clickOnLogin();
		Thread.sleep(3000);
		pin1.enterLoginPin("866918");
		pin1.clickOnContinue();
	}
	@Test
	public void verifyUserId() throws InterruptedException {
		tcId="201";
		String ActIdName = home.getIDName();
		String ExpIdName="DAA677";
		Thread.sleep(5000);
		Assert.assertEquals(ActIdName, ExpIdName);
	}
	@AfterMethod
	public void LogoutFromApplication(ITestResult result) throws IOException{
		if(result.getStatus()==result.FAILURE) {
			Utility.takescreenshot(driver, tcId);
		}
		home.clickOnId();
		home.clickOnLogout();
	}
	@AfterClass
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
}
