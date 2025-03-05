package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

   //@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']")
   //private WebElement newsmoreInfo;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;
	@FindBy(xpath = "//textarea[@id='news']")
	private WebElement enterNews;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertbox;

	// public void clickTheManageNewsMoreInfo() {
	// newsmoreInfo.click();
	// }

	public ManageNewsPage clickTheManageNewsNewButton() {
		newButton.click();
		return this;
	}

	public ManageNewsPage enterTheNews(String news) {
		enterNews.sendKeys(news);
		return this;
	}

	public ManageNewsPage clickTheSaveButton() {
		saveButton.click();
		return this;
	}

	public boolean isAlertDisplayed() {
		return alertbox.isDisplayed();
	}
}
