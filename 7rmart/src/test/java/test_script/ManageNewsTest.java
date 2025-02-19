package test_script;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageNewsPage;

public class ManageNewsTest extends Base{
	@Test
	public void verifyThatUserCanCreateNewsSuccessfully() {
		String usernamevalue = "admin";
		String passwordvalue = "admin";
		String news = "Automation Testing";

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
		Assert.assertTrue(isAlertMessageDisplayed);

	}
}
