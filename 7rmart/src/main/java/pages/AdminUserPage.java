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
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'and @class='small-box-footer']")
	private WebElement moreInfo;
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
	
	public void clickTheAdminUsersInfo() {
		moreInfo.click();
	}

	public void clickTheAdminUsersNewButton() {
		newButton.click();
	}

	public void enterAdUsername(String usernamevalue ) {
		enterAdminUsername.sendKeys(usernamevalue);
	}
	public void enterAdPassword(String passwordvalue ) {
		enterAdminPassword.sendKeys(passwordvalue);
	}
	public void dropDown() {
	//Select select=new Select(dropDown);
		//select.selectByIndex(3);//select.selectByText("Partner");
		PageUtilities pageutilities=new PageUtilities();
		pageutilities.selectByVisibleText(dropDown, "Partner");
	}

	public void clickTheSaveButton() {
		saveButton.click();
	}
	
	public boolean isGreenAlertDisplayed() {
		return alertbox.isDisplayed();
}
	public boolean isSaveButtonDisplayed() {
	return saveButton.isDisplayed();
	}
}
