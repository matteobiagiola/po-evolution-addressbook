package tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import pageobjects.LoginPage;
import utils.BaseTest;

public class TestLoginEmpty extends BaseTest {

	@Test
	public void testLoginEmpty() {

		String username = "";
		String password = "";
		
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);
		assertTrue(loginPage.isLoginPage());
	}
}
