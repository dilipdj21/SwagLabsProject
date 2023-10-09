package com.saucedemo.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.saucedemo.qa.base.Base;
import com.saucedemo.qa.pages.HomePage;
import com.saucedemo.qa.pages.LoginPage;
import com.saucedemo.qa.pages.LogoutPage;

public class HomePageTest extends Base {
	public WebDriver driver;

	@BeforeMethod
	public void setup() throws IOException {
		loadPropertiesFile();
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(prop.getProperty("validUsername"));
		loginpage.enterPassword(prop.getProperty("validPassword"));
		loginpage.clickOnLoginButton();
	}

	@Test(priority = 2)
	public void verifyEndToEndFlow() {
		HomePage homepage = new HomePage(driver);
		homepage.clickOnAddToCart();
		homepage.clickOnAddToCartIcon();
		homepage.clickOnCheckOutButton();
		homepage.enterFirstname("Andy");
		homepage.enterLastname("Jassy");
		homepage.enterPincode("CR8743");
		homepage.clickOnContinue();
		String title = homepage.retrieveProductTitle();
		Assert.assertEquals(title, "Sauce Labs Backpack", "Wrong title name");
		homepage.clickOnFinish();
		homepage.clickOnBackToProducts();
		LogoutPage logoutpage = new LogoutPage(driver);
		logoutpage.clickOnHamBurgerMenu();
		logoutpage.clickOnLogoutButton();
	}

	@Test(priority = 1)
	public void verifyRemoveProductFromCart() {
		HomePage homepage = new HomePage(driver);
		homepage.clickOnAddToCart();
		homepage.clickOnAddToCartIcon();
		homepage.clickOnRemoveFromCart();
		homepage.clickOnContinueShopping();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
