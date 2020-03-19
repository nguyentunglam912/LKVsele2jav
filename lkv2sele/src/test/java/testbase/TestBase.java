package testbase;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import helper.DriverUtils;
import managers.DriverManagerFactory;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.varia.NullAppender;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import managers.DriverManagerFactory;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import helper.DriverUtils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.io.File;
import java.util.concurrent.TimeUnit;


public class TestBase {
	static ExtentReports extent;
	protected static ExtentTest test;
	public static Logger logger = Logger.getLogger("Test");

	public LoginPage loginPage = new LoginPage();
	public HomePage homePage = new HomePage();

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

	@BeforeTest
	public static void startReport() {
		extent = new ExtentReports(System.getProperty("user.dir") +"/test-output/STMExtentReport.html", true);
		extent.loadConfig(new File(System.getProperty("user.dir") + "extent-config.xml")); 
		test = extent.startTest("");
	}

	@AfterMethod
	public void getResult(ITestResult result){
		if(result.getStatus() == ITestResult.FAILURE){
			test.log(LogStatus.FAIL, "Test Case Failed is "+ result.getName());
			test.log(LogStatus.FAIL, "Test Case Failed is "+ result.getThrowable());
			} else if(result.getStatus() == ITestResult.SKIP){
				test.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
				}
		extent.endTest(test);
		}

	@AfterTest
	public void endReport(){
		extent.flush();
		extent.close();
    }

	public void reportLog(String message) {
		 test.log(LogStatus.INFO, message);
		 logger.info("Message: " + message);
		 Reporter.log(message);
	}

	public void goToDashboardLoginPage() {
		DriverUtils.driver.get(DriverUtils.url);
		DriverUtils.driver.manage().window().maximize();
		DriverUtils.driver.manage().timeouts().pageLoadTimeout(DriverUtils.loadTimeout,TimeUnit.SECONDS);
		DriverUtils.driver.manage().timeouts().implicitlyWait(DriverUtils.implicityWait, TimeUnit.SECONDS);
	}
}
