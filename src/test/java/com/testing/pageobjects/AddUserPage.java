package com.testing.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddUserPage extends RFDAWebPage {

	public AddUserPage(WebDriver driver) {
		super(driver);
	}
	
	public void username(String elementKey, String dataKey) {
		
		//driver.findElement(By.name(usernameField)).sendKeys(username);
	}
	
	public void firstName(String elementKey, String dataKey) {
		
		//driver.findElement(By.name(fnameField)).sendKeys(fname);
	}
	
	public void lastName(String elementKey, String dataKey) {
		
		//driver.findElement(By.name(lnameField)).sendKeys(lname);
	}
	
	public void email(String elementKey, String dataKey) {
		
		//driver.findElement(By.name(emailfield)).sendKeys(email);
	}
	
	public void submit() {
		String send = location.getProperty("addSubmit");
		driver.findElement(By.xpath(send)).click();
	}
	
	public void successfulSentEmail() {
		String send = location.getProperty("successfulSentEmail");
		driver.findElement(By.xpath(send)).click();
	}
	
	/*LogOut Functionality*/
	public void logOut() {
		String send = location.getProperty("logOut");
		driver.findElement(By.xpath(send)).click();
	}
	
	/*Successful logout page after LogOut Functionality back home*/
	public void logOutSuccess() {
		String send = location.getProperty("logOutSuccess");
		driver.findElement(By.xpath(send)).click();
	}
}
