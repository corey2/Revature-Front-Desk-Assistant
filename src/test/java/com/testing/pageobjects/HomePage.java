package com.testing.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends RFDAWebPage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void homeLogin() {
		String homeLogin = location.getProperty("homeLogin");
		driver.findElement(By.name(homeLogin)).click();
		
		//driver.findElement(By.xpath(homelogin)).click();
	}
	
	public void homeLoginNB() {
		String homeLoginNB = location.getProperty("homeLoginNB");
		driver.findElement(By.id(homeLoginNB)).click();
	}
	
	public void homeLoginRevature() {
		String homeLoginRevature = location.getProperty("homeLoginRevature");
		driver.findElement(By.cssSelector("[href=\""+homeLoginRevature+"\"]")).click();
	}

}
