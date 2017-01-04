package com.testing.pageobjects;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	public static void homeLogin(WebDriver driver, Properties prop) {
		String homeLogin = prop.getProperty("homeLogin");
		driver.findElement(By.name(homeLogin)).click();
		//driver.findElement(By.xpath(homelogin)).click();
	}
	
	public static void homeLoginNB(WebDriver driver, Properties prop) {
		String navbarlogin = prop.getProperty("homeLoginNB");
		driver.findElement(By.id(navbarlogin)).click();
	}
	
	public static void verifyLogin (WebDriver driver, Properties prop) {
		String gTitle = driver.getTitle();
		String pageTitle = prop.getProperty("loginPg");
		
		if(gTitle.matches(pageTitle)){
			System.out.println("Navigation to Login Page successful!");
		} else {
			System.out.println("Unable to navigate to Login Page...");
		}
		
		LoginAdminPage.returnHome(driver, prop);   //Question 1
	}
}
