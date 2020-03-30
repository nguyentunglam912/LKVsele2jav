package com.sele2.driver;

import static org.openqa.selenium.chrome.ChromeOptions.CAPABILITY;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.sele2.driver.DriverManager;
import com.sele2.support.DriverUtils;

public class ChromeDriverManager extends DriverManager {

	@Override
	public void createWebDriver() {
		WebDriverManager.chromedriver().setup();
		final DesiredCapabilities capabilities =  DesiredCapabilities.chrome();
		capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
		final ChromeOptions opption = new ChromeOptions();
		opption.setHeadless(DriverUtils.hedless);
		capabilities.setCapability(CAPABILITY, opption);
		this.driver = new ChromeDriver(capabilities);
	}
}
