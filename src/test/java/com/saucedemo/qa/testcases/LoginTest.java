package com.saucedemo.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.saucedemo.qa.base.Base;
import com.saucedemo.qa.pages.LoginPage;
import com.saucedemo.qa.pages.LogoutPage;
import com.saucedemo.qa.utils.Utilities;

public class LoginTest extends Base {
	public WebDriver driver;

	@BeforeMethod
	public void setup() {
		loadPropertiesFile();
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
	}

	@Test(priority = 1)
	public void verifyValidLoginDetailsAndLogout() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(prop.getProperty("validUsername"));
		loginpage.enterPassword(prop.getProperty("validPassword"));
		loginpage.clickOnLoginButton();
		LogoutPage logoutpage = new LogoutPage(driver);
		logoutpage.clickOnHamBurgerMenu();
		logoutpage.clickOnLogoutButton();
	}

	@Test(priority = 2)
	public void verifyInvalidLoginDetails() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername("sauceuser123");
		loginpage.enterPassword("user345678");
		loginpage.clickOnLoginButton();
		String warningMessage = loginpage.retriveLoginErrorMessage();
		System.out.println(warningMessage);
		Assert.assertEquals(warningMessage,
				"Epic sadface: Username and password do not match any user in this service");
	}

	@Test(priority = 3, dataProvider = "credentialSupplier")
	public void verifyCombinationsOfLoginDetails(String username, String password) {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickOnLoginButton();
	}

	@DataProvider(name = "credentialSupplier")
	public Object[][] supplyTestData() {
		Object[][] data = Utilities.getTestDataFromExcel("Login");
		return data;
	}

	// Method overloading
	@Test(priority = 4)
	public void verifyWithouUsernameAndPassword() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterBlankUsernaeAndPassword();
		loginpage.clickOnLoginButton();
		String warningMessage = loginpage.retriveLoginErrorMessage();
		System.out.println(warningMessage);
		Assert.assertEquals(warningMessage, "Epic sadface: Username is required");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
