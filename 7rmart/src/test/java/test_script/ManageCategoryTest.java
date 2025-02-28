package test_script;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;

public class ManageCategoryTest extends Base{
	@Test(retryAnalyzer = retry.Retry.class,description="Verify that user can delete category successfully")
	public void verifyThatUserCanDeleteCategorySuccessfully() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "Login_Page");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "Login_Page");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue);
		loginpage.enterPassword(passwordvalue);
		loginpage.clickOnSigninButton();
		
		ManageCategoryPage managecategory=new ManageCategoryPage(driver);
		managecategory.clickTheManageCategoryInfo();
		managecategory.confirmationAlert();
		boolean isAlertMessageDisplayed = managecategory.isGreenAlertDisplayed();
		Assert.assertTrue(isAlertMessageDisplayed,Constants.SUCCESSMESSAGE);
	}

}
