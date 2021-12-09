package tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import utils.BaseTest;

public class TestLoginInvalid extends BaseTest {

	@Test
	public void testLoginInvalid() {

		String username = "Root";
		String password = "pass";

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
			passwordFieldLogin = driver.findElement(By.xpath("//input[@name='pass']"));
			passwordFieldLogin.isDisplayed();
		}
		catch (NoSuchElementException e) {
			isLoginFormPresent = false;
		}
		assertTrue(isLoginFormPresent);
	}
}
