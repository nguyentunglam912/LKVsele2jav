package com.sele2.support;

import org.openqa.selenium.WebDriver;

import com.sele2.helper.FileReaderManager;

public class DriverUtils {

	// Get properties from configuation
	public static final String driverPath 	=  FileReaderManager.getInstance().getConfigReader().getDriverPath();
	public static final Long implicityWait 	=  FileReaderManager.getInstance().getConfigReader().getImplicitlyWait();
	public static final Long loadTimeout	=  FileReaderManager.getInstance().getConfigReader().getPageLoadTimeout();
	public static final String url 			=  FileReaderManager.getInstance().getConfigReader().getUrl();
	public static String browser		=  FileReaderManager.getInstance().getConfigReader().getBrowser();
	public static final String browserVersion 	=  FileReaderManager.getInstance().getConfigReader().getBrowserVersion();
	public static Boolean hedless 			=  FileReaderManager.getInstance().getConfigReader().getHeadless();
	public static final String remoteURL 	=  FileReaderManager.getInstance().getConfigReader().getRemoteURL();
	
	// Get driver
	public static WebDriver driver;
}
