package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtilities;
import utilities.WaitUtility;

public class LogoutPage {
	WebDriver driver;

	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'and @class='small-box-footer']")
	private WebElement adminmoreInfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category'and@class='small-box-footer']")
	private WebElement categorymoreInfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact'and@class='small-box-footer']")
	private WebElement mcontactmoreInfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext'and@class='small-box-footer']")
	private WebElement footermoreInfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']")
	private WebElement newsmoreInfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category'and@class='small-box-footer']")
	private WebElement subcategorymoreInfo;
	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	private WebElement admin;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout'and @class='dropdown-item']")
	private WebElement logoutButton;
	@FindBy(xpath = "//p[@class='login-box-msg']")
	private WebElement loginpage;

	public AdminUserPage clickTheAdminUsersMoreInfo() {
		adminmoreInfo.click();
		return new AdminUserPage(driver);
	}

	public ManageCategoryPage clickTheManageCategoryMoreInfo() {
		categorymoreInfo.click();
		return new ManageCategoryPage(driver);

	}

	public ManageContactPage clickTheManageContactMoreInfo() {
		mcontactmoreInfo.click();
		return new ManageContactPage(driver);
	}

	public ManageFooterPage clickTheManageFooterMoreInfo() {
		footermoreInfo.click();
		return new ManageFooterPage(driver);
	}

	public ManageNewsPage clickTheManageNewsMoreInfo() {
		newsmoreInfo.click();
		return new ManageNewsPage(driver);

	}

	public SubcategoryPage clickTheSubcategoryMoreInfo() {
		subcategorymoreInfo.click();
		return new SubcategoryPage(driver);
	}

	public void clickTheAdminButton() {
		admin.click();
	}

	public void clickTheLogoutButton() {
		WaitUtility waitutility = new WaitUtility();
		waitutility.waitForClick(driver, logoutButton);
		logoutButton.click();

	}

	public boolean isLoginDisplayed() {
		return loginpage.isDisplayed();
	}
}