package com.sele2.support;

public class Constant {
	public static final String VALID_USERNAME 	= "test";
	public static final String VALID_PASSWORD 	= "TEST";
	public static final String INVALID_USERNAME = "abc";
	public static final String INVALID_PASSWORD = "abc";
	public static final String BLANK_USERNAME 	= "";
	public static final String BLANK_PASSWORD 	= "";
	public static final String REPOSITORY 		= "SampleRepository";
	public static final String CONFIG_PATH		= "\\src\\main\\java\\com\\sele2\\helper\\Configuration.properties";
	public static final String ERROR_MESSAGE_INVALID_USERNAME_OR_PASSWORD = "Username or password is invalid";
	public static final String ERROR_MESSAGE_PLEASE_ENTER_USERNAME = "Please enter username!";

	// Test data
	public static final String NULL	= null;
	private static final String randomString = Utilities.generateRandomString(5,"%s");
	public static final String PAGE_NAME1 = String.format(randomString, "Test1");
	public static final String PAGE_NAME2 = String.format(randomString, "Test2");
	public static final String OVERVIEW_PAGE = "Overview";
}
