package com.saucedemo.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	@FindBy(xpath = "(//button[contains(text(),'Add to cart')])[1]")
	private WebElement addToCart;

	@FindBy(xpath = "//span[@class='shopping_cart_badge']")
	private WebElement AddToCartIcon;

	@FindBy(id = "checkout")
	private WebElement checkOut;

	@FindBy(id = "first-name")
	private WebElement firstNameField;

	@FindBy(id = "last-name")
	private WebElement lastNameField;

	@FindBy(id = "postal-code")
	private WebElement postalCodeField;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement continueButton;

	@FindBy(id = "finish")
	private WebElement finishButton;

	@FindBy(id = "back-to-products")
	private WebElement backHomeButton;

	@FindBy(xpath = "//div[@class='inventory_item_name']")
	private WebElement productTitle;

	@FindBy(xpath = "//button[contains(text(),'Remove')]")
	private WebElement remove;

	@FindBy(id = "continue-shopping")
	private WebElement continueShopping;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void addToCartList() {
		List<WebElement> addtocart = driver.findElements(By.xpath("//button[contains(text(),'Add to cart')]"));
		for (int i = 0; i < addtocart.size(); i++) {
			addtocart.get(i).click();
		}
	}

	public void clickOnAlertPopUp() {
		driver.switchTo().alert().accept();
	}

	public void clickOnAddToCart() {
		addToCart.click();
	}

	public void clickOnAddToCartIcon() {
		AddToCartIcon.click();
	}

	public void clickOnCheckOutButton() {
		checkOut.click();
	}

	public void enterFirstname(String fname) {
		firstNameField.sendKeys(fname);
	}

	public void enterLastname(String lname) {
		lastNameField.sendKeys(lname);
	}

	public void enterPincode(String pincode) {
		postalCodeField.sendKeys(pincode);
	}

	public void clickOnContinue() {
		continueButton.click();
	}

	public void clickOnFinish() {
		finishButton.click();
	}

	public void clickOnBackToProducts() {
		backHomeButton.click();
	}

	public String retrieveProductTitle() {
		String title = productTitle.getText();
		return title;
	}

	public void clickOnRemoveFromCart() {
		remove.click();
	}

	public void clickOnContinueShopping() {
		continueShopping.click();
	}
}
