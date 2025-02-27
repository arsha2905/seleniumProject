package test_script;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageFooterPage;
import utilities.ExcelUtility;

public class ManageFooterTest extends Base {
	@Test(description="Verify that user can create manage footer text successfully")
	public void verifyThatUserCanCreateManageFooterTextSuccessfully() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "Login_Page");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "Login_Page");
		String address = ExcelUtility.getStringData(1, 0, "Manage_Footer");
		String email = ExcelUtility.getStringData(1, 1, "Manage_Footer");
	    String phonenum = ExcelUtility.getIntegerData(1, 2, "Manage_Footer");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue);
		loginpage.enterPassword(passwordvalue);
		loginpage.clickOnSigninButton();

		ManageFooterPage manage = new ManageFooterPage(driver);
		manage.clickTheManageFooterInfo();
		manage.clickTheManageFooterActionButton();
		manage.enterAddress(address);
		manage.enterEmail(email);
		manage.enterPhonenum(phonenum);
		manage.clickUpdateButton();
		boolean isAlertMessageDisplayed = manage.isGreenAlertDisplayed();
		Assert.assertTrue(isAlertMessageDisplayed);
	}
	
	@Test(retryAnalyzer=retry.Retry.class,description="Verify whether update button is displayed")
	public void verifyWhetherUpdateButtonIsDisplayed() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "Login_Page");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "Login_Page");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue);
		loginpage.enterPassword(passwordvalue);
		loginpage.clickOnSigninButton();
		
		ManageFooterPage manage = new ManageFooterPage(driver);
		manage.clickTheManageFooterInfo();
		manage.clickTheManageFooterActionButton();
		boolean isUpdateButtonDisplayed = manage.isUpdateButtonDisplayed();
		Assert.assertTrue(isUpdateButtonDisplayed);
	}

}
