package DA_MP;

import org.testng.annotations.Test;

import helper.Constant;
import testbase.TestBase;

public class TC011_CannotOpenMoreThanOneNewPageDialog extends TestBase{
	/**
	 * DA_MP_TC011
	 * @author lam.tung.nguyen
	 */

	@Test(description = "DA_MP_TC011 - Verify that user is unable open more than 1 'New Page' dialog")
	public void TC011() {
		reportLog("Step 1: Navigate to Dashboard login page");
		goToDashboardLoginPage();

		reportLog("Step 2: Login with valid account");
		loginPage.login(Constant.REPOSITORY, Constant.VALID_USERNAME, Constant.VALID_PASSWORD);
		
		reportLog("Step 3: Go to Global Setting -> Add page");
		
		reportLog("Step 4: Try to go to Global Setting -> Add page again");

		reportLog("VP: User cannot go to Global Setting -> Add page while 'New Page' dialog appears.");
		
	}
}
