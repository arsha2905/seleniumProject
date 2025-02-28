package test_script;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;

public class ManageContactTest extends Base {
	
	@Test(description="Verify that user can create manage contact values successfully")    
public void verifyThatUserCanCreateManageContactValuesSuccessfully() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "Login_Page");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "Login_Page");
		String phonenum=ExcelUtility.getIntegerData(1,0, "Manage_Contact");
		String delivryTime=ExcelUtility.getIntegerData(1,1, "Manage_Contact");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue);
		loginpage.enterPassword(passwordvalue);
		loginpage.clickOnSigninButton();

		ManageContactPage managecontact=new ManageContactPage(driver);
		managecontact.clickTheManageContactInfo();
		managecontact.clickTheManageContactrActionButton();
		managecontact.enterPhonenum(phonenum);
		managecontact.enterDeliveryTime(delivryTime);
		managecontact.clickTheUpdateButton();
		boolean isAlertMessageDisplayed = managecontact.isGreenAlertDisplayed();
		Assert.assertTrue(isAlertMessageDisplayed,"Success alert is not displaying");
}
	@Test(description=" Verify whether the update button is enabled")
	public void verifyWhetherUpdateButtonIsEnabled() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "Login_Page");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "Login_Page");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue);
		loginpage.enterPassword(passwordvalue);
		loginpage.clickOnSigninButton();
		
		ManageContactPage managecontact=new ManageContactPage(driver);
		managecontact.clickTheManageContactInfo();
		managecontact.clickTheManageContactrActionButton();
boolean isButtonEnabled = managecontact.isUpdateButtonEnabled();
Assert.assertTrue(isButtonEnabled,"Update button not enabled");
	}
	
}
