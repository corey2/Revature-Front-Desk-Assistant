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
//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class RFDATest {
	
	private WebDriver webDriver;
	private EventFiringWebDriver driver;
	private EventListener eventListener;
	private Properties location;
	
	@Test(priority=0)
	public void homeTest() throws InterruptedException {  //Tests all three buttons on the home page.
		HomePage homepage = new HomePage(driver);
		homepage.homeLogin("homeLogin");
		Assert.assertEquals(driver.getTitle(), location.getProperty("loginPg"));
		driver.navigate().back();
		homepage.homeLoginNB("homeLoginNB");
		Assert.assertEquals(driver.getTitle(), location.getProperty("loginPg"));
		driver.navigate().back();
		homepage.homeLoginRevature("homeLoginRevature");
		Assert.assertEquals(driver.getTitle(), location.getProperty("loginPg"));
		//driver.navigate().back();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	
	@Test(priority=1)
	public void loginAdminTest() throws InterruptedException {	
		LoginPage loginpage = new LoginPage(driver);
		loginpage.inputUsername("usernameField", "adminUsername");
		loginpage.inputPassword("passwordField", "adminPassword");
		loginpage.login("login");
		Assert.assertEquals(driver.getTitle(), location.getProperty("adminPg"));	
	}
	
	
	@Test(priority=2)
	public void adminPageTest() throws InterruptedException {
		AdminPage adminpage = new AdminPage(driver);
		adminpage.enterDashbd("adminDB");
		Assert.assertEquals(driver.getTitle(), location.getProperty("dashPg"));
		driver.navigate().back();
		adminpage.enterSearch("search");
		Assert.assertEquals(driver.getTitle(), location.getProperty("searchPg"));
		driver.navigate().back();
		adminpage.enterCreate("create");
		Assert.assertEquals(driver.getTitle(), location.getProperty("createPg"));
		driver.navigate().back();
		adminpage.enterUpdate("update");
		Assert.assertEquals(driver.getTitle(), location.getProperty("updatePg"));
		driver.navigate().back();
		adminpage.enterChangePassword("changePassword");
		Assert.assertEquals(driver.getTitle(), location.getProperty("changePasswordPg"));
		driver.navigate().back();
	}
	
	//@Test(priority=3)
	//public void adminDashboardTest() throws InterruptedException {
	//}
	
	
	@Test(priority=4)
	public void addAssociate() throws InterruptedException {
		AddUserPage aup = new AddUserPage(driver);
		aup.username("addUsernameField", "steven");
		aup.firstName("addFnameField", "Scott");
		aup.lastName("addLnameField", "West");
		aup.email("addEmailField", "guxcd@yahoo.com");
		aup.submit();
		aup.successfulSentEmail();
		aup.logOut();
		aup.logOutSuccess();
		//Log back in
		//HomePage.homeLoginNB();
		//HomePage.verifyLogin();
		//log in as admin
		//LoginAdminPage.inputUsername();
		//LoginAdminPage.inputPassword();
		//LoginAdminPage.login();
		//LoginAdminPage.verifyLogin();	
		//HomePage.returnHome();
	}

	/*
	@Test(priority=5)
	public void updateAssoc() throws InterruptedException {
		UpdateAssocPage.enterUpdateAssoc();
		UpdateAssocPage.enterUserName();
		UpdateAssocPage.firstName();
		UpdateAssocPage.lastName();
		UpdateAssocPage.updateGender();
		UpdateAssocPage.email();
		UpdateAssocPage.address();
		UpdateAssocPage.city();
		UpdateAssocPage.state();
		UpdateAssocPage.zipCode();
		UpdateAssocPage.updatePhone();
		UpdateAssocPage.methodOfTran();
		UpdateAssocPage.hasCar();
		UpdateAssocPage.arrivalDate();
		UpdateAssocPage.submit();
		UpdateAssocPage.successfulUpdate();
	}
	
	@Test(priority=6)
	public void searchAssociate() throws InterruptedException{
		
		SearchAssociate.enterSearchAssoc();
		SearchAssociate.firstNameSearch();
		SearchAssociate.lastNameSearch();
		SearchAssociate.submitSearch();
		SearchAssociate.searchUpdate();
		SearchAssociate.updateHomeNavBar();
		SearchAssociate.searchLogOut();
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
	  webDriver = GetDriver.getChrome();
	  //driver = GetDriver.getFirefox();
	  location = GetDriver.getProperties("location.properties");
	  
	  driver = new EventFiringWebDriver(webDriver);
	  eventListener = new EventListener();
	  driver.register(eventListener);
	  
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