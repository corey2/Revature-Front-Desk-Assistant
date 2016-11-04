package com.testing.pageobjects;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmergencyContact {
	
	public static void clickEmergContacts(WebDriver driver, Properties prop) {
		driver.findElement(By.id("emergencyContact")).click();
	}
	
	public static void returnHome(WebDriver driver, Properties prop) {
		driver.findElement(By.id("Home")).click();
	}

}
