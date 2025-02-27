package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;

public class FileUploadUtility {

	public void fileUploadUsingSendKeys(WebElement  element,String path) {	
		element.sendKeys(path);
	
	}
	public void fileUploadUsingRobotClass(WebElement  element,String path) throws AWTException {	
		
		StringSelection s=new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
		Robot R=new Robot();
	R.delay(3000);

	R.keyPress(KeyEvent.VK_CONTROL);
	R.keyPress(KeyEvent.VK_V);
	R.keyRelease(KeyEvent.VK_CONTROL);
	R.keyRelease(KeyEvent.VK_V);
	R.keyPress(KeyEvent.VK_ENTER);
	R.keyRelease(KeyEvent.VK_ENTER);
		
}
}