package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import utils.BaseTest;
import utils.UserInfoFromTable;

public class TestDeleteAllEntries extends BaseTest {

	@Test
	public void testDeleteAllEntries() {
		
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
			usernameFieldLogin = driver.findElement(By.xpath("//input[@name='username']"));
			usernameFieldLogin.isDisplayed();
		}
		catch (NoSuchElementException e) {
			isLoginFormPresent = false;
		}
		assertFalse(isLoginFormPresent);

		WebElement deleteButton = driver.findElement(By.xpath("//input[@value='delete']"));
		WebElement selectAllButton = driver.findElement(By.xpath("//input[@id='massCB']"));
		selectAllButton.click();
		deleteButton.click();
		driver.switchTo().alert().accept();
		WebElement homeLink = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
		homeLink.click();
		WebElement loggedUserElement = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[5]/form[1]/b[1]"));
		String loggedUser = null;
		if (loggedUserElement != null) {
			loggedUser = loggedUserElement.getText();
		}
		assertEquals("(" + username + ")", loggedUser);

		WebElement addNewLink = driver.findElement(By.xpath("//a[contains(text(),'Add New')]"));
		addNewLink.click();
		WebElement nextButton = driver.findElement(By.xpath("//form[@name='quickAdd']//input[1]"));
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
		homeLink = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
		homeLink.click();

		addNewLink = driver.findElement(By.xpath("//a[contains(text(),'Add New')]"));
		addNewLink.click();
		nextButton = driver.findElement(By.xpath("//form[@name='quickAdd']//input[1]"));
		nextButton.click();

		firstNameField = driver.findElement(By.xpath("//input[@name='FirstName']"));
		lastNameField = driver.findElement(By.xpath("//input[@name='LastName']"));
		addressField = driver.findElement(By.xpath("//textarea[@name='Address']"));
		mobileField = driver.findElement(By.xpath("//input[@name='Mobile']"));
		emailField = driver.findElement(By.xpath("//input[@name='Email']"));
		submitForm = driver.findElement(By.xpath("//div[@id='Content']//form[1]//input[1]"));
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
		homeLink = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
		homeLink.click();

		addNewLink = driver.findElement(By.xpath("//a[contains(text(),'Add New')]"));
		addNewLink.click();
		nextButton = driver.findElement(By.xpath("//form[@name='quickAdd']//input[1]"));
		nextButton.click();

		firstNameField = driver.findElement(By.xpath("//input[@name='FirstName']"));
		lastNameField = driver.findElement(By.xpath("//input[@name='LastName']"));
		addressField = driver.findElement(By.xpath("//textarea[@name='Address']"));
		mobileField = driver.findElement(By.xpath("//input[@name='Mobile']"));
		emailField = driver.findElement(By.xpath("//input[@name='Email']"));
		submitForm = driver.findElement(By.xpath("//div[@id='Content']//form[1]//input[1]"));
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
		homeLink = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
		homeLink.click();

		addNewLink = driver.findElement(By.xpath("//a[contains(text(),'Add New')]"));
		addNewLink.click();
		nextButton = driver.findElement(By.xpath("//form[@name='quickAdd']//input[1]"));
		nextButton.click();

		firstNameField = driver.findElement(By.xpath("//input[@name='FirstName']"));
		lastNameField = driver.findElement(By.xpath("//input[@name='LastName']"));
		addressField = driver.findElement(By.xpath("//textarea[@name='Address']"));
		mobileField = driver.findElement(By.xpath("//input[@name='Mobile']"));
		emailField = driver.findElement(By.xpath("//input[@name='Email']"));
		submitForm = driver.findElement(By.xpath("//div[@id='Content']//form[1]//input[1]"));
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
		homeLink = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
		homeLink.click();

		addNewLink = driver.findElement(By.xpath("//a[contains(text(),'Add New')]"));
		addNewLink.click();
		nextButton = driver.findElement(By.xpath("//form[@name='quickAdd']//input[1]"));
		nextButton.click();

		firstNameField = driver.findElement(By.xpath("//input[@name='FirstName']"));
		lastNameField = driver.findElement(By.xpath("//input[@name='LastName']"));
		addressField = driver.findElement(By.xpath("//textarea[@name='Address']"));
		mobileField = driver.findElement(By.xpath("//input[@name='Mobile']"));
		emailField = driver.findElement(By.xpath("//input[@name='Email']"));
		submitForm = driver.findElement(By.xpath("//div[@id='Content']//form[1]//input[1]"));
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
		homeLink = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
		homeLink.click();

		addNewLink = driver.findElement(By.xpath("//a[contains(text(),'Add New')]"));
		addNewLink.click();
		nextButton = driver.findElement(By.xpath("//form[@name='quickAdd']//input[1]"));
		nextButton.click();

		firstNameField = driver.findElement(By.xpath("//input[@name='FirstName']"));
		lastNameField = driver.findElement(By.xpath("//input[@name='LastName']"));
		addressField = driver.findElement(By.xpath("//textarea[@name='Address']"));
		mobileField = driver.findElement(By.xpath("//input[@name='Mobile']"));
		emailField = driver.findElement(By.xpath("//input[@name='Email']"));
		submitForm = driver.findElement(By.xpath("//div[@id='Content']//form[1]//input[1]"));
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
		homeLink = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
		homeLink.click();

		while(true) {
			UserInfoFromTable userData = null;
			try {
				WebElement firstEntryName = driver.findElement(By.xpath("/html/body/div[1]/div[4]/form[2]/table/tbody/tr[2]/td[1]"));
				WebElement firstEntryAddress = driver.findElement(By.xpath("/html/body/div[1]/div[4]/form[2]/table/tbody/tr[2]/td[4]"));
				WebElement firstEntryEmail = driver.findElement(By.xpath("/html/body/div[1]/div[4]/form[2]/table/tbody/tr[2]/td[5]"));
				WebElement firstEntryPhone = driver.findElement(By.xpath("/html/body/div[1]/div[4]/form[2]/table/tbody/tr[2]/td[6]"));
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
			if(userData == null) {
				break;
			}
			WebElement firstEntryEditAddressIcon = driver.findElement(By.xpath("/html/body/div[1]/div[4]/form[2]/table/tbody/td[8]/a[1]/img[1]"));
			firstEntryEditAddressIcon.click();
			deleteButton = driver.findElement(By.xpath("//input[@value='delete']"));
			deleteButton.click();
		}
	}
}
