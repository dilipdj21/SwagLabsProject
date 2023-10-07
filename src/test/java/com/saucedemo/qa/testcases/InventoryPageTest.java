package com.saucedemo.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.saucedemo.qa.base.Base;
import com.saucedemo.qa.pages.HomePage;
import com.saucedemo.qa.pages.InventoryPage;
import com.saucedemo.qa.pages.LoginPage;
import com.saucedemo.qa.pages.LogoutPage;

public class InventoryPageTest extends Base {

	public WebDriver driver;

	@BeforeMethod
	public void setup() {
		loadPropertiesFile();
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(prop.getProperty("validUsername"));
		loginpage.enterPassword(prop.getProperty("validPassword"));
		loginpage.clickOnLoginButton();
	}

	@Test(priority = 1)
	public void verifySortProductsAndAddToCart() {
		InventoryPage productpage = new InventoryPage(driver);
		productpage.sortPrproductsByNameOrPrice();
		HomePage homepage = new HomePage(driver);
		homepage.clickOnAddToCart();
		homepage.clickOnAddToCartIcon();
		homepage.clickOnCheckOutButton();
		homepage.enterFirstname("Andy");
		homepage.enterLastname("Tyra");
		homepage.enterPincode("BR7682");
		homepage.clickOnContinue();
		homepage.clickOnFinish();
		homepage.clickOnBackToProducts();
	}

	@Test(priority = 2)
	public void verifyAddMultipleProducts() {
		HomePage homepage = new HomePage(driver);
		homepage.addToCartList();
		homepage.clickOnAddToCartIcon();
		homepage.clickOnCheckOutButton();
		homepage.enterFirstname("Tim");
		homepage.enterLastname("Kon");
		homepage.enterPincode("SR7676");
		homepage.clickOnContinue();
		homepage.clickOnFinish();
		homepage.clickOnBackToProducts();
		LogoutPage logoutpage = new LogoutPage(driver);
		logoutpage.clickOnHamBurgerMenu();
		logoutpage.clickOnLogoutButton();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
