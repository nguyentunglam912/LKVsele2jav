package managers;

import browsers.ChromeDriverManager;
import browsers.FirefoxDriverManager;
import support.DriverType;
 
public class DriverManagerFactory {
	public static DriverManager getDriverManager(DriverType type) {
		DriverManager driverManager;
		switch(type) {
		case CHROME:
			driverManager = new ChromeDriverManager();
			break;
		default:
			driverManager = new FirefoxDriverManager();
			break;
			}
		return driverManager;
		}
}