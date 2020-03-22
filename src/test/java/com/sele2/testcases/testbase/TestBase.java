package com.sele2.testcases.testbase;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.varia.NullAppender;

import com.sele2.support.DriverUtils;

import io.qameta.allure.Step;

import com.sele2.driver.DriverManagerFactory;


public class TestBase {

	@BeforeClass
	public static void setUp() {
		System.out.println("Pre-condition");
		BasicConfigurator.configure();
		DriverUtils.driver = DriverManagerFactory.getDriverManager(DriverUtils.browser).getWebDriver();
	}

	@AfterClass
	public void tearDown() {
		System.out.println("Post-condition");
		Logger.getRootLogger().removeAllAppenders();
		Logger.getRootLogger().addAppender(new NullAppender());
		DriverUtils.driver.quit();
	}

	@Step("Navigate to Dashboard login page")
	public void goToDashboardLoginPage() {
		DriverUtils.driver.get(DriverUtils.url);
		DriverUtils.driver.manage().window().maximize();
		DriverUtils.driver.manage().timeouts().pageLoadTimeout(DriverUtils.loadTimeout,TimeUnit.SECONDS);
		DriverUtils.driver.manage().timeouts().implicitlyWait(DriverUtils.implicityWait, TimeUnit.SECONDS);
	}
}
