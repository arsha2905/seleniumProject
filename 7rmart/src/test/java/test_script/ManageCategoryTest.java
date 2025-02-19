package test_script;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;

public class ManageCategoryTest extends Base{
	@Test
	public void verifyThatUserCanDeleteCategorySuccessfully() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "Login_Page");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "Login_Page");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue);
		loginpage.enterPassword(passwordvalue);
		loginpage.clickOnSigninButton();
		
		ManageCategoryPage managecategory=new ManageCategoryPage(driver);
		managecategory.clickTheManageCategoryInfo();
		//managecategory.clickTheDeleteButton();
		managecategory.confirmationAlert();
		
		managecategory.isGreenAlertDisplayed();

}
}
