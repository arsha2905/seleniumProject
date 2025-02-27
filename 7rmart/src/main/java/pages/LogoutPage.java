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

	
	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	private WebElement admin;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout'and @class='dropdown-item']")
	private WebElement logoutButton;
	@FindBy(xpath = "//p[@class='login-box-msg']")
	private WebElement loginpage;

	

	public void clickTheAdminButton() {
		admin.click();
	}

	public void clickTheLogoutButton() {
		 WaitUtility waitutility=new  WaitUtility();
		 waitutility.waitForClick(driver, logoutButton);
		logoutButton.click();

	}
	public boolean isLoginDisplayed() {
		return loginpage.isDisplayed();
		}
}