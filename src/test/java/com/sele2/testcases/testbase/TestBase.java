package com.sele2.testcases.testbase;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.varia.NullAppender;

import com.sele2.support.DriverUtils;
import com.sele2.support.Constant;

import io.qameta.allure.Step;

import com.sele2.driver.DriverManagerFactory;
import com.sele2.pages.GeneralPage;


public class TestBase {
	GeneralPage GeneralPage = new GeneralPage();

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
//		DriverUtils.driver.quit();
	}

//	@AfterMethod(groups = "DA_MP_12")
//	public void deleteTestPages() {
//		GeneralPage.deletePage(Constant.PAGE_NAME1);
//	}
	@Step("Navigate to Dashboard login page")
	public void goToDashboardLoginPage() {
		DriverUtils.driver.get(DriverUtils.url);
		DriverUtils.driver.manage().window().maximize();
		DriverUtils.driver.manage().timeouts().pageLoadTimeout(DriverUtils.loadTimeout,TimeUnit.SECONDS);
		DriverUtils.driver.manage().timeouts().implicitlyWait(DriverUtils.implicityWait, TimeUnit.SECONDS);
	}
}
