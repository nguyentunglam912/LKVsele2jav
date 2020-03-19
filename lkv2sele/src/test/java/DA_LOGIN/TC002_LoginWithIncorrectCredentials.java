package DA_LOGIN;

import org.testng.annotations.Test;

import support.Constant;
import testbase.TestBase;

public class TC002_LoginWithIncorrectCredentials extends TestBase{
	/**
	 * DA_LOGIN_TC002 - Verify that user fails to login specific repository successfully via Dashboard login page with incorrect credentials
	 * @author lam.tung.nguyen
	 */

	@Test(description = "DA_LOGIN_TC002 - Verify that user fails to login specific repository successfully via Dashboard login page with incorrect credentials")
	public void TC002() {
		reportLog("Step 1: Navigate to Dashboard login page");
		goToDashboardLoginPage();

		reportLog("Step 2: Enter invalid username and password");
		reportLog("Step 3: Click on Login button");
		loginPage.login(Constant.REPOSITORY, Constant.INVALID_USERNAME, Constant.INVALID_PASSWORD);

		reportLog("VP: Verify that Dashboard Error message 'Username or password is invalid' appears");
		loginPage.checkLoginErrorMessage();
	}
}