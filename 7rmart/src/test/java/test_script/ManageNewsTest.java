package test_script;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base{
	@Test(retryAnalyzer = retry.Retry.class,groups={"regression"},description=" Verify that user can creat news successfully")//grouping.xml
	public void verifyThatUserCanCreateNewsSuccessfully() throws IOException {
	//	String usernamevalue = "admin";
	//	String passwordvalue = "admin";
	//String news = "Automation Testing";
		
		String usernamevalue = ExcelUtility.getStringData(1, 0, "Login_Page");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "Login_Page");
		String news = ExcelUtility.getStringData(1, 0, "Manage_News");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue);
		loginpage.enterPassword(passwordvalue);
		loginpage.clickOnSigninButton();

		ManageNewsPage managenewspage = new ManageNewsPage(driver);
		managenewspage.clickTheManageNewsInfo();
		managenewspage.clickTheManageNewsNewButton();
		managenewspage.enterTheNews(news);
		managenewspage.clickTheSaveButton();
		boolean isAlertMessageDisplayed = managenewspage.isAlertDisplayed();
		Assert.assertTrue(isAlertMessageDisplayed,Constants.SUCCESSMESSAGE);

	}
}
