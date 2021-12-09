package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import utils.BaseTest;
import utils.UserInfoFromTable;

public class TestSearchEntryNotExisting extends BaseTest {

	@Test
	public void testSearchEntryNotExisting() {

		String username = "admin";
		String password = "secret";

		String firstName = "mario";
		String lastName = "rossi";
		String address = "via di qua";
		String mobile = "0123456";
		String email = firstName + "." + lastName + "@mail.it";

		WebElement usernameFieldLogin = driver.findElement(By.xpath("//input[@name='username']"));
		WebElement submitButtonLogin = driver.findElement(By.xpath("//input[@value='login']"));
		usernameFieldLogin.sendKeys(username);
		submitButtonLogin.click();
		boolean isLoginFormPresent = true;
		try {
			usernameFieldLogin.isDisplayed();
		}
		catch (NoSuchElementException e) {
			isLoginFormPresent = false;
		}
		assertFalse(isLoginFormPresent);

		WebElement deleteButton = driver.findElement(By.xpath("//input[@value='delete']"));
		WebElement selectAllButton = driver.findElement(By.xpath("//input[@id='massCB']"));
		WebElement loggedUserElement = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[5]/form[1]/b[1]"));
		WebElement homeLink = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
		selectAllButton.click();
		deleteButton.click();
		driver.switchTo().alert().accept();
		homeLink.click();
		String loggedUser = null;
		if (loggedUserElement != null) {
			loggedUser = loggedUserElement.getText();
		}
		assertEquals("(" + username + ")", loggedUser);

		WebElement addNewLink = driver.findElement(By.xpath("//a[contains(text(),'Add New')]"));
		WebElement nextButton = driver.findElement(By.xpath("//form[@name='quickAdd']//input[1]"));
		addNewLink.click();
		nextButton.click();

		WebElement firstNameField = driver.findElement(By.xpath("//input[@name='FirstName']"));
		WebElement lastNameField = driver.findElement(By.xpath("//input[@name='LastName']"));
		WebElement addressField = driver.findElement(By.xpath("//textarea[@name='Address']"));
		WebElement mobileField = driver.findElement(By.xpath("//input[@name='Mobile']"));
		WebElement emailField = driver.findElement(By.xpath("//input[@name='Email']"));
		WebElement submitForm = driver.findElement(By.xpath("//div[@id='Content']//form[1]//input[1]"));
		firstNameField.clear();
		firstNameField.sendKeys(firstName);
		lastNameField.clear();
		lastNameField.sendKeys(lastName);
		addressField.clear();
		addressField.sendKeys(address);
		mobileField.clear();
		mobileField.sendKeys(mobile);
		emailField.clear();
		emailField.sendKeys(email);
		submitForm.click();
		WebElement firstEntryName = driver.findElement(By.xpath("/html/body/div[1]/div[4]/form[2]/table/tbody/tr[2]/td[1]"));
		WebElement firstEntryAddress = driver.findElement(By.xpath("/html/body/div[1]/div[4]/form[2]/table/tbody/tr[2]/td[4]"));
		WebElement firstEntryEmail = driver.findElement(By.xpath("/html/body/div[1]/div[4]/form[2]/table/tbody/tr[2]/td[5]"));
		WebElement firstEntryPhone = driver.findElement(By.xpath("/html/body/div[1]/div[4]/form[2]/table/tbody/tr[2]/td[6]"));
		UserInfoFromTable userData = null;
		try {
			if (!firstEntryName.getAttribute("style").equals("display: none;") && !firstEntryName.getText().equals("")) {

				userData = new UserInfoFromTable
						(
								firstEntryName.getText(),
								firstEntryAddress.getText(),
								firstEntryEmail.getText(),
								firstEntryPhone.getText()
						);
			}
		}
		catch (NoSuchElementException e) {
		}
		assertEquals(lastName + " " + firstName, userData.getFirstAndSecondName());
		assertEquals(address, userData.getAddress());
		assertEquals(mobile, userData.getMobile());
		assertEquals(email, userData.getEmail());

		WebElement searchBar = driver.findElement(By.xpath("//input[@title='search for any text']"));
		searchBar.clear();
		searchBar.sendKeys("something different");

		userData = null;
		try {
			if (!firstEntryName.getAttribute("style").equals("display: none;") && !firstEntryName.getText().equals("")) {

				userData = new UserInfoFromTable
						(
								firstEntryName.getText(),
								firstEntryAddress.getText(),
								firstEntryEmail.getText(),
								firstEntryPhone.getText()
						);
			}
		}
		catch (NoSuchElementException e) {
		}
		assertNull(userData);
	}
}
