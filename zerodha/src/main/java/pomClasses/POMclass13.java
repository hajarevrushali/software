package pomClasses;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POMclass13 {

	
	@FindBy(xpath="//input[@id='userid']")private  WebElement UserId;
	@FindBy(xpath="//input[@id='password']")private WebElement password;
	@FindBy(xpath="//button[@type='submit']")private WebElement loginbtn;
	
	
	POMclass13(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void EnterUId(String user) {
		UserId.sendKeys(user);
	}
	
	public void Enterpass(String pass) {
		password.sendKeys(pass);
	}
	
	public void ClickOnbutton() {
		loginbtn.click();
	}
	
}
