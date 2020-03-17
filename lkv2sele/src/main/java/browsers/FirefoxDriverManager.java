package browsers;

import org.openqa.selenium.firefox.FirefoxDriver;

import helper.DriverUtils;
import managers.DriverManager;

public class FirefoxDriverManager extends DriverManager{
	@Override
	public void createWebDriver() {
		System.setProperty("webdriver.gecko.driver", DriverUtils.driverPath + "geckodriver.exe");
		this.driver = new FirefoxDriver(); 
	}

}

