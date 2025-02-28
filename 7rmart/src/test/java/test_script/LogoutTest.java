package test_script;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.LogoutPage;
import utilities.ExcelUtility;

public class LogoutTest extends Base{
	@Test(description="Verify that user can able to logout successfully")
public void verifyThatUserCanAbleToLogoutSuccessfully() throws IOException {
	 String usernamevalue=ExcelUtility.getStringData(1, 0, "Login_Page");
     String passwordvalue=ExcelUtility.getStringData(1, 1,"Login_Page");
     
     LoginPage loginpage = new LoginPage(driver);
     loginpage.enterUsername(usernamevalue);
	 loginpage.enterPassword(passwordvalue);
	 loginpage.clickOnSigninButton();
	 
	 LogoutPage logout = new LogoutPage (driver);
	 
	 logout.clickTheAdminButton();
	 logout.clickTheLogoutButton();
	 boolean isloginDisplayed = logout.isLoginDisplayed();
		Assert.assertTrue(isloginDisplayed,"LOGINDISPLAY");
	}
	 
		 
		
}

