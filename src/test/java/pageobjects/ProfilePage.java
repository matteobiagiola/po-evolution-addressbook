package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.UserInfoFromTable;

public class ProfilePage {

	private WebDriver driver;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/form[1]/b[1]")
	private WebElement loggedUserElement;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/form[1]/a[1]")
	private WebElement logoutLink;
	
	@FindBy(xpath = "//input[@value='Delete']")
	private WebElement deleteButton;
	
	@FindBy(xpath = "//input[@id='MassCB']")
	private WebElement selectAllButton;
	
	@FindBy(xpath = "//input[@title='Search for any text']")
	private WebElement searchBar;
	
	@FindBy(xpath = "//a[@title='Sort on “Name”']")
	private WebElement orderByName;

	@FindBy(xpath = "/html/body/div[1]/div[4]/form[2]/table/tbody/tr[2]/td[8]/a[1]/img[1]")
	private WebElement firstEntryEditAddressIcon;

	@FindBy(xpath = "/html/body/div[1]/div[4]/form[2]/table/tbody/tr[2]/td[3]")
	private WebElement firstEntryName;

	@FindBy(xpath = "/html/body/div[1]/div[4]/form[2]/table/tbody/tr[2]/td[4]")
	private WebElement firstEntryAddress;

	@FindBy(xpath = "/html/body/div[1]/div[4]/form[2]/table/tbody/tr[2]/td[5]")
	private WebElement firstEntryEmail;

	@FindBy(xpath = "/html/body/div[1]/div[4]/form[2]/table/tbody/tr[2]/td[6]")
	private WebElement firstEntryPhone;

	@FindBy(xpath = "/html/body/div[1]/div[4]/form[2]/table/tbody/tr[3]/td[3]")
	private WebElement secondEntryName;

	@FindBy(xpath = "/html/body/div[1]/div[4]/form[2]/table/tbody/tr[3]/td[4]")
	private WebElement secondEntryAddress;

	@FindBy(xpath = "/html/body/div[1]/div[4]/form[2]/table/tbody/tr[3]/td[5]")
	private WebElement secondEntryEmail;

	@FindBy(xpath = "/html/body/div[1]/div[4]/form[2]/table/tbody/tr[3]/td[6]")
	private WebElement secondEntryPhone;



	
	private String tableHeadeXPath = "/html/body/div[1]/div[4]/form[2]/table/tbody/";
	
	
	
	public ProfilePage (WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	
	/**
	 * getter from the page
	 * @return the logged user name, if any. Null otherwise
	 */
	public String getLoggedUser () {
		
		String valueToReturn = null;
		
		if (loggedUserElement != null) {
			
			valueToReturn = loggedUserElement.getText();
		}
		
		return valueToReturn;
	}
	
	/**
	 * logout
	 * @return the login page
	 */
	public LoginPage logout() {
		
		logoutLink.click();
		
		return new LoginPage(driver);
	}

	/**
	 * get the data of the user in the given row of the table
	 * @return UserInfoFromTable object with the data, null if the first row is not present
	 */
	public UserInfoFromTable getFirstUserInfoFromTable() {

		UserInfoFromTable userInfoToReturn = null;
		try {
			if (!firstEntryName.getAttribute("style").equals("display: none;") && !firstEntryName.getText().equals("")) {

				userInfoToReturn = new UserInfoFromTable
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

		return userInfoToReturn;
	}

	/**
	 * get the data of the user in the given row of the table
	 * @return UserInfoFromTable object with the data, null if the second row is not present
	 */
	public UserInfoFromTable getSecondUserInfoFromTable() {

		UserInfoFromTable userInfoToReturn = null;
		try {
			if (!secondEntryName.getAttribute("style").equals("display: none;") && !secondEntryName.getText().equals("")) {

				userInfoToReturn = new UserInfoFromTable
						(
								secondEntryName.getText(),
								secondEntryAddress.getText(),
								secondEntryEmail.getText(),
								secondEntryPhone.getText()
						);
			}
		}
		catch (NoSuchElementException e) {
		}

		return userInfoToReturn;
	}


	/**
	 * get the data of the user in the given row of the table
	 * @param index the index of the row of the table (from 0)
	 * @return UserInfoFromTable object with the data, null if the row is not present
	 */
	public UserInfoFromTable getUserInfoFromTable(int index) {
		
		UserInfoFromTable userInfoToReturn = null;
		
		String xPathOfRow = tableHeadeXPath + "tr[" + (index+2) + "]";
		
		try {
			WebElement row = driver.findElement(By.xpath(xPathOfRow));
			
			if (row != null && !row.getAttribute("style").equals("display: none;")) {
				
				userInfoToReturn = new UserInfoFromTable
						(
								row.findElement(By.xpath("./td[3]")).getText(),
								row.findElement(By.xpath("./td[4]")).getText(),
								row.findElement(By.xpath("./td[5]")).getText(),
								row.findElement(By.xpath("./td[6]")).getText()
						);
			}
		}
		catch (NoSuchElementException e) {
			
		}
		
		return userInfoToReturn;
	} 
	
	
	/**
	 * go to edit the selected address
	 * @param index the index of the address in the table
	 * @return the page with the full form
	 */
	public AddNewAddressBookFullForm editAddress(int index) {
		
//		String xPathOfRow = tableHeadeXPath + "tr[" + (index+2) + "]";
//		WebElement row = driver.findElement(By.xpath(xPathOfRow));
//		row.findElement(By.xpath("./td[8]/a[1]/img[1]")).click();

		firstEntryEditAddressIcon.click();
		
		return new AddNewAddressBookFullForm(driver);
		
		
	}
	
	
	/**
	 * delete all from the table
	 */
	public ProfilePage deleteAllFromTable () {
			
		selectAllButton.click();
		
		deleteButton.click();
		
		driver.switchTo().alert().accept();
		
		return new NavBar(driver).goToProfilePage();
	}
	
	
	public void searchInBar (String textToInsert) {
		
		searchBar.clear();
		searchBar.sendKeys(textToInsert);
	}
	
	
	public void toggleOrderByName () {
		
		orderByName.click();
	}
}
