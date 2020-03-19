package DA_LOGIN;

import org.testng.annotations.Test;

import helper.Constant;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testbase.TestBase;

public class DA_LOGIN extends TestBase{
	/**
	 * DA_LOGIN_TC001 - Verify that user can login specific repository successfully via Dashboard login page with correct credentials
	 * @author lam.tung.nguyen
	 */

	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();

	@Test(description = "DA_LOGIN_TC001 - Verify that user can login specific repository successfully via Dashboard login page with correct credentials")
	public void TC001() {
		reportLog("Step 1: Navigate to Dashboard login page");
		goToDashboardLoginPage();

		reportLog("Step 2: Enter valid username and password");
		reportLog("Step 3: Click on Login button");
		loginPage.login(Constant.REPOSITORY, Constant.USERNAME, Constant.PASSWORD);

		reportLog("VP: Verify that Dashboard Mainpage appears");
		loginPage.checkLoginSuccessfully();
	}
}
