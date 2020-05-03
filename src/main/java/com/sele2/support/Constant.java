package com.sele2.support;

import java.util.ArrayList;

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
	public static final String LOGIN_URL		= "http://5e421106.ngrok.io/TADashboard/login.jsp";
	public static final String CONFIG_PATH		= "\\src\\test\\resources\\Configuration.properties";
	public static final String TA_DASHBOARD_TITLE = "TestArchitect ™";
	public static final String ERROR_MESSAGE_INVALID_USERNAME_OR_PASSWORD = "Username or password is invalid";
	public static final String ERROR_MESSAGE_PLEASE_ENTER_USERNAME = "Please enter username!";

	// Test Data Pages
	private static final String RANDOM_STRING = Utilities.generateRandomString(5,"%s");
	public static final String PAGE_NAME1 = String.format(RANDOM_STRING, "Test1");
	public static final String PAGE_NAME2 = String.format(RANDOM_STRING, "Test2");
	public static final String PAGE_NAME3 = String.format(RANDOM_STRING, "Test3");
	public static final String PAGE_NAME4 = String.format(RANDOM_STRING, "Test4");
	public static final String OVERVIEW_PAGE = "Overview";

	// Test Data Panel
	public static final String PANEL_NAME = String.format(RANDOM_STRING, "Panel");
	public static final String PANEL_NAME1 = String.format(RANDOM_STRING, "Panel1");
	public static final String SERIES = "Name";
	public static final String SERIES1 = "Location";
	public static final String CHART_PANEL = "Action Implementation By Status";

	//Test Data Profiles
	public static final String[] LIST_PRESET_DATAPROFILES = {"Action Implementation By Status", "Test Case Execution", "Test Case Execution Failed Trend", "Test Case Execution History"
			, "Test Case Execution Results", "Test Case Execution Trend" , "Test Module Execution", "Test Module Execution Failure Trend"
			, "Test Module Execution History", "Test Module Execution Results", "Test Module Execution Results Report", "Test Module Execution Trend"
			, "Test Module Implementation By Priority", "Test Module Implementation By Status", "Test Module Status per Assigned Users", "Test Objective Execution"};
}
