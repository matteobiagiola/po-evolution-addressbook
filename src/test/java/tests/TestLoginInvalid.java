package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import pageobjects.LoginPage;
import utils.BaseTest;

public class TestLoginInvalid extends BaseTest {

	@Test
	public void testLoginInvalid() {

		String username = "Root";
		String password = "pass";
		
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);
		assertTrue(loginPage.isLoginPage());
	}
}
