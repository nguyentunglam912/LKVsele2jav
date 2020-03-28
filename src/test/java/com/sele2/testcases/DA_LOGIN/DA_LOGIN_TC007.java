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

public class DA_LOGIN_TC007 extends TestBase {
	/**
	 * DA_LOGIN_TC007
	 * @author khang.ha
	 */

	@Test
    @Description("Test Description: Verify that Username is not case sensitive")
	public void DA_LOGIN_TC007_UsernameNotCaseSensitive() {
		Log.info("Step 1: Navigate to Dashboard login page");
		goToDashboardLoginPage();
		
		Log.info("Step 2: Login with the account has uppercase username");
		loginPage.login(Constant.REPOSITORY, Constant.UPPERCASE_USERNAME, Constant.VALID_PASSWORD);

		Log.info("VP: Verify that Dashboard Mainpage appears");
		Assert.assertEquals(homePage.getCurrentPageTitle(), Constant.TA_DASHBOARD_TITLE);
		
		Log.info("Step 3: Logout TA Dashboard");
		homePage.logOut();

		Log.info("Step 4: Login with the above account but enter lowercase username");
		loginPage.login(Constant.REPOSITORY, Constant.VALID_USERNAME, Constant.VALID_PASSWORD);

		Log.info("VP: Verify that Dashboard Mainpage appears");
		Assert.assertEquals(homePage.getCurrentPageTitle(), Constant.TA_DASHBOARD_TITLE);
		}
	}
