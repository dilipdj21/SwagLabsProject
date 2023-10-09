package com.saucedemo.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.saucedemo.qa.utils.Utilities;

public class Base {
	public WebDriver driver;
	public Properties prop;
	public Properties dataProp;

	public void loadPropertiesFile() {
		prop = new Properties();
		File propFile = new File(
				System.getProperty("user.dir") + "/src/main/java/com/saucedemo/qa/config/config.properties");
		try {
			FileInputStream fis = new FileInputStream(propFile);
			prop.load(fis);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public WebDriver initializeBrowserAndOpenApplicationURL(String broswer) {
		if (broswer.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (broswer.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (broswer.equals("safari")) {
			driver = new SafariDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME));
		driver.get(prop.getProperty("url"));
		return driver;
	}
}
