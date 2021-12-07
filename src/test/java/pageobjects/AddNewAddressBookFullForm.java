package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewAddressBookFullForm {

	private WebDriver driver;
	
	@FindBy(xpath = "//input[@name='firstname']")
	private WebElement firstNameField;
	
	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement lastNameField;
	
	@FindBy(xpath = "//textarea[@name='address']")
	private WebElement addressField;
	
	@FindBy(xpath = "//input[@name='mobile']")
	private WebElement mobileField;
	
	@FindBy(xpath = "//input[@name='email']")
	private WebElement emailField;
	
	@FindBy(xpath = "//div[@id='content']//form[1]//input[1]")
	private WebElement submitForm;
	
	@FindBy(xpath = "//input[@value='Delete']")
	private WebElement deleteButton;
	
	
	public AddNewAddressBookFullForm (WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}

	/**
	 * Insert the given values in the form and submit
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param mobile
	 * @param email
	 * @return the profile page
	 */
	public ProfilePage addNewAddress(String firstName, String lastName, String address, String mobile, String email) {
	
		addToFormIfNotNull(firstNameField, firstName);
		addToFormIfNotNull(lastNameField, lastName);
		addToFormIfNotNull(addressField, address);
		addToFormIfNotNull(mobileField, mobile);
		addToFormIfNotNull(emailField, email);
		
		submitForm.click();
		
		return new NavBar(driver).goToProfilePage();
	}
	
	
	public ProfilePage delete() {
		
		deleteButton.click();
		
		return new NavBar(driver).goToProfilePage();
	}

	private void addToFormIfNotNull (WebElement formField, String value) {
		
		if (value != null) {
			
			formField.clear();
			formField.sendKeys(value);
		}
	}
	
	
	
	
}
