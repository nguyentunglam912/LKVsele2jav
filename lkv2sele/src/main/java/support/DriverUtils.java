package support;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import helper.FileReaderManager;

public class DriverUtils {

	// Get properties from configuation
	public static final String driverPath 	=  FileReaderManager.getInstance().getConfigReader().getDriverPath();
	public static final Long implicityWait 	=  FileReaderManager.getInstance().getConfigReader().getImplicitlyWait();
	public static final Long loadTimeout	=  FileReaderManager.getInstance().getConfigReader().getPageLoadTimeout();
	public static final String url 			=  FileReaderManager.getInstance().getConfigReader().getUrl();
	public static final DriverType browser	=  FileReaderManager.getInstance().getConfigReader().getBrowser();
	
	// Get driver
	public static WebDriver driver;

	// Wait for page load
	public void waitForPageLoad() {
		Wait<WebDriver> wait = new WebDriverWait(driver,loadTimeout);
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver wdriver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
				}
			});
		}
	}
