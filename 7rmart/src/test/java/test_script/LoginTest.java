package test_script;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import utilities.ExcelUtility;

@Test
public class LoginTest extends Base {
	@Test(retryAnalyzer = retry.Retry.class, description = "Verify the user is able to login using valid credentials")
	public void verifyTheUserIsAbleToLoginUsingValidCredentials() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "Login_Page");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "Login_Page");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue);
		loginpage.enterPassword(passwordvalue);
		loginpage.clickOnSigninButton();
		boolean ishomepageavailavle = loginpage.isDashBoardLoaded();
		Assert.assertTrue(ishomepageavailavle, Constants.VALIDCREDENTIALS);
	}

	@Test(description = "Verify the user is able to login using valid username and invalid password")
	public void verifyTheUserIsAbleToLoginUsingValidUsernameInvalidPassword() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(2, 0, "Login_Page");
		String passwordvalue = ExcelUtility.getStringData(2, 1, "Login_Page");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue);
		loginpage.enterPassword(passwordvalue);
		loginpage.clickOnSigninButton();
		boolean isAlertMessageDisplayed = loginpage.isAlertDisplayed();
		Assert.assertTrue(isAlertMessageDisplayed, Constants.INVALIDCREDENTIALS);
	}

	@Test(description = "Verify the user is able to login using invalid username and valid password")
	public void verifyTheUserIsAbleToLoginUsingInvalidUsernameValidPassword() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(3, 0, "Login_Page");
		String passwordvalue = ExcelUtility.getStringData(3, 1, "Login_Page");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue);
		loginpage.enterPassword(passwordvalue);
		loginpage.clickOnSigninButton();
		boolean isAlertMessageDisplayed = loginpage.isAlertDisplayed();
		Assert.assertTrue(isAlertMessageDisplayed, Constants.INVALIDCREDENTIALS);

	}

	@Test(description = "Verify the user is able to login using invalid username and invalid password")
	public void verifyTheUserIsAbleToLoginUsingInvalidUsernameInvalidPassword() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(4, 0, "Login_Page");
		String passwordvalue = ExcelUtility.getStringData(4, 1, "Login_Page");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue);
		loginpage.enterPassword(passwordvalue);
		loginpage.clickOnSigninButton();
		boolean isAlertMessageDisplayed = loginpage.isAlertDisplayed();
		Assert.assertTrue(isAlertMessageDisplayed, Constants.INVALIDCREDENTIALS);

	}
}
