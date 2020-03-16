package testbase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import enums.DriverType;
import helper.FileReaderManager;
import managers.DriverManager;
import managers.DriverManagerFactory;

public class TestBase {

	DriverManager driverManager;
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		Long implicityWait =  FileReaderManager.getInstance().getConfigReader().getImplicitlyWait();
		Long loadTimeout =  FileReaderManager.getInstance().getConfigReader().getPageLoadTimeout();
		String url =  FileReaderManager.getInstance().getConfigReader().getUrl();
		DriverType browser =  FileReaderManager.getInstance().getConfigReader().getBrowser();
		System.out.println("Pre-condition");
		BasicConfigurator.configure();
		driverManager = DriverManagerFactory.getDriverManager(browser);
		driver = driverManager.getWebDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(loadTimeout,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(implicityWait, TimeUnit.SECONDS);
		driver.get(url);
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
