package baseClasses;



import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;



public class Utilityclass {
	
	public static void TakeScreenshot(WebDriver driver) throws IOException {
		Date d = new Date();
		String str = d.toString();
		str.replace(" ", "_");
		str.replace(":", "_");
		
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File f = new File("C:\\Users\\taino\\Desktop\\vrushali\\New folder\\image_" + str + ".png");
		FileHandler.copy(source, f);
		
	}

}
