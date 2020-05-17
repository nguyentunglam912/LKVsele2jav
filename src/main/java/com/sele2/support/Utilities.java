package com.sele2.support;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities {
	
	// Wait for page load
	public static void waitForPageLoad() {
		Wait<WebDriver> wait = new WebDriverWait(DriverUtils.driver,DriverUtils.loadTimeout);
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver wdriver) {
				return ((JavascriptExecutor) DriverUtils.driver)
						.executeScript("return document.readyState").equals("complete");
				}
			});
	}
	public static void waitForPageStable() {
		Wait<WebDriver> wait = new WebDriverWait(DriverUtils.driver,DriverUtils.loadTimeout);
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return (Boolean) ((JavascriptExecutor) driver)
        		.executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
			}
	    });
	}

	public static String generateRandomString(int lengh, String str){
		String allowedChars="abcdefghijklmnopqrstuvwxyz" + "1234567890";
	    String randomString = RandomStringUtils.random(lengh, allowedChars);
	    return str + randomString;
	}
}
