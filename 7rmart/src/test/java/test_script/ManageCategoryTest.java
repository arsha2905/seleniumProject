package test_script;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.AdminUserPage;
import pages.LoginPage;
import pages.LogoutPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;

public class ManageCategoryTest extends Base {
	LogoutPage logoutpage;
	ManageCategoryPage managecategory1;

	@Test(retryAnalyzer = retry.Retry.class, description = "Verify that user can delete category successfully")
	public void verifyThatUserCanDeleteCategorySuccessfully() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "Login_Page");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "Login_Page");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue).enterPassword(passwordvalue);
		// loginpage.enterPassword(passwordvalue);
		logoutpage = loginpage.clickOnSigninButton();

		// ManageCategoryPage managecategory=new ManageCategoryPage(driver);
		// managecategory.clickTheManageCategoryMoreInfo();
		managecategory1 = logoutpage.clickTheManageCategoryMoreInfo();
		managecategory1.confirmationAlert();
		boolean isAlertMessageDisplayed = managecategory1.isGreenAlertDisplayed();
		Assert.assertTrue(isAlertMessageDisplayed, Constants.SUCCESSMESSAGE);
	}

}
