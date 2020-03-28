package com.sele2.driver;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import static org.openqa.selenium.firefox.FirefoxOptions.FIREFOX_OPTIONS;

import java.net.MalformedURLException;
import java.net.URL;

import com.sele2.driver.DriverManager;
import com.sele2.support.DriverUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RemoteFirefoxDriverManager extends DriverManager{

	@Override
	public void createWebDriver() {
		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions options = new FirefoxOptions();
		options.setHeadless(DriverUtils.hedless);
		DesiredCapabilities capabilities =  DesiredCapabilities.firefox();
        capabilities.setCapability(FIREFOX_OPTIONS, options);
        capabilities.setVersion(DriverUtils.browserVersion);
        try {
			this.driver = new RemoteWebDriver(new URL(DriverUtils.remoteURL), capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

}
