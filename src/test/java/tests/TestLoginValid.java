package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import utils.BaseTest;

public class TestLoginValid extends BaseTest {

	@Test
	public void testLoginValid() throws InterruptedException {

		String username = "admin";
		String password = "secret";

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

		WebElement loggedUserElement = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[5]/form[1]/b[1]"));
		String loggedUser = null;
		if (loggedUserElement != null) {
			loggedUser = loggedUserElement.getText();
		}
		assertEquals("(" + username + ")", loggedUser);
	}
}
