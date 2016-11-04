package com.testing.pageobjects;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHRPage {

	public static void clickContactHR(WebDriver driver, Properties prop) {
		driver.findElement(By.id("contactHR")).click();
	}
	
	public static void inputSubject(WebDriver driver, Properties prop) {
		String subjectfield = prop.getProperty("cSubjectField");
		String subject = prop.getProperty("contactSubject");		 
		driver.findElement(By.name(subjectfield)).sendKeys(subject);
	}
	
	public static void inputMessage(WebDriver driver, Properties prop) {
		String msgfield = prop.getProperty("cMsgField");
		String msg = prop.getProperty("contactMsg");		 
		driver.findElement(By.name(msgfield)).sendKeys(msg);
	}
	
	public static void reset(WebDriver driver, Properties prop) {
		driver.findElement(By.name("reset")).click();
	}
	
	public static void send(WebDriver driver, Properties prop) {
		driver.findElement(By.name("send")).click();
	}
	
	public static void returnHome(WebDriver driver, Properties prop) {
		driver.findElement(By.id("backToAssociateProfile")).click();
	}
}
