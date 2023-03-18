package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import net.bytebuddy.asm.Advice.OnMethodEnter;
import pages.HomePage;
import utils.Driver;
import utils.TestDataReader;

public class NewTest {
  
	@BeforeTest
	public void setup() {
		Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@AfterTest
	public void quitDriver() {
		Driver.quitDriver();
	}
	
	@Test
  public void test1() {
		
		//Navigate to the home page
		Driver.getDriver().get(TestDataReader.getProperty("localFileLocation"));		
		HomePage homePage = new HomePage();
		
		//Assert that both the email address and password inputs 
		//are present as well as the login button
		Assert.assertTrue(homePage.emailInputField.isDisplayed());
		Assert.assertTrue(homePage.passwordInputField.isDisplayed());
		Assert.assertTrue(homePage.signInButton.isDisplayed());
		
		//Enter in an email address and password combination into the respective fields
		homePage.emailInputField.sendKeys(TestDataReader.getProperty("test1SampleEmail"));
		homePage.emailInputField.sendKeys(TestDataReader.getProperty("test1SamplePassword"));
		
  }
	@Test
	public void test2() {
		// Navigate to the home page
		Driver.getDriver().get(TestDataReader.getProperty("localFileLocation"));
		HomePage homePage = new HomePage();
		
		//In the test 2 div, assert that there are three values in the listgroup
		int numberOfListElements = 
				Driver.getDriver().findElements(By.className("list-group-item")).size();
		Assert.assertEquals(numberOfListElements, 3);
		
		//Assert that the second list item's value is set to "List Item 2"
		int secondListItemLength = homePage.secondListItem.getText().length()-
				homePage.secondListItemSpan.getText().length();
				
		String secondListItemText = homePage.secondListItem.getText()
				.substring(0,secondListItemLength);
	
		Assert.assertEquals(secondListItemText.trim(), "List Item 2");
		
		//Assert that the second list item's badge value is 6
		Assert.assertEquals(homePage.secondListItemSpan.getText(), "6");
				
	}

	@Test
	public void test3() {
		// Navigate to the home page
		Driver.getDriver().get(TestDataReader.getProperty("localFileLocation"));
		HomePage homePage = new HomePage();
		
		//In the test 3 div, assert that "Option 1" is the default selected value
		Assert.assertEquals(homePage.dropdownMenuButton.getText().trim(), "Option 1");
		
		//Select "Option 3" from the select list
		homePage.dropdownMenuButton.click();
		homePage.dropdownMenuOption3.click();
		Assert.assertEquals(homePage.dropdownMenuButton.getText().trim(), "Option 3");
		
	}
	
	@Test
	public void test4() {
		// Navigate to the home page
		Driver.getDriver().get(TestDataReader.getProperty("localFileLocation"));
		HomePage homePage = new HomePage();

		// In the test 4 div,
		// assert that the first button is enabled and that the second button is disabled
		Assert.assertTrue(homePage.test4FirstButton.isEnabled());
		Assert.assertFalse(homePage.test4SecondButton.isEnabled());
	}
	
	@Test
	public void test5() {
		// Navigate to the home page
		Driver.getDriver().get(TestDataReader.getProperty("localFileLocation"));
		HomePage homePage = new HomePage();
		
		//In the test 5 div, wait for a button to be displayed 
		//(note: the delay is random) and then click it
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 100);
		wait.until(ExpectedConditions.elementToBeClickable(homePage.test5Button));
		
		//Once you've clicked the button, assert that a success message is displayed
		homePage.test5Button.click();
		Assert.assertTrue(homePage.test5SuccessMessage.isDisplayed());
		
		//Assert that the button is now disabled
		Assert.assertFalse(homePage.test5Button.isEnabled());
	}
	@Test()
	public void test6() {
		// Navigate to the home page
		Driver.getDriver().get(TestDataReader.getProperty("localFileLocation"));
		
		//Write a method that allows you to find the value of any cell on the grid
		WebElement tableElement = Driver.getDriver()
				.findElement(By.xpath(getXpath(2,2)));
		
		//Use the method to find the value of the cell at coordinates 2, 2 
		//(staring at 0 in the top left corner)
		String cellTextValueAtRow2Column2 = tableElement.getText();
		
		//Assert that the value of the cell is "Ventosanzap"
		Assert.assertTrue(cellTextValueAtRow2Column2.equals("Ventosanzap"));

	}
	public String getXpath(int rowCoordinate, int columnCoordinate) {
		
		rowCoordinate++;
		columnCoordinate++;
			String xpath =
 "//div[@id='test-6-div']/div/table/tbody/tr["+rowCoordinate+"]/td["+columnCoordinate+"]";			
		return xpath;
	}
		
	}

