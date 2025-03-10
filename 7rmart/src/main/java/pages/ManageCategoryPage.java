package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageCategoryPage {
	WebDriver driver;

	public ManageCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

   //@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category'and@class='small-box-footer']")
   //private WebElement categorymoreInfo;
	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-danger btncss']")
	private WebElement deleteButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertMessage;

	// public void clickTheManageCategoryMoreInfo() {
	// categorymoreInfo.click();

	// }

	public ManageCategoryPage confirmationAlert() {
		deleteButton.click();
		driver.switchTo().alert().accept();
		return this;
	}

	public boolean isGreenAlertDisplayed() {
		return alertMessage.isDisplayed();
	}

}