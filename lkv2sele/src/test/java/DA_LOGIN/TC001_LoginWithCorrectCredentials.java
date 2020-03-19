package DA_LOGIN;

import org.testng.annotations.Test;

import helper.Constant;
import testbase.TestBase;

public class TC001_LoginWithCorrectCredentials extends TestBase{
	/**
	 * DA_LOGIN_TC001
	 * @author lam.tung.nguyen
	 */

	@Test(description = "DA_LOGIN_TC001 - Verify that user can login specific repository successfully via Dashboard login page with correct credentials")
	public void TC001() {
		reportLog("Step 1: Navigate to Dashboard login page");
		goToDashboardLoginPage();

		reportLog("Step 2: Enter valid username and password");
		reportLog("Step 3: Click on Login button");
		loginPage.login(Constant.REPOSITORY, Constant.VALID_USERNAME, Constant.VALID_PASSWORD);

		reportLog("VP: Verify that Dashboard Mainpage appears");
		loginPage.checkLoginSuccessfully();
	}
}
