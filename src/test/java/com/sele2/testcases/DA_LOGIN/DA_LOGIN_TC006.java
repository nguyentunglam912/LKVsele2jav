package com.sele2.testcases.DA_LOGIN;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import com.sele2.support.Constant;
import com.sele2.helper.Log;
import com.sele2.testcases.testbase.TestBase;

import io.qameta.allure.*;
import com.sele2.utils.listeners.TestListener;

@Listeners({ TestListener.class })
public class DA_LOGIN_TC006 extends TestBase {
	/**
	 * DA_LOGIN_TC006
	 * @author khang.ha
	 */

	@Test
    @Description("Test Description: Verify that Password input is case sensitive")
	public void DA_LOGIN_TC006_PwdInputCaseSensitive() {
		Log.info("Step 1: Navigate to Dashboard login page");
		goToDashboardLoginPage();

		Log.info("Step 2: Login with the account has uppercase password");
		loginPage.login(Constant.REPOSITORY, Constant.VALID_USERNAME, Constant.VALID_PASSWORD);

		Log.info("VP: Verify that Dashboard Mainpage appears");
		Assert.assertEquals(homePage.getCurrentPageTitle(), Constant.TA_DASHBOARD_TITLE);;

		Log.info("Step 3: Logout TA Dashboard");
		homePage.logOut();

		Log.info("Step 4: Login with the above account but enter lowercase password");
		loginPage.login(Constant.REPOSITORY, Constant.VALID_USERNAME, Constant.LOWERCASE_PASSWORD);

		Log.info("VP: Verify that Dashboard Error message 'Username or password is invalid' appears");
		Assert.assertEquals(loginPage.getLoginErrorMessage(), Constant.ERROR_MESSAGE_INVALID_USERNAME_OR_PASSWORD);
	}
}
