package com.sele2.browsers;

import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.sele2.driver.DriverManager;

public class FirefoxDriverManager extends DriverManager{
	@Override
	public void createWebDriver() {
		WebDriverManager.firefoxdriver().setup();
		this.driver = new FirefoxDriver(); 
	}
}

