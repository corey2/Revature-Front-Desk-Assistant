package com.testing.test;

import org.testng.annotations.Test;

import com.testing.pageobjects.LoginPage;
import com.testing.pageobjects.*;
import com.testing.webdriver.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class RFDATest {
	
	private WebDriver driver = null;
	private Properties location = null;
	private Properties input = null;
	
	@Test(priority=0)
	public void homeTest() throws InterruptedException {  //Tests all three buttons on the home page.
		HomePage homepage = new HomePage(driver);
		Thread.sleep(1000);
		homepage.homeLogin();
		Assert.assertEquals(driver.getTitle(), location.getProperty("loginPg"));
		driver.navigate().back();
		Thread.sleep(1000);
		homepage.homeLoginNB();
		Assert.assertEquals(driver.getTitle(), location.getProperty("loginPg"));
		driver.navigate().back();
		Thread.sleep(1000);
		homepage.homeLoginRevature();
		Assert.assertEquals(driver.getTitle(), location.getProperty("loginPg"));
		//driver.navigate().back();
		Thread.sleep(1000);
		//Thread.sleep(800);
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	
	@Test(priority=1)
	public void loginAdminTest() throws InterruptedException {	
		LoginPage loginpage = new LoginPage(driver);
		Thread.sleep(1000);
		loginpage.inputUsername("usernameField", "adminUsername");
		loginpage.inputPassword("passwordField", "adminPassword");
		Thread.sleep(1000);
		loginpage.login("login");
		Thread.sleep(1000);
		Assert.assertEquals(driver.getTitle(), location.getProperty("adminPg"));	
	}
	
	
	@Test(priority=2)
	public void adminPageTest() throws InterruptedException {
		AdminPage adminpage = new AdminPage(driver);
		Thread.sleep(1000);
		adminpage.enterAdminDashbd("adminDB");
		Thread.sleep(1000);
		Assert.assertEquals(driver.getTitle(), location.getProperty("dashPg"));
	}
	
	/*
	@Test(priority=3)
	public void updateAssoc() throws InterruptedException {
		Thread.sleep(3000);
		UpdateAssocPage.enterUpdateAssoc(driver, prop);
		Thread.sleep(1000);
		UpdateAssocPage.enterUserName(driver, prop);
		UpdateAssocPage.firstName(driver, prop);
		UpdateAssocPage.lastName(driver, prop);
		UpdateAssocPage.updateGender(driver, prop);
		UpdateAssocPage.email(driver, prop);
		UpdateAssocPage.address(driver, prop);
		UpdateAssocPage.city(driver, prop);
		UpdateAssocPage.state(driver, prop);
		UpdateAssocPage.zipCode(driver, prop);
		UpdateAssocPage.updatePhone(driver, prop);
		UpdateAssocPage.methodOfTran(driver, prop);
		UpdateAssocPage.hasCar(driver, prop);
		Thread.sleep(1000);
		UpdateAssocPage.arrivalDate(driver, prop);
		Thread.sleep(1000);
		UpdateAssocPage.submit(driver, prop);
		Thread.sleep(2000);
		UpdateAssocPage.successfulUpdate(driver, prop);
	}
	
	@Test(priority=4)
	public void addAssociate() throws InterruptedException {
		Thread.sleep(2000);
		AddAssociate.enterAddAssoc(driver, prop);
		Thread.sleep(2000);
		AddAssociate.addUserName(driver, prop);
		AddAssociate.firstName(driver, prop);
		AddAssociate.lastName(driver, prop);
		AddAssociate.email(driver, prop);
		AddAssociate.submit(driver, prop);
		Thread.sleep(2000);
		AddAssociate.successfulSentEmail(driver, prop);
		Thread.sleep(2000);
		AddAssociate.logOut(driver, prop);
		Thread.sleep(2000);
		AddAssociate.logOutSuccess(driver, prop);
		//Log back in
		Thread.sleep(3000);
		//HomePage.homeLoginNB(driver, prop);
		//HomePage.verifyLogin(driver, prop);
		//log in as admin
		Thread.sleep(2000);
		LoginAdminPage.inputUsername(driver, prop);
		LoginAdminPage.inputPassword(driver, prop);
		Thread.sleep(2000);
		LoginAdminPage.login(driver, prop);
		Thread.sleep(2000);
		LoginAdminPage.verifyLogin(driver, prop);	
		//HomePage.returnHome(driver, prop);
	}
	
	@Test(priority=5)
	public void searchAssociate() throws InterruptedException{
		
		Thread.sleep(2000);
		SearchAssociate.enterSearchAssoc(driver, prop);
		Thread.sleep(2000);
		SearchAssociate.firstNameSearch(driver, prop);
		SearchAssociate.lastNameSearch(driver, prop);
		SearchAssociate.submitSearch(driver, prop);
		Thread.sleep(2000);
		SearchAssociate.searchUpdate(driver, prop);
		Thread.sleep(1000);
		SearchAssociate.updateHomeNavBar(driver, prop);
		Thread.sleep(1000);
		SearchAssociate.searchLogOut(driver, prop);
	}
	*/
	 
	
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
  
  @BeforeClass
  public void beforeClass() {
	  driver = GetDriver.getChrome();
	  //driver = GetDriver.getFirefox();
	  location = GetDriver.getProperties("location.properties");
	  input = GetDriver.getProperties("input.properties");
	  driver.get(location.getProperty("url"));	   //retrieve the url from properties file location.properties
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

}