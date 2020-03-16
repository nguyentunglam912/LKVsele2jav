package DA_LOGIN;

import org.testng.annotations.Test;

import managers.DriverManager;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testbase.TestBase;

public class DA_LOGIN extends TestBase{
	/**
	 * DA_LOGIN_TC001 - Verify that user can login specific repository successfully via Dashboard login page with correct credentials
	 * @author lam.tung.nguyen
	 */

	DriverManager driverManager;
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();

	@Test(description = "DA_LOGIN_TC001 - Verify that user can login specific repository successfully via Dashboard login page with correct credentials")
	public void TC001() {
		loginPage.login("SampleRepository", "test", "TEST");
		homePage.checkLoginSuccessfully("Execution Dashboard");
	}
}
