package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFooterPage {
	WebDriver driver;

	public ManageFooterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// @FindBy(xpath =
	// "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext'and@class='small-box-footer']")
	// private WebElement footermoreInfo;
	@FindBy(xpath = "//i[@class='fas fa-edit']")
	private WebElement action;
	@FindBy(xpath = "//textarea[@id='content']")
	private WebElement enterAddress;
	@FindBy(xpath = "//input[@id='email']")
	private WebElement enterEmail;
	@FindBy(xpath = "//input[@id='phone']")
	private WebElement enterPhonenum;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement update;
	@FindBy(xpath = "//i[@class='icon fas fa-check']")
	private WebElement alertbox;

	// public ManageFooterPage clickTheManageFooterMoreInfo() {
	// footermoreInfo.click();
	// }

	public ManageFooterPage clickTheManageFooterActionButton() {
		action.click();
		return this;
	}

	public ManageFooterPage enterAddress(String address) {
		enterAddress.clear();
		enterAddress.sendKeys(address);
		return this;
	}

	public ManageFooterPage enterEmail(String email) {
		enterEmail.clear();
		enterEmail.sendKeys(email);
		return this;
	}

	public ManageFooterPage enterPhonenum(String phonenum) {
		enterPhonenum.clear();
		enterPhonenum.sendKeys(phonenum);
		return this;
	}

	public ManageFooterPage clickUpdateButton() {
		update.click();
		return this;

	}

	public boolean isGreenAlertDisplayed() {
		return alertbox.isDisplayed();
	}

	public boolean isUpdateButtonDisplayed() {
		return update.isDisplayed();
	}

}
