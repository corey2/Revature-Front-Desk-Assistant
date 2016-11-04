package com.testing.pageobjects;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginUserPage {
	public static void inputUsername(WebDriver driver, Properties prop) {
		String userfield = prop.getProperty("userfield");
		String username = prop.getProperty("userName");		 
		driver.findElement(By.name(userfield)).sendKeys(username);
	}
	
	public static void inputPassword(WebDriver driver, Properties prop) {
		String pwfield = prop.getProperty("pwfield");
		String password = prop.getProperty("userpw");
		driver.findElement(By.name(pwfield)).sendKeys(password);
	}
	
	public static void login(WebDriver driver, Properties prop) {
		driver.findElement(By.name("login")).click();
	}
	
	public static void verifyLogin (WebDriver driver, Properties prop) {
		String gTitle = driver.getTitle();
		String pageTitle = prop.getProperty("userPg");
		
		if(gTitle.matches(pageTitle)){
			System.out.println("Login user successful!");
		} else {
			System.out.println("Unable to log in user...");
		}
	}
}
