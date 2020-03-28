package com.sele2.testcases.DA_MP;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sele2.support.Constant;
import com.sele2.helper.Log;
import com.sele2.testcases.testbase.TestBase;
import com.sele2.utils.listeners.TestListener;

import io.qameta.allure.Description;


@Listeners({ TestListener.class })
public class DA_MP_TC011 extends TestBase{
	/**
	 * DA_MP_TC011
	 * @author lam.tung.nguyen
	 */

	@Test
	@Description("Verify that user is unable open more than 1 'New Page' dialog")
	public void DA_MP_TC011_CannotOpenMoreThanOneNewPageDialog() {
		Log.info("Step 1: Navigate to Dashboard login page");
		goToDashboardLoginPage();

		Log.info("Step 2: Login with valid account");
		loginPage.login(Constant.REPOSITORY, Constant.VALID_USERNAME, Constant.VALID_PASSWORD);
		
		Log.info("Step 3: Go to Global Setting -> Add page");
		homePage.selectAddPageButtonInGlobalSettingMenu();
		
		Log.info("Step 4: Try to go to Global Setting -> Add page again");
		homePage.clickOnMenu("Global Setting");

		Log.info("VP: User cannot go to Global Setting -> Add page while 'New Page' dialog appears.");
		Assert.assertFalse(homePage.isGlobalSettingMenuDisplayed());
	}
}
