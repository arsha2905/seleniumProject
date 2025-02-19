package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtilities;

public class SubcategoryPage {
	WebDriver driver;

	public SubcategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category'and@class='small-box-footer']")
	private WebElement moreInfo;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	private WebElement newButton;
	@FindBy(xpath = "//select[@class='form-control selectpicker']")
	private WebElement dropDown;
	@FindBy(xpath = "//input[@id='subcategory']")
	private WebElement subCategory;
	@FindBy(xpath = "//input[@id='main_img']")
	private WebElement chooseFile;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	private WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertMessage;

	// "C:\Users\arsha\OneDrive\Desktop\DummyBook.jpg"
	public void clickTheSubcategoryInfo() {
		moreInfo.click();
	}

	public void clickTheSubcategoryNewButton() {
		newButton.click();
	}

	public void enterCategory() {
		PageUtilities pageutilities = new PageUtilities();
		pageutilities.selectByIndex(dropDown, 3);
	}

	public void enterSubcategory(String scategory) {
		subCategory.sendKeys(scategory);
	}

	public void uploadImage() {
		chooseFile.sendKeys("C:\\Users\\arsha\\OneDrive\\Desktop\\DummyBook.jpg");
	}
	// public void javaScriptExecutorTest() {
	// JavascriptExecutor js = (JavascriptExecutor) driver;
	// js.executeScript("arguments[0].click();", saveButton);
	// }

	public void clickTheSaveButton() {
		PageUtilities pageutilities = new PageUtilities();
		pageutilities.javaScriptExecutorTest(driver, saveButton);
	}

	public void clickSaveButton() {
		saveButton.click();

	}

	public boolean isGreenAlertDisplayed() {
		return alertMessage.isDisplayed();
	}

}
