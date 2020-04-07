package com.sele2.driver;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.sele2.driver.DriverManager;
import com.sele2.support.DriverUtils;

public class FirefoxDriverManager extends DriverManager{
	@Override
	public void createWebDriver() {
		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions options = new FirefoxOptions();
		options.setHeadless(DriverUtils.hedless);
		options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
		this.driver = new FirefoxDriver(options);
	}
}

