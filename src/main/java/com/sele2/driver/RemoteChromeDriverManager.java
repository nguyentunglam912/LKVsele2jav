package com.sele2.driver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import static org.openqa.selenium.chrome.ChromeOptions.CAPABILITY;

import java.net.MalformedURLException;
import java.net.URL;

import com.sele2.driver.DriverManager;
import com.sele2.support.DriverUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RemoteChromeDriverManager extends DriverManager{

	@Override
	public void createWebDriver() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(DriverUtils.hedless);
		DesiredCapabilities capabilities =  DesiredCapabilities.chrome();
        capabilities.setCapability(CAPABILITY, options);
        capabilities.setVersion(DriverUtils.browserVersion);
        try {
			this.driver = new RemoteWebDriver(new URL(DriverUtils.remoteURL), capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

}
