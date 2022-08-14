package testClasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClasses.BaseClass;
import baseClasses.Utility;
import pomClasses.KiteLoginPom;

public class KiteTestClass {
	WebDriver driver;
	KiteLoginPom login;
	BaseClass base;
	String tcId;
	@BeforeClass
	public void openBrowser() {
		Reporter.log("--open browser--",true);
		base=new BaseClass();
		driver=base.initializeBrowser();
		login=new KiteLoginPom(driver);
	}
	@BeforeMethod
	public void beforeMethod_refresh() {
		driver.navigate().refresh();
	}
	@Test
	public void LoginSce01_Enter_UserId() throws EncryptedDocumentException, IOException {
		tcId="101";
	login.enterUserId(Utility.getTestData(0, 0));
	login.clickOnLogin();
	String ActualPass = login.getPassErrMsg();
	String ExpectedPass="Password should be minimum 6 characters.";
	Assert.assertEquals(ActualPass, ExpectedPass);
	}
	@Test
	public void LoginSce2_Enter_Pass() throws EncryptedDocumentException, IOException {
		login.enterPassword(Utility.getTestData(0, 1));
		login.clickOnLogin();
		String ActualUid = login.getUserErrMsg();
		String ExpectedUid="User ID should be minimum 6 characters.";
		Assert.assertEquals(ActualUid, ExpectedUid);
	}
	@Test
	public void LoginSce03_Blanck_IDandPass() {
		login.clickOnLogin();
		String ActIDMsg = login.getUserErrMsg();
		String ExpIdMsg = "User ID should be minimum 6 characters.";
		Assert.assertEquals(ActIDMsg, ExpIdMsg);
		String ActPwdMsg = login.getPassErrMsg();
		String ExpPwdMsg="Password should be minimum 6 characters.";
		Assert.assertEquals(ActPwdMsg, ExpPwdMsg);
		
	}
	@AfterMethod
	public void FialScreenShot(ITestResult result) throws IOException {
		if(result.getStatus()==result.FAILURE) {
			Utility.takescreenshot(driver, tcId);
		}
	}
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}

}
