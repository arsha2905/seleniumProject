package test_script;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import pages.LogoutPage;
import pages.ManageFooterPage;
import pages.SubcategoryPage;
import utilities.ExcelUtility;

public class SubcategoryTest extends Base {
	LogoutPage logoutpage;
	SubcategoryPage category1;

	@Test(description = "Verify that user can create categories and upload image successfully")
	public void verifyThatUserCanCreatCategoriesAndUploadImageSuccessfully() throws IOException, AWTException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "Login_Page");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "Login_Page");
		String scategory = ExcelUtility.getStringData(1, 0, "Subcategory_Page");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue).enterPassword(passwordvalue);
		// loginpage.enterPassword(passwordvalue);
		logoutpage = loginpage.clickOnSigninButton();

		// SubcategoryPage category = new SubcategoryPage(driver);
		// category.clickTheSubcategoryMoreInfo();
		category1 = logoutpage.clickTheSubcategoryMoreInfo();
		category1.clickTheSubcategoryNewButton().enterCategory().enterSubcategory(scategory).uploadImage()
				.clickTheSaveButton();
		// category.enterCategory();
		// category.enterSubcategory(scategory);
		// category.uploadImage();
		// category.clickTheSaveButton();
		boolean isAlertMessageDisplayed = category1.isGreenAlertDisplayed();
		Assert.assertTrue(isAlertMessageDisplayed, Constants.SUCCESSMESSAGE);

	}
}
