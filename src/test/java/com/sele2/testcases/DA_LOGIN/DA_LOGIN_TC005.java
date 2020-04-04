package com.sele2.testcases.DA_LOGIN;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import com.sele2.support.Constant;
import com.sele2.helper.Log;
import com.sele2.testcases.testbase.TestBase;

import com.sele2.utils.listeners.TestListener;

import io.qameta.allure.Description;

@Listeners({ TestListener.class })
public class DA_LOGIN_TC005 extends TestBase {
	/**
	 * DA_LOGIN_TC005
	 *
	 * @author lam.tung.nguyen
	 */

	@Test
	@Description("Verify that there is no Login dialog when switching between 2 repositories with the same account")
	public void DA_LOGIN_TC005_NoLoginDialogWhenSwitchingAnotherRepo() {
		Log.info("Step 1: Navigate to Dashboard login page");
		goToDashboardLoginPage();

		Log.info("Step 2: Login with valid account for the first repository");
		loginPage.login(Constant.REPOSITORY, Constant.VALID_USERNAME, Constant.VALID_PASSWORD);

		Log.info("Step 3: Choose another repository in Repository list");
		homePage.switchRepository(Constant.REPOSITORY2);

		Log.info("VP: There is no Login Repository dialog");
		Assert.assertNotEquals(homePage.getCurrentPageURL(), Constant.LOGIN_URL);

		Log.info("VP: The Repository menu displays name of switched repository");
		Assert.assertEquals(homePage.getCurrentRepo(), Constant.REPOSITORY2);
	}
}
