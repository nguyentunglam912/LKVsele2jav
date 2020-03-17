package helper;

import org.openqa.selenium.WebDriver;

import enums.DriverType;

public class DriverUtils {

	// Get properties from configuation
	public static final String driverPath 	=  FileReaderManager.getInstance().getConfigReader().getDriverPath();
	public static final Long implicityWait 	=  FileReaderManager.getInstance().getConfigReader().getImplicitlyWait();
	public static final Long loadTimeout	=  FileReaderManager.getInstance().getConfigReader().getPageLoadTimeout();
	public static final String url 			=  FileReaderManager.getInstance().getConfigReader().getUrl();
	public static final DriverType browser	=  FileReaderManager.getInstance().getConfigReader().getBrowser();
	
	// Get driver
	public static WebDriver driver;
}
