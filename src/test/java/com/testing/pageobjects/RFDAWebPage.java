package com.testing.pageobjects;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.testing.webdriver.GetDriver;

public class RFDAWebPage {
	protected WebDriver driver = null;
	protected Properties location = null;
	protected Properties input = null;
	
	public RFDAWebPage(WebDriver driver) {
		this.driver = driver;
		this.location = GetDriver.getProperties("location.properties");
		this.input = GetDriver.getProperties("input.properties");
	}
	
	
	
}
