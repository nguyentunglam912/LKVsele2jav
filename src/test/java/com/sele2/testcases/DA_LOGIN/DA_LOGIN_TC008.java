package com.sele2.testcases.DA_LOGIN;

import com.sele2.support.Constant;
import com.sele2.helper.Log;
import com.sele2.testcases.testbase.TestBase;
import com.sele2.utils.listeners.TestListener;

import io.qameta.allure.Description;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ TestListener.class })
public class DA_LOGIN_TC008 extends TestBase {
	/**
	 * DA_LOGIN_TC008
	 *
	 * @author vi.dao
	 */

	@Test
	@Description("Test Description: Verify that password with special characters is working correctly")
	public void DA_LOGIN_TC008_LoginWithPasswordContainSpecialCharacter() {

		Log.info("Step 1: Go to dashboard");
		goToDashboardLoginPage();

		Log.info("Step 2: Login with an account whose password containing special character");
		loginPage.login(Constant.REPOSITORY, Constant.TC008_USERNAME, Constant.TC009_PASSWORD);

		Log.info("VP: Verify main page is displayed");
		softAssert.assertEquals(homePage.getCurrentPageTitle(), Constant.TA_DASHBOARD_TITLE);
		softAssert.assertAll();
	}
}
