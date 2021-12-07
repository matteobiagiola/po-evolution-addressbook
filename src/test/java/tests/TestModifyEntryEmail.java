package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import org.junit.Test;

import pageobjects.AddNewAddressBookAddressForm;
import pageobjects.AddNewAddressBookFullForm;
import pageobjects.LoginPage;
import pageobjects.NavBar;
import pageobjects.ProfilePage;
import utils.BaseTest;
import utils.UserInfoFromTable;

public class TestModifyEntryEmail extends BaseTest {

	@Test
	public void testModifyEntryEmail() {
		
		String username = "admin";
		String password = "secret";
		
		String firstName = "mario";
		String lastName = "rossi";
		String address = "via di qua";
		String mobile = "0123456";
		String email = firstName + "." + lastName + "@mail.it";
		
		
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);
		assertFalse(loginPage.isLoginPage());
		
		
		ProfilePage profilePage = new ProfilePage(driver);
		profilePage = profilePage.deleteAllFromTable();
		assertEquals("(" + username + ")", profilePage.getLoggedUser());
		
		
		AddNewAddressBookAddressForm addNewAddressFirstForm = new NavBar(driver).goToAddNewAddressBook();
		AddNewAddressBookFullForm addNewAddressCompleteForm = addNewAddressFirstForm.goToFullForm();
		
		
		profilePage = addNewAddressCompleteForm.addNewAddress(firstName, lastName, address, mobile, email);
		UserInfoFromTable userData = profilePage.getFirstUserInfoFromTable();

		
		assertEquals(lastName + " " + firstName, userData.getFirstAndSecondName());
		assertEquals(address, userData.getAddress());
		assertEquals(mobile, userData.getMobile());
		assertEquals(email, userData.getEmail());
		
		
		
		email = "another one";
		
		
		
		addNewAddressCompleteForm = profilePage.editAddress();
		profilePage = addNewAddressCompleteForm.addNewAddress(firstName, lastName, address, mobile, email);
		userData = profilePage.getFirstUserInfoFromTable();

		
		assertEquals(lastName + " " + firstName, userData.getFirstAndSecondName());
		assertEquals(address, userData.getAddress());
		assertEquals(mobile, userData.getMobile());
		assertEquals(email, userData.getEmail());
		
		profilePage.deleteAllFromTable();
	}
}
