package com.testing.pageobjects;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminDashPage {

	public static void enterAdminDashbd(WebDriver driver, Properties prop) {
		String adminDashboard = prop.getProperty("adminDashbd");
		System.out.println("enter admindashbd = " + adminDashboard);
		driver.findElement(By.id(adminDashboard)).click();
	}
	
	public static void verifyNavigation (WebDriver driver, Properties prop) {
		String gTitle = driver.getTitle();
		String pageTitle = prop.getProperty("adminDashbdPg");
		
		if(gTitle.matches(pageTitle)){
			System.out.println("Navigation to Admin Dashboard successful!");
		} else {
			System.out.println("Unable to navigate to Admin Dashboard...");
		}
	}
	
	public static void returnHome(WebDriver driver, Properties prop) {
		String adminHome = prop.getProperty("adminHomeBtn");
		driver.findElement(By.name(adminHome)).click();
	}
}
