package com.testing.pageobjects;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginAdminPage {

	public static void inputUsername(WebDriver driver, Properties prop) {
		String userfield = prop.getProperty("userNamefield");
		String username = prop.getProperty("adminUserName");		 
		driver.findElement(By.id(userfield)).sendKeys(username);
	}
	
	public static void inputPassword(WebDriver driver, Properties prop) {
		String pwfield = prop.getProperty("pwfield");
		String password = prop.getProperty("adminpw");
		driver.findElement(By.name(pwfield)).sendKeys(password);
	}
	
	public static void login(WebDriver driver, Properties prop) {
		String adminLogin = prop.getProperty("login");
		driver.findElement(By.name(adminLogin)).click();
	}
	
	public static void verifyLogin (WebDriver driver, Properties prop) {
		String gTitle = driver.getTitle();
		String pageTitle = prop.getProperty("adminPg");
		System.out.println("LoginAdminPage::gTitle= " + gTitle);
		System.out.println("LoginAdminPage::pageTitle= " + pageTitle);
		if(gTitle.matches(pageTitle)){
			System.out.println("Login Admin successful!");
		} else {
			System.out.println("LoginAdminPage::Unable to log in Admin...");
		}
	}
	
	public static void returnHome(WebDriver driver, Properties prop) {
		driver.findElement(By.name("Home")).click();
	}
}
