/*package com.testing.test;

import org.testng.annotations.Test;
import com.testing.pageobjects.*;
import com.testing.webdriver.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class RFDAUser {

	private WebDriver driver = null;
	private Properties prop = null;

	@Test(priority = 0)
	public void loginAdminNavBar() throws InterruptedException {
		Thread.sleep(600);
		HomePage.homeLoginNB(driver, prop);
		HomePage.verifyLogin(driver, prop);
	}

	@Test(priority = 1)
	public void loginUser() throws InterruptedException {
		Thread.sleep(600);
		LoginUserPage.inputUsername(driver, prop);
		LoginUserPage.inputPassword(driver, prop);
		Thread.sleep(1000);
		LoginUserPage.login(driver, prop);
		LoginUserPage.verifyLogin(driver, prop);
	}

	@Test(priority = 2)
	public void associateForm() throws InterruptedException {
		Thread.sleep(2000);
		AsscFormPage.getAssocForm(driver, prop);
		Thread.sleep(2000);
		AsscFormPage.firstName(driver, prop);
		Thread.sleep(800);
		AsscFormPage.lastName(driver, prop);
		Thread.sleep(800);
		AsscFormPage.updateGender(driver, prop);
		Thread.sleep(800);
		AsscFormPage.email(driver, prop);
		Thread.sleep(800);
		AsscFormPage.address(driver, prop);
		Thread.sleep(800);
		AsscFormPage.city(driver, prop);
		Thread.sleep(800);
		AsscFormPage.state(driver, prop);
		Thread.sleep(800);
		AsscFormPage.zipCode(driver, prop);
		Thread.sleep(800);
		AsscFormPage.updatePhone(driver, prop);
		Thread.sleep(800);
		AsscFormPage.methodOfTran(driver, prop);
		Thread.sleep(800);
		AsscFormPage.hasCar(driver, prop);
		Thread.sleep(1000);
		//AsscFormPage.arrivalDate(driver, prop);
		Thread.sleep(10000);
		AsscFormPage.submit(driver, prop);
		Thread.sleep(4000);
		AsscFormPage.returnHome(driver, prop);
		Thread.sleep(2000);
	}
	
	
	@Test(priority = 3)
	public void contactHR() throws InterruptedException {		
		ContactHRPage.clickContactHR(driver, prop);
		Thread.sleep(2000);
		ContactHRPage.inputSubject(driver, prop);
		Thread.sleep(1000);
		ContactHRPage.inputMessage(driver, prop);
		Thread.sleep(1000);
		// ContactHRPage.reset(driver, prop);
		ContactHRPage.send(driver, prop);
		Thread.sleep(2000);
		ContactHRPage.returnHome(driver, prop);
		Thread.sleep(1000);
	}

	@Test(priority = 4)
	public void emergencyContact() throws InterruptedException {
		EmergencyContact.clickEmergContacts(driver, prop);
		Thread.sleep(1000);
		EmergencyContact.returnHome(driver, prop);
		Thread.sleep(1000);
	}

	@Test(priority = 5)
	public void i9Form() throws InterruptedException {
		i9Form.clickI9Form(driver, prop);
		Thread.sleep(1000);
		i9Form.returnHome(driver, prop);
		Thread.sleep(1000);
	}
	
	@Test(priority = 6)
	public void logout() throws InterruptedException{
		AssociateLogout.logout(driver, prop);
		Thread.sleep(2000);
		AssociateLogout.logoutSuccess(driver, prop);
	}

	@BeforeMethod
	public void beforeMethod() {
	}

	@AfterMethod
	public void afterMethod() {
	}

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { 1, "a" }, new Object[] { 2, "b" }, };
	}

	@BeforeClass
	public void beforeClass() {
		// using the chromeDriver
		prop = GetDriver.getProperties();
		driver = GetDriver.getFirefox();
		// retrieve the url from properties file location.properties
		driver.get(prop.getProperty("url"));
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
	}

	@BeforeSuite
	public void beforeSuite() {
	}

	@AfterSuite
	public void afterSuite() {
	}
}*/