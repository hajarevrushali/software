package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteHomePom {
	@FindBy(xpath=("//span[@class='user-id']"))private WebElement idname;
	@FindBy(xpath=("//a[@target='_self']"))private WebElement logout;
	
	public KiteHomePom(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	public String getIDName() {
		String idnm = idname.getText();
		return idnm;
	}
	public void clickOnId() {
		idname.click();
	}
	public void clickOnLogout() {
		logout.click();
	}

}
