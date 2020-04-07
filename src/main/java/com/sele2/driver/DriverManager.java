package com.sele2.driver;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
	protected  WebDriver driver;
	protected abstract void createWebDriver();
		
	public void quitDriver() {
		if(this.driver != null) {
			this.driver.quit();
			this.driver = null;
		}
	}
	
	public WebDriver getWebDriver() {
		if(driver == null) {
			this.createWebDriver();
		}
		return driver;
	}
}
