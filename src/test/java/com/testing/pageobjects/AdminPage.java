package com.testing.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPage extends RFDAWebPage {

	public AdminPage(WebDriver driver) {
		super(driver);
	}

	public void enterAdminDashbd(String adminDB) {
		String adminDashboard = location.getProperty(adminDB);
		//System.out.println("enter admindashbd = " + adminDashboard);
		driver.findElement(By.name(adminDashboard)).click();
	}
	
	public void verifyNavigation() {
		String gTitle = driver.getTitle();
		String pageTitle = location.getProperty("adminDashbdPg");
		
		if(gTitle.matches(pageTitle)){
			System.out.println("Navigation to Admin Dashboard successful!");
		} else {
			System.out.println("Unable to navigate to Admin Dashboard...");
		}
	}
	
	public void returnHome() {
		String adminHome = location.getProperty("adminHomeBtn");
		driver.findElement(By.name(adminHome)).click();
	}
}
