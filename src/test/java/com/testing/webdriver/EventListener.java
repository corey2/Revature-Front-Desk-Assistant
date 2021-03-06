package com.testing.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.*;

//Activates thread sleeping after certain WebDriver methods so that tests are easier to follow by humans
public class EventListener extends AbstractWebDriverEventListener {

	@Override
	public void afterNavigateBack(WebDriver driver) {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
