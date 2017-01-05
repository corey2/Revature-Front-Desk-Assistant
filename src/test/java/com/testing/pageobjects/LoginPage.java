package com.testing.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends RFDAWebPage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void inputUsername(String unFieldKey, String unInputKey) {
		String unField = prop.getProperty(unFieldKey);
		String unInput= prop.getProperty(unInputKey);		 
		driver.findElement(By.id(unField)).sendKeys(unInput);
	}
	
	public void inputPassword(String pwFieldKey, String pwInputKey) {
		String pwField = prop.getProperty(pwFieldKey);
		String pwInput = prop.getProperty(pwInputKey);
		driver.findElement(By.id(pwField)).sendKeys(pwInput);
	}
	
	public void login(String loginFieldKey) {
		String loginField = prop.getProperty(loginFieldKey);
		driver.findElement(By.name(loginField)).click();
	}
	
}
