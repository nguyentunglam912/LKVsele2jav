package com.sele2.support;

public class Constant {
	public static final String VALID_USERNAME 	= "test";
	public static final String VALID_PASSWORD 	= "TEST";
	public static final String UPPERCASE_USERNAME  = "TEST";
	public static final String LOWERCASE_PASSWORD    = "test";
	public static final String INVALID_USERNAME = "abc";
	public static final String INVALID_PASSWORD = "abc";
	public static final String BLANK_USERNAME 	= "";
	public static final String BLANK_PASSWORD 	= "";
	public static final String TC008_USERNAME = "tc008";
	public static final String TC008_PASSWORD = "p@ssw0rd";
	public static final String TC009_USERNAME = "tc009!";
	public static final String TC009_PASSWORD = "taadmin";
	public static final String REPOSITORY 		= "SampleRepository";
	public static final String REPOSITORY2      = "SampleRepositoryLV2";
	public static final String CONFIG_PATH		= "\\src\\main\\java\\com\\sele2\\helper\\Configuration.properties";
	public static final String TA_DASHBOARD_TITLE = "TestArchitect ™";
	public static final String ERROR_MESSAGE_INVALID_USERNAME_OR_PASSWORD = "Username or password is invalid";
	public static final String ERROR_MESSAGE_PLEASE_ENTER_USERNAME = "Please enter username!";

	// Test Data Pages
	private static final String RANDOM_STRING = Utilities.generateRandomString(5,"%s");
	public static final String PAGE_NAME1 = String.format(RANDOM_STRING, "Test1");
	public static final String PAGE_NAME2 = String.format(RANDOM_STRING, "Test2");
	public static final String OVERVIEW_PAGE = "Overview";

	// Test Data Panel
	public static final String PANEL_NAME = String.format(RANDOM_STRING, "Panel");
	public static final String SERIES = "Name";
}
