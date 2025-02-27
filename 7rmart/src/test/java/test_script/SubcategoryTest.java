package test_script;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.SubcategoryPage;
import utilities.ExcelUtility;

public class SubcategoryTest extends Base{
@Test(description="Verify that user can create categories and upload image successfully")
	public void verifyThatUserCanCreatCategoriesAndUploadImageSuccessfully() throws IOException, AWTException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "Login_Page");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "Login_Page");
		String scategory = ExcelUtility.getStringData(1, 0, "Subcategory_Page");
		
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue);
		loginpage.enterPassword(passwordvalue);
		loginpage.clickOnSigninButton();
		
		
		SubcategoryPage category = new SubcategoryPage(driver);
		category.clickTheSubcategoryInfo();
		category.clickTheSubcategoryNewButton();
		category.enterCategory();
		category.enterSubcategory(scategory);
		category.uploadImage();
		category.clickTheSaveButton();
		boolean isAlertMessageDisplayed = category.isGreenAlertDisplayed();
		Assert.assertTrue(isAlertMessageDisplayed);
		
	}
}
