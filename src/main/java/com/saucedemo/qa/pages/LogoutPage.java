package com.saucedemo.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	WebDriver driver;

	@FindBy(xpath = "//button[text()='Open Menu']")
	private WebElement hamburgerMenu;

	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logoutButton;

	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnHamBurgerMenu() {
		hamburgerMenu.click();
	}

	public void clickOnLogoutButton() {
		logoutButton.click();
	}
}
