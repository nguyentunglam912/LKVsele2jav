package com.sele2.driver;
 
public class DriverManagerFactory {
	public static DriverManager getDriverManager(String type) {
		DriverManager driverManager;
		switch(type) {
		case "chrome.local":
			driverManager = new ChromeDriverManager();
			break;
		case "firefox.local":
			driverManager = new FirefoxDriverManager();
			break;
		case "firefox.remote":
			driverManager = new RemoteFirefoxDriverManager();
			break;
		case "chrome.remote":
			driverManager = new RemoteChromeDriverManager();
			break;
		default:
			driverManager = new ChromeDriverManager();
			break;
			}
		return driverManager;
		}
}