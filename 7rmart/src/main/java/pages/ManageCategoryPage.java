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
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category'and@class='small-box-footer']")
	private WebElement moreInfo;
	@FindBy(xpath = "//i[@class='fas fa-trash-alt']")
	private WebElement deleteButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertMessage;
	
	public void clickTheManageCategoryInfo() {
		moreInfo.click();
	}

	public void clickTheDeleteButton() {
		deleteButton.click();
	}
	public void confirmationAlert() {
		deleteButton.click();
		driver.switchTo().alert().accept();
	}

	public boolean isGreenAlertDisplayed() {
		return alertMessage.isDisplayed();
	}
	
}