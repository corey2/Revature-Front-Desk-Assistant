package com.testing.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPage extends RFDAWebPage {

	public AdminPage(WebDriver driver) {
		super(driver);
	}

	public void enterDashbd(String adminDB) {
		String adminDashboard = location.getProperty(adminDB);
		//System.out.println("enter admindashbd = " + adminDashboard);
		driver.findElement(By.name(adminDashboard)).click();
	}
	
	public void enterSearch(String searchKey) {
		String search = location.getProperty(searchKey);
		driver.findElement(By.name(search)).click();
	}
	
	public void enterCreate(String searchKey) {
		String search = location.getProperty(searchKey);
		driver.findElement(By.name(search)).click();
	}
	
	public void enterUpdate(String searchKey) {
		String search = location.getProperty(searchKey);
		driver.findElement(By.name(search)).click();
	}
	
	public void enterDelete(String searchKey) {
		String search = location.getProperty(searchKey);
		driver.findElement(By.name(search)).click();
	}
	
	public void enterChangePassword(String searchKey) {
		String search = location.getProperty(searchKey);
		driver.findElement(By.name(search)).click();
	}
}
