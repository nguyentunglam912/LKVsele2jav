package browsers;

import org.openqa.selenium.chrome.ChromeDriver;

import helper.DriverUtils;
import managers.DriverManager;

public class ChromeDriverManager extends DriverManager {

	@Override
	public void createWebDriver() {
		System.setProperty("webdriver.chrome.driver", DriverUtils.driverPath + "chromedriver.exe");
		this.driver = new ChromeDriver(); 
	}

}
