package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteLoginPom {
	@FindBy(xpath=("//input[@id='userid']"))private WebElement userId;
	@FindBy(xpath=("//input[@id='password']"))private WebElement password;
	@FindBy(xpath=("//button[@type='submit']"))private WebElement loginBtn;
	@FindBy(xpath=("//span[contains(text(),'User ID')]"))private WebElement userErrMsg;
	@FindBy(xpath=("//span[contains(text(),'Password')]"))private WebElement passErrMsg;
	
	public KiteLoginPom(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserId(String id) {
		userId.sendKeys(id);
	}
	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}
	public void clickOnLogin() {
		loginBtn.click();
	}
	public String getUserErrMsg() {
		String IdErrMsg = userErrMsg.getText();
		return IdErrMsg;
	}
	public String getPassErrMsg() {
		String pwdErrMsg = passErrMsg.getText();
		return pwdErrMsg;
	}
}
