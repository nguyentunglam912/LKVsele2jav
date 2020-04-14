package com.sele2.testcases.DA_MP;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sele2.support.Constant;
import com.sele2.helper.Log;
import com.sele2.testcases.testbase.TestBase;
import com.sele2.utils.listeners.TestListener;

import io.qameta.allure.Description;

@Listeners({ TestListener.class })
public class DA_MP_TC015 extends TestBase {
	/**
	 * DA_MP_TC015
	 *
	 * @author lam.tung.nguyen
	 */

	@Test
	@Description("Verify that non 'Public' pages can only be accessed and visible to their creators with "
			+ "condition that all parent pages above it are 'Public'")
	public void DA_MP_TC015_PublicPagesIsVisibleAndAccessedByAllUsers() {
		Log.info("Step 1: Navigate to Dashboard login page");
		goToDashboardLoginPage();

		Log.info("Step 2: Log in specific repository with valid account");
		loginPage.login(Constant.REPOSITORY, Constant.VALID_USERNAME, Constant.VALID_PASSWORD);

		Log.info("Step 3: Go to Global Setting -> Add page");
		homePage.selectAddPageButtonInGlobalSettingMenu();

		Log.info("Step 4: Enter Page Name field, check Public checkbox and click Ok button");
		newPage.submitNewPage(Constant.PAGE_NAME1, null, null, null, true);

		Log.info("Step 5: Go to Global Setting -> Add page");
		homePage.selectAddPageButtonInGlobalSettingMenu();

		Log.info("Step 6: Enter Page Name field, check Public checkbox and click Ok button");
		newPage.submitNewPage(Constant.PAGE_NAME2, Constant.PAGE_NAME1, null, null, null);

		Log.info("Step 7: Click on Log out link");
		homePage.logOut();

		Log.info("Step 8: Log in with another valid account");
		loginPage.login(Constant.REPOSITORY, Constant.TC008_USERNAME, Constant.TC008_PASSWORD);

		Log.info("VP: Check children is invisibled");
		softAssert.assertFalse(homePage.doesItemExistInMenu(Constant.PAGE_NAME2, Constant.PAGE_NAME1));
		softAssert.assertAll();
	}

	@AfterMethod
	private void cleanUp() {
		homePage.logOut();
		loginPage.login(Constant.REPOSITORY, Constant.VALID_USERNAME, Constant.VALID_PASSWORD);
		homePage.deleteAllPagesByPath(Constant.PAGE_NAME1 +"/"+ Constant.PAGE_NAME2);
	}
}
