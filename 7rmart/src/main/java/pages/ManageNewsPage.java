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

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']")
	private WebElement moreInfo;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;
	@FindBy(xpath = "//textarea[@id='news']")
	private WebElement enterNews;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertbox;

	public void clickTheManageNewsInfo() {
		moreInfo.click();
	}

	public void clickTheManageNewsNewButton() {
		newButton.click();
	}

	public void enterTheNews(String news) {
		enterNews.sendKeys(news);
	}

	public void clickTheSaveButton() {
		saveButton.click();
	}

	public boolean isAlertDisplayed() {
		return alertbox.isDisplayed();
	}
}
