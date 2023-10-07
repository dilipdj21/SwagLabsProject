package com.saucedemo.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	@FindBy(id = "user-name")
	private WebElement loginField;

	@FindBy(id = "password")
	private WebElement passwordField;

	@FindBy(id = "login-button")
	private WebElement loginButton;

	@FindBy(xpath = "//div[@class='error-message-container error']")
	private WebElement loginErrorMessage;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterUsername(String username) {
		loginField.sendKeys(username);
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	// Method Overloading
	public void enterUsernameAndPassword(String username, String password) {
		loginField.sendKeys(username);
		passwordField.sendKeys(password);
	}

	// Method Overloading
	public void enterBlankUsernaeAndPassword() {
		loginField.sendKeys("");
		passwordField.sendKeys("");
	}

	public void clickOnLoginButton() {
		loginButton.click();
	}

	public String retriveLoginErrorMessage() {
		String warningMessage = loginErrorMessage.getText();
		return warningMessage;
	}
}
