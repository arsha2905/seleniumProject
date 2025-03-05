package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtilities;

public class AdminUserPage {
	WebDriver driver;

	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// @FindBy(xpath =
	// "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'and
	// @class='small-box-footer']")
	// private WebElement adminmoreInfo;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement enterAdminUsername;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement enterAdminPassword;
	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement dropDown;
	@FindBy(xpath = "//button[@name='Create']")
	private WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertbox;

	// public AdminUserPage clickTheAdminUsersMoreInfo() {
	// adminmoreInfo.click();
	// return this;
	// }

	public AdminUserPage clickTheAdminUsersNewButton() {
		newButton.click();
		return this;
	}

	public AdminUserPage enterAdUsername(String usernamevalue) {
		enterAdminUsername.sendKeys(usernamevalue);
		return this;
	}

	public AdminUserPage enterAdPassword(String passwordvalue) {
		enterAdminPassword.sendKeys(passwordvalue);
		return this;
	}

	public AdminUserPage dropDown() {
		// Select select=new Select(dropDown);
		// select.selectByIndex(3);//select.selectByText("Partner");
		PageUtilities pageutilities = new PageUtilities();
		pageutilities.selectByVisibleText(dropDown, "Partner");
		return this;
	}

	public AdminUserPage clickTheSaveButton() {
		saveButton.click();
		return this;
	}

	public boolean isGreenAlertDisplayed() {
		return alertbox.isDisplayed();
	}

	public boolean isSaveButtonDisplayed() {
		return saveButton.isDisplayed();
	}
}
