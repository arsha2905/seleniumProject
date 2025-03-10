package test_script;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constants.Constants;
import pages.AdminUserPage;
import pages.LoginPage;
import pages.LogoutPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUserTest extends Base {
	LogoutPage logoutpage;
	AdminUserPage adminuserpage1;

	@Test(description = "Verify that user can add adminusers informations successfully")
	public void verifythatUsercanAddAdminUsersInformationsSuccessfully() throws IOException {
		// String usernamevalue = "admin";
		// String passwordvalue = "admin";
		// String adminusername="Morning";
		// String adminpassword="Evening";

		String usernamevalue = ExcelUtility.getStringData(1, 0, "Login_Page");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "Login_Page");
		// String adminusername = ExcelUtility.getStringData(1, 0, "Admin_User");
		FakerUtility fakerutility = new FakerUtility();
		String adminusername = fakerutility.creatARandomFirstName();
		String adminpassword = ExcelUtility.getStringData(1, 1, "Admin_User");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue).enterPassword(passwordvalue);
		// loginpage.enterPassword(passwordvalue);
		logoutpage = loginpage.clickOnSigninButton();

		// AdminUserPage adminuserpage=new AdminUserPage(driver);
		// adminuserpage.clickTheAdminUsersMoreInfo();

		adminuserpage1 = logoutpage.clickTheAdminUsersMoreInfo();
		adminuserpage1.clickTheAdminUsersNewButton().enterAdUsername(usernamevalue).enterAdPassword(passwordvalue)
				.dropDown().clickTheSaveButton();
		// adminuserpage.enterAdUsername(adminusername);
		// adminuserpage.enterAdPassword(adminpassword );
		// adminuserpage.dropDown();
		// adminuserpage.clickTheSaveButton();
		boolean isAlertMessageDisplayed = adminuserpage1.isGreenAlertDisplayed();
		Assert.assertTrue(isAlertMessageDisplayed, Constants.SUCCESSMESSAGE);
	}

	@Test(dataProvider = "LoginProvider", description = "Verify whether the savebutton is displayed")
	public void verifyWhetherSaveButtonIsDisplayed(String usernamevalue, String passwordvalue) throws IOException {
		// String usernamevalue = "admin";
		// String passwordvalue = "admin";
		// String usernamevalue = ExcelUtility.getStringData(1, 0, "Login_Page");
		// String passwordvalue = ExcelUtility.getStringData(1, 1, "Login_Page");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue).enterPassword(passwordvalue);
		// loginpage.enterPassword(passwordvalue);
		logoutpage = loginpage.clickOnSigninButton();

		// AdminUserPage adminuserpage=new AdminUserPage(driver);
		// adminuserpage.clickTheAdminUsersMoreInfo();
		adminuserpage1 = logoutpage.clickTheAdminUsersMoreInfo();
		adminuserpage1.clickTheAdminUsersNewButton();
		// adminuserpage.isSaveButtonDisplayed();

		boolean isSaveButtonDisplayed = adminuserpage1.isSaveButtonDisplayed();
		Assert.assertTrue(isSaveButtonDisplayed, Constants.SAVEBUTTON);
	}

	@DataProvider(name = "LoginProvider")
	public Object[][] getDataFromTestData() throws IOException {
		return new Object[][] {
				{ ExcelUtility.getStringData(1, 0, "loginpage"), ExcelUtility.getStringData(1, 1, "loginpage") } };
	}

}
