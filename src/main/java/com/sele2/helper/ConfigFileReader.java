package com.sele2.helper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.sele2.support.Constant;
 
public class ConfigFileReader { 
	private Properties properties;
	private final String propertyFilePath= System.getProperty("user.dir") + Constant.CONFIG_PATH;
 
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
 
	public String getBrowser() {
		return properties.getProperty("browser");
	}
	
	public Long getPageLoadTimeout(){
		String pageLoadTimeout = properties.getProperty("pageLoadTimeout");
		return Long.parseLong(pageLoadTimeout);
		}

	public Boolean getHeadless(){
		String headless = properties.getProperty("headless");
		return Boolean.parseBoolean(headless);
		}

	public String getRemoteURL(){
		String remoteURL = properties.getProperty("remoteURL");
		return remoteURL;
		}
	
	public String getBrowserVersion(){
		String browserVersion = properties.getProperty("browserVersion");
		return browserVersion;
		}

	}