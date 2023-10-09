package com.saucedemo.qa.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage {
	WebDriver driver;

	@FindBy(xpath = "//select[@class='product_sort_container']")
	private WebElement dropdown;

	@FindBy(xpath = "//a[text()='Facebook']")
	private WebElement facebookLink;

	@FindBy(xpath = "//a[text()='LinkedIn']")
	private WebElement linkedinLink;

	public InventoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void sortPrproductsByNameOrPrice() {
		Select select = new Select(dropdown);
		select.selectByVisibleText("Price (low to high)");
	}

	public void clickOnFacebookLink() {
		facebookLink.click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> window = windows.iterator();
		System.out.println(windows);
		String parentwindow = window.next();
		String childwindow = window.next();
		driver.switchTo().window(childwindow);
		driver.switchTo().window(parentwindow);
	}

	public void clickOnLinkedinLink() {
		linkedinLink.click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> window = windows.iterator();
		String parentwindow = window.next();
		String childwindow = window.next();
		driver.switchTo().window(childwindow);
		driver.switchTo().window(parentwindow);
	}
}
