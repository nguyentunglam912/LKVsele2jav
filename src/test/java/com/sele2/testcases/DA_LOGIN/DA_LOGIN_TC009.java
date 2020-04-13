package com.sele2.testcases.DA_LOGIN;

import com.sele2.support.Constant;
import com.sele2.helper.Log;
import com.sele2.testcases.testbase.TestBase;
import com.sele2.utils.listeners.TestListener;

import io.qameta.allure.Description;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ TestListener.class })
public class DA_LOGIN_TC009 extends TestBase {
	/**
	 * DA_LOGIN_TC009
	 *
	 * @author vi.dao
	 */

	@Test
	@Description("Test Description: Verify that username with special characters is working correctly")
	public void DA_LOGIN_TC009_LoginWithUsernameContainSpecialCharacter() {

		Log.info("Step 1: Go to dashboard");
		goToDashboardLoginPage();

		Log.info("Step 2: Login with an account whose username containing special character");
		loginPage.login(Constant.REPOSITORY, Constant.TC009_USERNAME, Constant.TC009_PASSWORD);

		Log.info("VP: Verify main page is displayed");
		softAssert.assertEquals(homePage.getCurrentPageTitle(), Constant.TA_DASHBOARD_TITLE);
		softAssert.assertAll();
	}
}
