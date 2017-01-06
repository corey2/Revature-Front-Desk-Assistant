package com.testing.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPage extends RFDAWebPage {

	public AdminPage(WebDriver driver) {
		super(driver);
	}

	public void enterDashbd(String key) {
		String element = location.getProperty(key);
		//System.out.println("enter admindashbd = " + adminDashboard);
		driver.findElement(By.name(element)).click();
	}
	
	public void enterSearch(String key) {
		String element = location.getProperty(key);
		driver.findElement(By.name(element)).click();
	}
	
	public void enterCreate(String key) {
		String element = location.getProperty(key);
		driver.findElement(By.name(element)).click();
	}
	
	public void enterUpdate(String key) {
		String element = location.getProperty(key);
		driver.findElement(By.name(element)).click();
	}
	
	public void enterDelete(String key) {
		String element = location.getProperty(key);
		driver.findElement(By.name(element)).click();
	}
	
	public void enterChangePassword(String key) {
		String element = location.getProperty(key);
		driver.findElement(By.name(element)).click();
	}
}
