package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;

import utilities.PageUtilities;

public class ManageContactPage {
	WebDriver driver;

	public ManageContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// @FindBy(xpath =
	// "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact'and@class='small-box-footer']")
	// private WebElement mcontactmoreInfo;
	@FindBy(xpath = "//i[@class='fas fa-edit']")
	private WebElement action;
	@FindBy(xpath = "//input[@id='phone']")
	private WebElement phnumber;
	@FindBy(xpath = "//textarea[@name='del_time']")
	private WebElement deliveryTime;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement updateButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertMessage;

	// public ManageContactPage clickTheManageContactMoreInfo() {
	// mcontactmoreInfo.click();
	// return this;
	// }

	public ManageContactPage clickTheManageContactrActionButton() {
		action.click();
		return this;
	}

	public ManageContactPage enterPhonenum(String phonenum) {
		phnumber.clear();
		phnumber.sendKeys(phonenum);
		return this;
	}

	public ManageContactPage enterDeliveryTime(String time) {
		deliveryTime.clear();
		deliveryTime.sendKeys(time);
		return this;
	}

    //public void javaScriptExecutorTest() {
	// JavascriptExecutor js = (JavascriptExecutor) driver;
	// js.executeScript("arguments[0].click();", updateButton);
	// }
	public ManageContactPage clickTheUpdateButton() {
		PageUtilities pageutilities = new PageUtilities();
		pageutilities.javaScriptExecutorTest(driver, updateButton);
		return this;
	}

	public boolean isGreenAlertDisplayed() {
		return alertMessage.isDisplayed();
	}

	public boolean isUpdateButtonEnabled() {
		return updateButton.isEnabled();
	}

}
