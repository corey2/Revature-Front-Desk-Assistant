package com.testing.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBar extends RFDAWebPage {

	public NavigationBar(WebDriver driver) {
		super(driver);
	}

	public void returnHome() {
		String adminHome = location.getProperty("adminHomeBtn");
		driver.findElement(By.name(adminHome)).click();
	}

}
