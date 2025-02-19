package test_script;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUserPage;
import pages.LoginPage;

public class AdminUserTest extends Base{
	@Test
	public void verifythatUsercanAddAdminUsersInformationsSuccessfully() {
		String usernamevalue = "admin";
		String passwordvalue = "admin";
		String adminusername="work";
		String adminpassword="time";
		
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue);
		loginpage.enterPassword(passwordvalue);
		loginpage.clickOnSigninButton();
		
		
		AdminUserPage adminuserpage=new AdminUserPage(driver);
		adminuserpage.clickTheAdminUsersInfo();
		adminuserpage.clickTheAdminUsersNewButton();
		adminuserpage.enterAdUsername(adminusername);
		adminuserpage.enterAdPassword(adminpassword );
		adminuserpage.dropDown();
		adminuserpage.clickTheSaveButton();
		boolean isAlertMessageDisplayed = adminuserpage.isGreenAlertDisplayed();
		Assert.assertTrue(isAlertMessageDisplayed);
	}
	@Test
	public void verifyWhetherSaveButtonIsDisplayed() {
		String usernamevalue = "admin";
		String passwordvalue = "admin";
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue);
		loginpage.enterPassword(passwordvalue);
		loginpage.clickOnSigninButton();
		
		
		AdminUserPage adminuserpage=new AdminUserPage(driver);
		adminuserpage.clickTheAdminUsersInfo();
		adminuserpage.clickTheAdminUsersNewButton();
		//adminuserpage.isSaveButtonDisplayed();
	
		boolean isSaveButtonDisplayed = adminuserpage.isSaveButtonDisplayed();
		Assert.assertTrue(isSaveButtonDisplayed);
}
	
	

}
