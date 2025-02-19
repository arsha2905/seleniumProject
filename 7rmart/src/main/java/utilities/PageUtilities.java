package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PageUtilities {
	public void selectByIndex(WebElement element,int index) {
		Select select =new Select(element);
		select.selectByIndex(index);
	}
		
		public void selectByVisibleText(WebElement element,String visibleText) {
			Select select =new Select(element);
			select.selectByVisibleText(visibleText);
			
		}
		public void selectByValue(WebElement element,String visibleText) {
			Select select =new Select(element);
			select.selectByValue(visibleText);
			
		}
		public void scrollBy(WebDriver driver) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
		}
		
		public void javaScriptExecutorTest(WebDriver driver,WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
		}
		
		
		

}
