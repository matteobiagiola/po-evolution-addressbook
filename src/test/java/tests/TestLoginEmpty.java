package tests;

import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import utils.BaseTest;

import static org.junit.Assert.*;

public class TestLoginEmpty extends BaseTest {

	@Test
	public void testLoginEmpty() {

		String username = "";
		String password = "";

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
		assertTrue(isLoginFormPresent);
	}
}
