package com.testing.pageobjects;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchAssociate {

	public static void enterSearchAssoc(WebDriver driver, Properties prop) {
		String searchAssociate = prop.getProperty("enterSearchAssoc");
		driver.findElement(By.xpath(searchAssociate)).click();
	}
	
	public static void firstNameSearch(WebDriver driver, Properties prop) {
		String fname = prop.getProperty("searchFName");
		String fnameField = prop.getProperty("searchFNameField");
		driver.findElement(By.name(fnameField)).sendKeys(fname);
	}
	
	public static void lastNameSearch(WebDriver driver, Properties prop) {
		String lname = prop.getProperty("searchLName");
		String lnameField = prop.getProperty("searchLNameField");
		driver.findElement(By.name(lnameField)).sendKeys(lname);
	}
	
	public static void submitSearch(WebDriver driver, Properties prop) {
		String send = prop.getProperty("searchSubmit");
		driver.findElement(By.xpath(send)).click();
	}
	
	public static void searchUpdate(WebDriver driver, Properties prop) {
		String send = prop.getProperty("searchUpdate");
		driver.findElement(By.xpath(send)).click();
	}
	
	public static void updateHomeNavBar(WebDriver driver, Properties prop) {
		String send = prop.getProperty("updateHomeNavBar");
		driver.findElement(By.xpath(send)).click();
	}
	
	public static void searchLogOut(WebDriver driver, Properties prop) {
		String send = prop.getProperty("searchLogOut");
		driver.findElement(By.xpath(send)).click();
	}
	
}
