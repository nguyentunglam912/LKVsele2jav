package com.sele2.driver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.sele2.driver.DriverManager;
import com.sele2.support.DriverUtils;

public class ChromeDriverManager extends DriverManager {

	@Override
	public void createWebDriver() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions opption = new ChromeOptions();
		opption.setHeadless(DriverUtils.hedless);
		this.driver = new ChromeDriver(opption);
	}
}
