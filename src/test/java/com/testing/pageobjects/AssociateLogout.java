package com.testing.pageobjects;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AssociateLogout {
	public static void logout(WebDriver driver, Properties prop) {
		String logout = prop.getProperty("Alogout");
		driver.findElement(By.xpath(logout)).click();
	}
	
	public static void logoutSuccess(WebDriver driver, Properties prop) {
		driver.findElement(By.name("Home")).click();
	}
	
}
