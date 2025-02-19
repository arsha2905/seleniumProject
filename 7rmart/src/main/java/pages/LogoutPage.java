package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtilities;

public class LogoutPage {
	WebDriver driver;

	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[text()='Dashboard']")
	private WebElement dashboard;
	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	private WebElement admin;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout'and @class='dropdown-item']")
	private WebElement logoutButton;


	public boolean isDashBoardLoaded() {
		return dashboard.isDisplayed();

	}

	public void clickTheAdminButton() {
		admin.click();
	}

	public void clickTheLogoutButton() {
		logoutButton.click();

	}
}