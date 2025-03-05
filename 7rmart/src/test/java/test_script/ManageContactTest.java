package test_script;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import pages.LogoutPage;
import pages.ManageCategoryPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;

public class ManageContactTest extends Base {
	LogoutPage logoutpage;
	ManageContactPage managecontact1;

	@Test(description = "Verify that user can create manage contact values successfully")
	public void verifyThatUserCanCreateManageContactValuesSuccessfully() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "Login_Page");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "Login_Page");
		String phonenum = ExcelUtility.getIntegerData(1, 0, "Manage_Contact");
		String delivryTime = ExcelUtility.getIntegerData(1, 1, "Manage_Contact");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue).enterPassword(passwordvalue);
		// loginpage.enterPassword(passwordvalue);
		logoutpage = loginpage.clickOnSigninButton();

		// ManageContactPage managecontact=new ManageContactPage(driver);
		// managecontact.clickTheManageContactMoreInfo();
		managecontact1 = logoutpage.clickTheManageContactMoreInfo();
		managecontact1.clickTheManageContactrActionButton().enterPhonenum(phonenum).enterDeliveryTime(delivryTime)
				.clickTheUpdateButton();
		// managecontact.enterPhonenum(phonenum);
		// managecontact.enterDeliveryTime(delivryTime);
		// managecontact.clickTheUpdateButton();
		boolean isAlertMessageDisplayed = managecontact1.isGreenAlertDisplayed();
		Assert.assertTrue(isAlertMessageDisplayed, Constants.SUCCESSMESSAGE);
	}

	@Test(description = " Verify whether the update button is enabled")
	public void verifyWhetherUpdateButtonIsEnabled() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "Login_Page");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "Login_Page");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue).enterPassword(passwordvalue);
		// loginpage.enterPassword(passwordvalue);
		logoutpage = loginpage.clickOnSigninButton();

		// ManageContactPage managecontact=new ManageContactPage(driver);
		// managecontact.clickTheManageContactMoreInfo();
		managecontact1 = logoutpage.clickTheManageContactMoreInfo();
		managecontact1.clickTheManageContactrActionButton();
		boolean isButtonEnabled = managecontact1.isUpdateButtonEnabled();
		Assert.assertTrue(isButtonEnabled, Constants.BUTTONENABLE);
	}

}
