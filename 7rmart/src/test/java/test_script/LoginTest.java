package test_script;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExcelUtility;

@Test
public class LoginTest extends Base {
	public void verifyTheUserIsAbleToLoginUsingValidCredentials() throws IOException {
	 String usernamevalue=ExcelUtility.getStringData(1, 0, "Login_Page");
      String passwordvalue=ExcelUtility.getStringData(1, 1,"Login_Page");
        
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue);
		loginpage.enterPassword(passwordvalue);
		loginpage.clickOnSigninButton();
		boolean ishomepageavailavle = loginpage.isDashBoardLoaded();
		Assert.assertTrue(ishomepageavailavle);
	}
	@Test
	public void verifyTheUserIsAbleToLoginUsingValidUsernameInvalidPassword() throws IOException {
		 String usernamevalue=ExcelUtility.getStringData(2, 0, "Login_Page");
	      String passwordvalue=ExcelUtility.getStringData(2, 1,"Login_Page");
	        
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue);
		loginpage.enterPassword(passwordvalue);
		loginpage.clickOnSigninButton();
		boolean isAlertMessageDisplayed = loginpage.isAlertDisplayed();
		Assert.assertTrue(isAlertMessageDisplayed);
}
	@Test
	public void verifyTheUserIsAbleToLoginUsingInvalidUsernameValidPassword() throws IOException {
		 String usernamevalue=ExcelUtility.getStringData(3, 0, "Login_Page");
	      String passwordvalue=ExcelUtility.getStringData(3, 1,"Login_Page");
	        
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue);
		loginpage.enterPassword(passwordvalue);
		loginpage.clickOnSigninButton();
		boolean isAlertMessageDisplayed = loginpage.isAlertDisplayed1();
		Assert.assertTrue(isAlertMessageDisplayed);

	}

	@Test
	public void verifyTheUserIsAbleToLoginUsingInvalidUsernameInvalidPassword() throws IOException {
		 String usernamevalue=ExcelUtility.getStringData(4, 0, "Login_Page");
	      String passwordvalue=ExcelUtility.getStringData(4, 1,"Login_Page");
	        
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue);
		loginpage.enterPassword(passwordvalue);
		loginpage.clickOnSigninButton();
		boolean isAlertMessageDisplayed = loginpage.isAlertDisplayed2();
		Assert.assertTrue(isAlertMessageDisplayed);

	}
}

