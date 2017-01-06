package com.testing.pageobjects;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AsscFormPage extends RFDAWebPage {

	public AsscFormPage(WebDriver driver) {
		super(driver);
	}

	public void getAssocForm() {
		String asscForm = location.getProperty("assocForm");
		driver.findElement(By.id(asscForm)).click();
	}
	
	public void firstName() {
		String fname = location.getProperty("fname");
		String fnameField = location.getProperty("fnameField");
		driver.findElement(By.name(fnameField)).clear();
		driver.findElement(By.name(fnameField)).sendKeys(fname);
	}
	
	public void lastName() {
		String lname = location.getProperty("lname");
		String lnameField = location.getProperty("lnameField");
		driver.findElement(By.name(lnameField)).clear();
		driver.findElement(By.name(lnameField)).sendKeys(lname);
	}
	
	public void updateGender() {	
		String gender = location.getProperty("assocGender");
		driver.findElement(By.xpath(gender)).click();
	}
	
	public void email() {
		String email = location.getProperty("email");
		String emailfield = location.getProperty("emailField");
		driver.findElement(By.name(emailfield)).clear();
		driver.findElement(By.name(emailfield)).sendKeys(email);
	}
	
	public void address() {
		String addr = location.getProperty("addr");
		String addrField = location.getProperty("addrfield");
		driver.findElement(By.name(addrField)).clear();
		driver.findElement(By.name(addrField)).sendKeys(addr);
	}
	
	public void city() {
		String city = location.getProperty("city");
		String cityField = location.getProperty("cityfield");
		driver.findElement(By.name(cityField)).clear();
		driver.findElement(By.name(cityField)).sendKeys(city);
	}
	
	public void state() {
		String state = location.getProperty("state");
		String stateField = location.getProperty("statefield");
		driver.findElement(By.name(stateField)).clear();
		driver.findElement(By.name(stateField)).sendKeys(state);
	}
	
	public void zipCode() {
		String zip = location.getProperty("zip");
		String zipField = location.getProperty("zipfield");
		driver.findElement(By.name(zipField)).clear();
		driver.findElement(By.name(zipField)).sendKeys(zip);
	}
	
	public void updatePhone() {
		String phoneNum = location.getProperty("phone");
		String phoneNumfield = location.getProperty("phoneNumfield");
		driver.findElement(By.name(phoneNumfield)).clear();
		driver.findElement(By.name(phoneNumfield)).sendKeys(phoneNum);
	}
	
	public void methodOfTran() {
		String methTran = location.getProperty("methTrans");
		driver.findElement(By.xpath(methTran)).click();
	}
	
	public void hasCar() {
		String car = location.getProperty("hasCar");
		driver.findElement(By.xpath(car)).click();
	}
	
	static WebElement datePicker;
	 static List<WebElement> noOfColumns;
	 static List<String> monthList = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
	 // Expected Date, Month and Year
	 static int expMonth;
	 static int expYear;
	 static String expDate = null;
	 // Calendar Month and Year
	 static String calMonth = null;
	 static String calYear = null;
	 static boolean dateNotFound;
	 
	public void selectDate(WebDriver driver, Properties prop, String date)
	 {
	  datePicker = driver.findElement(By.id("ui-datepicker-div")); 
	  noOfColumns=datePicker.findElements(By.tagName("td"));

	  //Loop will rotate till expected date not found.
	  for (WebElement cell: noOfColumns){
	   //Select the date from date picker when condition match.
	   if (cell.getText().equals(date)){
	    cell.findElement(By.linkText(date)).click();
	    break;
	   }
	  }
	 }
	
	public void pickExpDate(WebDriver driver, Properties prop) throws InterruptedException {
		
		  //Click on date text box to open date picker popup.
		  driver.findElement(By.xpath("//input[@id='date']")).click();
		  dateNotFound = true;
		  Thread.sleep(1000);
		  //Set your expected date, month and year.  
		  expDate = "18";
		  expMonth= 11;
		  expYear = 2016;
		  int tmp = 9;
		  String tmpYear = "2016";
		  //This loop will be executed continuously till dateNotFound Is true.
		  while(dateNotFound)
		  { 
		   //Retrieve current selected month name from date picker popup.
		   //calMonth = driver.findElement(By.className("ui-datepicker-month")).getText();
		   calMonth = monthList.get(tmp++); //driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/div/span[1]")).getText();
		   //Retrieve current selected year name from date picker popup.
		   calYear = tmpYear; //driver.findElement(By.className("ui-datepicker-year")).getText();
		   //calYear = driver.findElement(By.xpath("/html/body/div[4]/div/div/span[2]")).getText();
				   
		   //If current selected month and year are same as expected month and year then go Inside this condition.
		   if(monthList.indexOf(calMonth)+1 == expMonth && (expYear == Integer.parseInt(calYear)))
		   {
		    //Call selectDate function with date to select and set dateNotFound flag to false.
		    selectDate(driver, prop, expDate);
		    dateNotFound = false;
		   }
		   //If current selected month and year are less than expected month and year then go Inside this condition.
		   else if(monthList.indexOf(calMonth)+1 < expMonth && (expYear == Integer.parseInt(calYear)) || expYear > Integer.parseInt(calYear))
		   {
		    //Click on next button of date picker.
		    driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/a[2]/span")).click();
		   }
		   //If current selected month and year are greater than expected month and year then go Inside this condition.
		   else if(monthList.indexOf(calMonth)+1 > expMonth && (expYear == Integer.parseInt(calYear)) || expYear < Integer.parseInt(calYear))
		   {
		    //Click on previous button of date picker.
		    driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/a[1]/span")).click();
		   }
		  }
		  Thread.sleep(3000);
	
	}
	
	public void arrivalDate(WebDriver driver, Properties prop) throws InterruptedException {
		pickExpDate(driver, prop);
		//String arrivalDate = location.getProperty("arrivalDate");
		//driver.findElement(By.id(arrivalDate)).click();
		
		//driver.findElement(By.linkText("next")).click(); //click next month
		//driver.findElement(By.linkText("28")).click(); //click day
		//Thread.sleep(1000);
					
		// WebElement nextLink = driver.findElement(By.xpath("//div[@id='ui-datepicker-div']//div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-all']//a[contains(@class,'ui-datepicker-next ui-corner-all')]"));
		// nextLink.click();
		//String calendar = location.getProperty("calendar");
		//driver.findElement(By.xpath(calendar)).click();
		//String selectDate = location.getProperty("selectDate");
		//driver.findElement(By.xpath(selectDate)).click();
		
	}
	
	public void submit(WebDriver driver, Properties prop) {
		String send = location.getProperty("assocSubmit");
		driver.findElement(By.name(send)).click();
	}
	
	public void returnHome(WebDriver driver, Properties prop) {
		driver.findElement(By.name("Home")).click();
	}
}
