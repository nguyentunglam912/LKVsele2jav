package com.sele2.driver;

import com.sele2.browsers.ChromeDriverManager;
import com.sele2.browsers.FirefoxDriverManager;
import com.sele2.browsers.RemoteChromeDriverManager;
import com.sele2.browsers.RemoteFirefoxDriverManager;
 
public class DriverManagerFactory {
	public static DriverManager getDriverManager(String browser) {
		DriverManager driverManager;
		switch(browser) {
		case "chrome.local":
			driverManager = new ChromeDriverManager();
			break;
		case "firefox.local":
			driverManager = new FirefoxDriverManager();
			break;
		case "chrome.remote":
			driverManager = new RemoteFirefoxDriverManager();
			break;
		case "firefox.remote":
			driverManager = new RemoteChromeDriverManager();
			break;
		default:
			driverManager = new ChromeDriverManager();
			break;
			}
		return driverManager;
		}
}