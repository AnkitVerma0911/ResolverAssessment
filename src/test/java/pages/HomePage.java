package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Driver;

public class HomePage {
	
	public HomePage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy (id = "inputEmail")
	public WebElement emailInputField;
	
	@FindBy (css = "#inputPassword")
	public WebElement passwordInputField;
	
	@FindBy (xpath = "//button[contains(text(),'Sign in')]")
	public WebElement signInButton;

	@FindBy (xpath = "//li[contains(@class,'list-group-item')][2]")
	public WebElement secondListItem;
	
	@FindBy (xpath = "//li[contains(@class,'list-group-item')][2]/span")
	public WebElement secondListItemSpan;
	
	@FindBy (xpath = "//button[@id='dropdownMenuButton']")
	public WebElement dropdownMenuButton;
	
	@FindBy (xpath = "//div[@class='dropdown-menu show']/a[text()='Option 3']")
	public WebElement dropdownMenuOption3;
	
	@FindBy (xpath = "//div[@id='test-4-div']/button[1]")
	public WebElement test4FirstButton;
	
	@FindBy (xpath = "//div[@id='test-4-div']/button[2]")
	public WebElement test4SecondButton;
	
	@FindBy (xpath = "//div[@id='test-5-div']/button")
	public WebElement test5Button;
	
	@FindBy (xpath = "//div[@id='test5-alert']")
	public WebElement test5SuccessMessage;

}
