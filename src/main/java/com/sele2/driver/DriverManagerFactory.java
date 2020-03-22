package com.sele2.driver;

import com.sele2.browsers.ChromeDriverManager;
import com.sele2.browsers.FirefoxDriverManager;
import com.sele2.browsers.RemoteChromeDriverManager;
import com.sele2.browsers.RemoteFirefoxDriverManager;
import com.sele2.support.DriverType;
 
public class DriverManagerFactory {
	public static DriverManager getDriverManager(DriverType type) {
		DriverManager driverManager;
		switch(type) {
		case CHROME:
			driverManager = new ChromeDriverManager();
			break;
		case FIREFOX:
			driverManager = new FirefoxDriverManager();
			break;
		case REMOTE_FIREFOX:
			driverManager = new RemoteFirefoxDriverManager();
			break;
		case REMOTE_CHROME:
			driverManager = new RemoteChromeDriverManager();
			break;
		default:
			driverManager = new ChromeDriverManager();
			break;
			}
		return driverManager;
		}
}