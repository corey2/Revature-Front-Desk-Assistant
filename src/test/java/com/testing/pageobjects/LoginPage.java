package com.testing.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends RFDAWebPage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void inputUsername(String elementKey, String dataKey) {
		String element = location.getProperty(elementKey);
		String data = input.getProperty(dataKey);		 
		driver.findElement(By.id(element)).sendKeys(data);
	}
	
	public void inputPassword(String elementKey, String dataKey) {
		String element = location.getProperty(elementKey);
		String data = input.getProperty(dataKey);
		driver.findElement(By.id(element)).sendKeys(data);
	}
	
	public void login(String key) {
		String element = location.getProperty(key);
		driver.findElement(By.name(element)).click();
	}
	
}
