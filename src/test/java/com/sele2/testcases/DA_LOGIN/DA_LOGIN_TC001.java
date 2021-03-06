package com.sele2.testcases.DA_LOGIN;

import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import com.sele2.support.Constant;
import com.sele2.helper.Log;
import com.sele2.testcases.testbase.TestBase;

import io.qameta.allure.*;
import com.sele2.utils.listeners.TestListener;

@Listeners({ TestListener.class })
public class DA_LOGIN_TC001 extends TestBase {
	/**
	 * DA_LOGIN_TC001
	 *
	 * @author lam.tung.nguyen
	 */

	@Test
	@Description("Test Description: Verify that user can login specific repository successfully via Dashboard login page with correct credentials")
	public void DA_LOGIN_TC001_LoginWithCorrectCredentials() {
		Log.info("Step 1: Navigate to Dashboard login page");
		goToDashboardLoginPage();

		Log.info("Step 2: Enter invalid username and password");
		Log.info("Step 3: Click on Login button");
		loginPage.login(Constant.REPOSITORY, Constant.VALID_USERNAME, Constant.VALID_PASSWORD);

		Log.info("VP: Verify that Dashboard Mainpage appears");
		softAssert.assertEquals(homePage.getCurrentPageTitle(), Constant.TA_DASHBOARD_TITLE);
	}
}
