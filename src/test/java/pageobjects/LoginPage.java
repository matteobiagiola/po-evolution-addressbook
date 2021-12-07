package pageobjects;

import org.openqa.selenium.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	private WebDriver driver;
	
	@FindBy(xpath = "//input[@name='user']")
	private WebElement usernameFieldLogin;
	
	@FindBy(xpath = "//input[@name='pass']")
	private WebElement passwordFieldLogin;
	
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement submitButtonLogin;
	
	
	public LoginPage (WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Simply login. Nothing is returned, because it depends on whether the credentials 
	 * are correct (so go to profile page) or not (so stay in this page)
	 * @param username user name
	 * @param password password
	 */
	public void login(String username, String password) {
		
		usernameFieldLogin.sendKeys(username);
		
		passwordFieldLogin.sendKeys(password);
		
		submitButtonLogin.click();
	}
	
	
	/**
	 * check whether we are in the login page or not
	 * @return
	 */
	public boolean isLoginPage() {
		
		boolean isLoginFormPresent = true;
		
		try {
			usernameFieldLogin.isDisplayed();
			passwordFieldLogin.isDisplayed();
			
		}
		catch (NoSuchElementException e) {
			isLoginFormPresent = false;
		}
		
		return isLoginFormPresent;
		
	}
	
}
