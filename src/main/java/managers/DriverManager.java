package managers;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
	protected  WebDriver driver;
	protected abstract void createWebDriver();
		
	public void quitDriver() {
		if(driver != null) {
			driver.quit();
			driver = null;
		}
	}
	
	public WebDriver getWebDriver() {
		if(driver == null) {
			createWebDriver();
		}
		return driver;
	}
}