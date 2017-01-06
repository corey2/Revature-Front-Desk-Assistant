package com.testing.pageobjects;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchAssociate extends RFDAWebPage {

	public SearchAssociate(WebDriver driver) {
		super(driver);
	}

	public void enterSearchAssoc() {
		String searchAssociate = location.getProperty("enterSearchAssoc");
		driver.findElement(By.xpath(searchAssociate)).click();
	}
	
	public void firstNameSearch() {
		String fname = location.getProperty("searchFName");
		String fnameField = location.getProperty("searchFNameField");
		driver.findElement(By.name(fnameField)).sendKeys(fname);
	}
	
	public void lastNameSearch() {
		String lname = location.getProperty("searchLName");
		String lnameField = location.getProperty("searchLNameField");
		driver.findElement(By.name(lnameField)).sendKeys(lname);
	}
	
	public void submitSearch() {
		String send = location.getProperty("searchSubmit");
		driver.findElement(By.xpath(send)).click();
	}
	
	public void searchUpdate() {
		String send = location.getProperty("searchUpdate");
		driver.findElement(By.xpath(send)).click();
	}
	
	public void updateHomeNavBar() {
		String send = location.getProperty("updateHomeNavBar");
		driver.findElement(By.xpath(send)).click();
	}
	
	public void searchLogOut() {
		String send = location.getProperty("searchLogOut");
		driver.findElement(By.xpath(send)).click();
	}
	
}
