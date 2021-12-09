package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import utils.BaseTest;
import utils.UserInfoFromTable;

public class TestOrderByName extends BaseTest {

	@Test
	public void testOrderByName() throws InterruptedException {
	
		
		String username = "admin";
		String password = "secret";
		
		String firstName = "a";
		String lastName = "rossi";
		String address = "via di qua";
		String mobile = "0123456";
		String email = firstName + "." + lastName + "@mail.it";
		
		String firstName2 = "z";
		String lastName2 = "rossi";
		String address2 = "via di qua";
		String mobile2 = "0123456";
		String email2 = firstName2 + "." + lastName2 + "@mail.it";



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

		addNewLink = driver.findElement(By.xpath("//a[contains(text(),'add new')]"));
		addNewLink.click();
		nextButton = driver.findElement(By.xpath("//form[@name='quickadd']//input[1]"));
		nextButton.click();

		firstNameField = driver.findElement(By.xpath("//input[@name='firstname']"));
		lastNameField = driver.findElement(By.xpath("//input[@name='lastname']"));
		addressField = driver.findElement(By.xpath("//textarea[@name='address']"));
		mobileField = driver.findElement(By.xpath("//input[@name='mobile']"));
		emailField = driver.findElement(By.xpath("//input[@name='email']"));
		submitForm = driver.findElement(By.xpath("//div[@id='content']//form[1]//input[1]"));
		firstNameField.clear();
		firstNameField.sendKeys(firstName2);
		lastNameField.clear();
		lastNameField.sendKeys(lastName2);
		addressField.clear();
		addressField.sendKeys(address2);
		mobileField.clear();
		mobileField.sendKeys(mobile2);
		emailField.clear();
		emailField.sendKeys(email2);
		submitForm.click();
		homeLink = driver.findElement(By.xpath("//a[contains(text(),'home')]"));
		homeLink.click();
		WebElement secondEntryName = driver.findElement(By.xpath("/html/body/div[1]/div[4]/form[2]/table/tbody/tr[3]/td[3]"));
		WebElement secondEntryAddress = driver.findElement(By.xpath("/html/body/div[1]/div[4]/form[2]/table/tbody/tr[3]/td[4]"));
		WebElement secondEntryEmail = driver.findElement(By.xpath("/html/body/div[1]/div[4]/form[2]/table/tbody/tr[3]/td[5]"));
		WebElement secondEntryPhone = driver.findElement(By.xpath("/html/body/div[1]/div[4]/form[2]/table/tbody/tr[3]/td[6]"));
		userData = null;
		try {
			if (!secondEntryName.getAttribute("style").equals("display: none;") && !secondEntryName.getText().equals("")) {

				userData = new UserInfoFromTable
						(
								secondEntryName.getText(),
								secondEntryAddress.getText(),
								secondEntryEmail.getText(),
								secondEntryPhone.getText()
						);
			}
		}
		catch (NoSuchElementException e) {
		}
		assertEquals(lastName2 + " " + firstName2, userData.getFirstAndSecondName());
		assertEquals(address2, userData.getAddress());
		assertEquals(mobile2, userData.getMobile());
		assertEquals(email2, userData.getEmail());

		WebElement orderByName = driver.findElement(By.xpath("//a[@title='Sort on “Name”']"));
		orderByName.click();

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

		orderByName = driver.findElement(By.xpath("//a[@title='Sort on “Name”']"));
		orderByName.click();
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
		assertEquals(lastName2 + " " + firstName2, userData.getFirstAndSecondName());

		selectAllButton = driver.findElement(By.xpath("//input[@id='MassCB']"));
		selectAllButton.click();
		deleteButton = driver.findElement(By.xpath("//input[@value='Delete']"));
		deleteButton.click();
		driver.switchTo().alert().accept();
		homeLink = driver.findElement(By.xpath("//a[contains(text(),'home')]"));
		homeLink.click();
	}
}
