package tests;

import utils.BaseTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;

public class CheckTestCase extends BaseTest {
	
	@Test
	public void checkEverythingWorks() {
		String expectedValue = "New features";
		String currentValue = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[4]/b[1]")).getText();
		// first argument is the expected value, second argument is the dynamic value that has to be checked
		assertEquals(expectedValue, currentValue);
	}
	

}
