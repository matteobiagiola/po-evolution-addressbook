package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import utils.BaseTest;
import utils.UserInfoFromTable;

public class TestModifyEntryMobileNumber extends BaseTest {

	@Test
	public void testModifyEntryMobileNumber() {

		String username = "admin";
		String password = "secret";

		String firstName = "mario";
		String lastName = "rossi";
		String address = "via di qua";
		String mobile = "0123456";
		String email = firstName + "." + lastName + "@mail.it";

		WebElement usernameFieldLogin = driver.findElement(By.xpath("//input[@name='user']"));
		WebElement passwordFieldLogin = driver.findElement(By.xpath("//input[@name='pass']"));
		WebElement submitButtonLogin = driver.findElement(By.xpath("//input[@value='Login']"));
		usernameFieldLogin.sendKeys(username);
		passwordFieldLogin.sendKeys(password);
		submitButtonLogin.click();
		boolean isLoginFormPresent = true;
		try {
			usernameFieldLogin = driver.findElement(By.xpath("//input[@name='user']"));
			usernameFieldLogin.isDisplayed();
		}
		catch (NoSuchElementException e) {
			isLoginFormPresent = false;
		}
		assertFalse(isLoginFormPresent);

		WebElement deleteButton = driver.findElement(By.xpath("//input[@value='Delete']"));
		WebElement selectAllButton = driver.findElement(By.xpath("//input[@id='MassCB']"));
		selectAllButton.click();
		deleteButton.click();
		driver.switchTo().alert().accept();
		WebElement homeLink = driver.findElement(By.xpath("//a[contains(text(),'home')]"));
		homeLink.click();
		WebElement loggedUserElement = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/form[1]/b[1]"));
		String loggedUser = null;
		if (loggedUserElement != null) {
			loggedUser = loggedUserElement.getText();
		}
		assertEquals("(" + username + ")", loggedUser);

		WebElement addNewLink = driver.findElement(By.xpath("//a[contains(text(),'add new')]"));
		addNewLink.click();
		WebElement nextButton = driver.findElement(By.xpath("//form[@name='quickadd']//input[1]"));
		nextButton.click();

		WebElement firstNameField = driver.findElement(By.xpath("//input[@name='firstname']"));
		WebElement lastNameField = driver.findElement(By.xpath("//input[@name='lastname']"));
		WebElement addressField = driver.findElement(By.xpath("//textarea[@name='address']"));
		WebElement mobileField = driver.findElement(By.xpath("//input[@name='mobile']"));
		WebElement emailField = driver.findElement(By.xpath("//input[@name='email']"));
		WebElement submitForm = driver.findElement(By.xpath("//div[@id='content']//form[1]//input[1]"));
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
		homeLink = driver.findElement(By.xpath("//a[contains(text(),'home')]"));
		homeLink.click();
		WebElement firstEntryName = driver.findElement(By.xpath("/html/body/div[1]/div[4]/form[2]/table/tbody/tr[2]/td[3]"));
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

		mobile = "333333";

		WebElement firstEntryEditAddressIcon = driver.findElement(By.xpath("/html/body/div[1]/div[4]/form[2]/table/tbody/tr[2]/td[8]/a[1]/img[1]"));
		firstEntryEditAddressIcon.click();

		firstNameField = driver.findElement(By.xpath("//input[@name='firstname']"));
		lastNameField = driver.findElement(By.xpath("//input[@name='lastname']"));
		addressField = driver.findElement(By.xpath("//textarea[@name='address']"));
		mobileField = driver.findElement(By.xpath("//input[@name='mobile']"));
		emailField = driver.findElement(By.xpath("//input[@name='email']"));
		submitForm = driver.findElement(By.xpath("//div[@id='content']//form[1]//input[1]"));
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
		homeLink = driver.findElement(By.xpath("//a[contains(text(),'home')]"));
		homeLink.click();
		userData = null;
		try {
			firstEntryName = driver.findElement(By.xpath("/html/body/div[1]/div[4]/form[2]/table/tbody/tr[2]/td[3]"));
			firstEntryAddress = driver.findElement(By.xpath("/html/body/div[1]/div[4]/form[2]/table/tbody/tr[2]/td[4]"));
			firstEntryEmail = driver.findElement(By.xpath("/html/body/div[1]/div[4]/form[2]/table/tbody/tr[2]/td[5]"));
			firstEntryPhone = driver.findElement(By.xpath("/html/body/div[1]/div[4]/form[2]/table/tbody/tr[2]/td[6]"));
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

		selectAllButton = driver.findElement(By.xpath("//input[@id='MassCB']"));
		selectAllButton.click();
		deleteButton = driver.findElement(By.xpath("//input[@value='Delete']"));
		deleteButton.click();
		driver.switchTo().alert().accept();
		homeLink = driver.findElement(By.xpath("//a[contains(text(),'home')]"));
		homeLink.click();
	}
}
