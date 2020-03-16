package helper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import enums.DriverType;
 
public class ConfigFileReader { 
	private Properties properties;
	private final String propertyFilePath= "D:\\auto\\LKVsele2jav\\lkv2sele\\src\\main\\java\\configs\\Configuration.properties";
 
	public ConfigFileReader(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
				} catch (IOException e) {
					e.printStackTrace();
					}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
				} 
		}
	
	public String getDriverPath(){
		String driverPath = properties.getProperty("driverPath");
		return driverPath;
		}
 
	public long getImplicitlyWait() { 
		String implicitlyWait = properties.getProperty("implicitlyWait");
		return Long.parseLong(implicitlyWait);
		}
 
	public String getUrl() {
		String url = properties.getProperty("url");
		return url;
		}
 
	public DriverType getBrowser() {
		String browserName = properties.getProperty("browser");
		if(browserName == null || browserName.equals("chrome")) return DriverType.CHROME;
		else return DriverType.FIREFOX;
	}
	
	public Long getPageLoadTimeout(){
		String pageLoadTimeout = properties.getProperty("pageLoadTimeout");
		return Long.parseLong(pageLoadTimeout);
		}

	}