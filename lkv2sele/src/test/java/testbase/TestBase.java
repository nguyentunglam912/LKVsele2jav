package testbase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import managers.DriverManager;
import managers.DriverManagerFactory;
import pageObjects.LoginPage;
import helper.DriverUtils;

public class TestBase {
	public WebDriver driver;
	DriverManager driverManager;
	LoginPage LoginPage = new LoginPage();

	@BeforeClass
	public void setUp() {
		System.out.println("Pre-condition");
		BasicConfigurator.configure();
		DriverUtils.driver = DriverManagerFactory.getDriverManager(DriverUtils.browser).getWebDriver();
		DriverUtils.driver.get(DriverUtils.url);
		DriverUtils.driver.manage().window().maximize();
		DriverUtils.driver.manage().timeouts().pageLoadTimeout(DriverUtils.loadTimeout,TimeUnit.SECONDS);
		DriverUtils.driver.manage().timeouts().implicitlyWait(DriverUtils.implicityWait, TimeUnit.SECONDS);
	}

	/*
	@AfterClass
	public void tearDown() {
		System.out.println("Post-condition");
		driverManager.quitDriver();
	}
	*/

	public static final Logger log = Logger.getLogger(TestBase.class.getName());
}
