package com.sele2.driver;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.sele2.driver.DriverManager;
import com.sele2.support.DriverUtils;

public class ChromeDriverManager extends DriverManager {

	@Override
	public void createWebDriver() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions opptions = new ChromeOptions();
		opptions.setHeadless(DriverUtils.hedless);
		opptions.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
		this.driver = new ChromeDriver(opptions);
	}
}
