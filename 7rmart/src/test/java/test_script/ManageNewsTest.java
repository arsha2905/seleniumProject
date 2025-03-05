package test_script;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import pages.LogoutPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {
	LogoutPage logoutpage;
	ManageNewsPage managenewspage1;

	@Test(retryAnalyzer = retry.Retry.class, groups = {
			"regression" }, description = " Verify that user can creat news successfully") // grouping.xml
	public void verifyThatUserCanCreateNewsSuccessfully() throws IOException {
		// String usernamevalue = "admin";
		// String passwordvalue = "admin";
		// String news = "Automation Testing";

		String usernamevalue = ExcelUtility.getStringData(1, 0, "Login_Page");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "Login_Page");
		String news = ExcelUtility.getStringData(1, 0, "Manage_News");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue).enterPassword(passwordvalue);
		logoutpage = loginpage.clickOnSigninButton();
		// loginpage.enterPassword(passwordvalue);

		// ManageNewsPage managenewspage = new ManageNewsPage(driver);
		// managenewspage.clickTheManageNewsMoreInfo();
		// logoutpage.clickTheManageNewsMoreInfo();

		managenewspage1 = logoutpage.clickTheManageNewsMoreInfo();
		managenewspage1.clickTheManageNewsNewButton().enterTheNews(news).clickTheSaveButton();
		// managenewspage.enterTheNews(news);
		// managenewspage.clickTheSaveButton();
		boolean isAlertMessageDisplayed = managenewspage1.isAlertDisplayed();
		Assert.assertTrue(isAlertMessageDisplayed, Constants.SUCCESSMESSAGE);

	}
}
