package browsers;

import org.openqa.selenium.chrome.ChromeDriver;

import helper.FileReaderManager;
import managers.DriverManager;

public class ChromeDriverManager extends DriverManager {

	@Override
	public void createWebDriver() {
		String driverPath =  FileReaderManager.getInstance().getConfigReader().getDriverPath();
		System.setProperty("webdriver.chrome.driver", driverPath);	
		this.driver = new ChromeDriver(); 
	}

}
