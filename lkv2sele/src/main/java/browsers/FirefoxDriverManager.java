package browsers;

import org.openqa.selenium.firefox.FirefoxDriver;

import helper.FileReaderManager;
import managers.DriverManager;

public class FirefoxDriverManager extends DriverManager{
	@Override
	public void createWebDriver() {
		String driverPath =  FileReaderManager.getInstance().getConfigReader().getDriverPath();
		System.setProperty("webdriver.gecko.driver", driverPath);	
		this.driver = new FirefoxDriver(); 
	}

}

