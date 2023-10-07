package com.saucedemo.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage {
	WebDriver driver;
	
	public InventoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void sortPrproductsByNameOrPrice() {
		WebElement dropdown = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
		Select select = new Select(dropdown);
		select.selectByVisibleText("Price (low to high)");
	}
}
