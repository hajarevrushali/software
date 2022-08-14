package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteLoginPinPom {
	@FindBy(xpath=("//input[@id='pin']"))private WebElement loginpin;
	@FindBy(xpath=("//button[@type='submit']"))private WebElement continueBtn;
	
	
	public KiteLoginPinPom(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	public void enterLoginPin(String pin) {
		loginpin.sendKeys(pin);
	}
	public void clickOnContinue() {
		continueBtn.click();
	}

}
