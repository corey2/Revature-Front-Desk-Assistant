package com.testing.webdriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GetDriver {
	
	public static Properties getProperties() {
		Properties prop = null;
		File file = null;
		FileInputStream fis = null;
		
		try {
			prop = new Properties();
			file = new File("location.properties");
			fis = new FileInputStream(file);
			prop.load(fis);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		return prop;
	}
	
	public static WebDriver getChrome() {
		File file = new File("C://seleniumDrivers/chromedriver_win32/chromedriver.exe/");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		return new ChromeDriver();
	}
	
	public static WebDriver getFirefox() {
		File file = new File("C://seleniumDrivers/geckodriver-v0.11.1-win32/geckodriver.exe/");
		System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
		return new FirefoxDriver();
	}

}
