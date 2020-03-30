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
public class DA_LOGIN_TC005 extends TestBase {

	/**
	 * DA_LOGIN_TC005
	 * @author khang.ha
	 */

	@Test
    @Description("Test Description: Verify that user is able to log in different repositories successfully after logging out current repository")
	public void DA_LOGIN_TC005_NoLoginDialogAfterSwitchingRepo() {
		Log.info("Step 1: Navigate to Dashboard login page");
		goToDashboardLoginPage();
		
		Log.info("Step 2: Login with valid account for the first repository");
		loginPage.login(Constant.REPOSITORY, Constant.VALID_USERNAME, Constant.VALID_PASSWORD);
		
		Log.info("Step 3: Choose another repository in Repository list");
		generalPage.switchRepo();
		
		Log.info("VP: There is no Login Repository dialog");
		Log.info("The Repository menu displays name of switched repository");
		Assert.assertEquals(generalPage.getRepoName(), Constant.REPOSITORY2);
		
	}
}
