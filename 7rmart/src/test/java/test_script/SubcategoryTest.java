package test_script;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.SubcategoryPage;
import utilities.ExcelUtility;

public class SubcategoryTest extends Base{
@Test
	public void verifyThatUserCanCreatCategoriesAndUploadImageSuccessfully() throws IOException {
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
		//category.clickSaveButton();
		boolean isAlertMessageDisplayed = category.isGreenAlertDisplayed();
		Assert.assertTrue(isAlertMessageDisplayed);
		
	}
}
