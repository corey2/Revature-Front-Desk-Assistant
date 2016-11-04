package com.testing.pageobjects;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddAssociate {

	public static void enterAddAssoc(WebDriver driver, Properties prop) {
		String addAssoc = prop.getProperty("enterAddAssoc");
		driver.findElement(By.xpath(addAssoc)).click();
	}
	
	public static void addUserName(WebDriver driver, Properties prop) {
		String username = prop.getProperty("addUsername");
		String usernameField = prop.getProperty("addUsernameField");
		driver.findElement(By.name(usernameField)).sendKeys(username);
	}
	
	public static void firstName(WebDriver driver, Properties prop) {
		String fname = prop.getProperty("addFname");
		String fnameField = prop.getProperty("addFnameField");
		driver.findElement(By.name(fnameField)).sendKeys(fname);
	}
	
	public static void lastName(WebDriver driver, Properties prop) {
		String lname = prop.getProperty("addlName");
		String lnameField = prop.getProperty("addLnameField");
		driver.findElement(By.name(lnameField)).sendKeys(lname);
	}
	
	public static void email(WebDriver driver, Properties prop) {
		String email = prop.getProperty("addEmail");
		String emailfield = prop.getProperty("addEmailField");
		driver.findElement(By.name(emailfield)).sendKeys(email);
	}
	
	public static void submit(WebDriver driver, Properties prop) {
		String send = prop.getProperty("addSubmit");
		driver.findElement(By.xpath(send)).click();
	}
	
	public static void successfulSentEmail(WebDriver driver, Properties prop) {
		String send = prop.getProperty("successfulSentEmail");
		driver.findElement(By.xpath(send)).click();
	}
	
	/*LogOut Functionality*/
	public static void logOut(WebDriver driver, Properties prop) {
		String send = prop.getProperty("logOut");
		driver.findElement(By.xpath(send)).click();
	}
	
	/*Successfull logout page after LogOut Functionality back home*/
	public static void logOutSuccess(WebDriver driver, Properties prop) {
		String send = prop.getProperty("logOutSuccess");
		driver.findElement(By.xpath(send)).click();
	}
}
