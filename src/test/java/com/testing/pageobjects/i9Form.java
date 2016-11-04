package com.testing.pageobjects;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class i9Form {

	public static void clickI9Form(WebDriver driver, Properties prop) {
		driver.findElement(By.id("i9form")).click();
	}
	
	public static void returnHome(WebDriver driver, Properties prop) {
		driver.findElement(By.id("Home")).click();
	}
}
