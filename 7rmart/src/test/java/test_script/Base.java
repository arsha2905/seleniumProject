package test_script;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Constants;
import utilities.ScreenshotUtility;
import utilities.WaitUtility;



public class Base {
WebDriver driver;
public Properties properties;
ScreenshotUtility scrshot;
FileInputStream fileinputstream;
	
@BeforeMethod(alwaysRun = true)

@Parameters("browser")
public void initialBrowse(String browser) throws Exception  {
	try {
		properties=new Properties();
		fileinputstream=new  FileInputStream(Constants.CONFIGFILE);
		properties.load(fileinputstream);
	}
	catch(Exception e){
		System.out.println("Invalid Program");
	
	}
	if (browser.equalsIgnoreCase("chrome")) {
		driver = new ChromeDriver();
	} else if (browser.equalsIgnoreCase("edge")) {
		driver = new EdgeDriver();
    }
	else {
		throw new Exception("Browser is not correct");
	}
	
	//driver.get("https://groceryapp.uniqassosiates.com/admin");
	driver.get(properties.getProperty("url"));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICITWAIT));// implicit wait
	driver.manage().window().maximize();// window maximization
}
@AfterMethod(alwaysRun = true)
public void browserQuit(ITestResult iTestResult) throws IOException {
	if (iTestResult.getStatus() == ITestResult.FAILURE) {
		scrshot = new ScreenshotUtility();
	scrshot.getScreenshot(driver, iTestResult.getName());
}
	}
//@AfterMethod
//public void driverQuitandClose(){
//	 driver.quit();
//}
}

