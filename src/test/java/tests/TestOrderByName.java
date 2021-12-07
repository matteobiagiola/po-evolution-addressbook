package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.Test;

import pageobjects.AddNewAddressBookAddressForm;
import pageobjects.AddNewAddressBookFullForm;
import pageobjects.LoginPage;
import pageobjects.NavBar;
import pageobjects.ProfilePage;
import utils.BaseTest;
import utils.UserInfoFromTable;

public class TestOrderByName extends BaseTest {

	@Test
	public void testOrderByName() {
	
		
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
		
		
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);
		assertFalse(loginPage.isLoginPage());
		
		
		ProfilePage profilePage = new ProfilePage(driver);
		profilePage = profilePage.deleteAllFromTable();
		assertEquals("(" + username + ")", profilePage.getLoggedUser());
		
		
		AddNewAddressBookAddressForm addNewAddressFirstForm = new NavBar(driver).goToAddNewAddressBook();
		AddNewAddressBookFullForm addNewAddressCompleteForm = addNewAddressFirstForm.goToFullForm();
		
		
		profilePage = addNewAddressCompleteForm.addNewAddress(firstName, lastName, address, mobile, email);
//		UserInfoFromTable userData = profilePage.getUserInfoFromTable(0);
		UserInfoFromTable userData = profilePage.getFirstUserInfoFromTable();

		
		assertEquals(lastName + " " + firstName, userData.getFirstAndSecondName());
		assertEquals(address, userData.getAddress());
		assertEquals(mobile, userData.getMobile());
		assertEquals(email, userData.getEmail());

		

		
		
		
		addNewAddressFirstForm = new NavBar(driver).goToAddNewAddressBook();
		addNewAddressCompleteForm = addNewAddressFirstForm.goToFullForm();
		
		
		profilePage = addNewAddressCompleteForm.addNewAddress(firstName2, lastName2, address2, mobile2, email2);
//		userData = profilePage.getUserInfoFromTable(1);
		userData = profilePage.getSecondUserInfoFromTable();

		
		assertEquals(lastName2 + " " + firstName2, userData.getFirstAndSecondName());
		assertEquals(address2, userData.getAddress());
		assertEquals(mobile2, userData.getMobile());
		assertEquals(email2, userData.getEmail());

		
		
		profilePage.toggleOrderByName();
//		userData = profilePage.getUserInfoFromTable(0);
		userData = profilePage.getFirstUserInfoFromTable();
		assertEquals(lastName + " " + firstName, userData.getFirstAndSecondName());
		
		profilePage.toggleOrderByName();
//		userData = profilePage.getUserInfoFromTable(0);
		userData = profilePage.getFirstUserInfoFromTable();
		assertEquals(lastName2 + " " + firstName2, userData.getFirstAndSecondName());
		
		
		profilePage.deleteAllFromTable();
	}
}
