package com.testing.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends RFDAWebPage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void homeLogin(String key) {
		String element = location.getProperty(key);
		driver.findElement(By.name(element)).click();
	}
	
	public void homeLoginNB(String key) {
		String element = location.getProperty(key);
		driver.findElement(By.id(element)).click();
	}
	
	public void homeLoginRevature(String key) {
		String element = location.getProperty(key);
		driver.findElement(By.cssSelector("[href=\""+element+"\"]")).click();
	}

}
