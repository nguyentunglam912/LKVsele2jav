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
public class DA_MP_TC014 extends TestBase {
	/**
	 * DA_MP_TC014
	 *
	 * @author lam.tung.nguyen
	 */

	@Test
	@Description("Verify that 'Public' pages can be visible and accessed by all users of working repository")
	public void DA_MP_TC014_PublicPagesIsVisibleAndAccessedByAllUsers() {
		Log.info("Step 1: Navigate to Dashboard login page");
		goToDashboardLoginPage();

		Log.info("Step 2: Log in specific repository with valid account");
		loginPage.login(Constant.REPOSITORY, Constant.VALID_USERNAME, Constant.VALID_PASSWORD);

		Log.info("Step 3: Go to Global Setting -> Add page");
		homePage.selectAddPageButtonInGlobalSettingMenu();

		Log.info("Step 4: Enter Page Name field, check Public checkbox and click Ok button");
		newPage.submitNewPage(Constant.PAGE_NAME1, null, null, null, true);

		Log.info("Step 5: Click on Log out link");
		homePage.logOut();

		Log.info("Step 6: Log in with another valid account");
		loginPage.login(Constant.REPOSITORY, Constant.TC008_USERNAME, Constant.TC008_PASSWORD);

		Log.info("VP: Check newly added page is visibled");
		softAssert.assertTrue(homePage.isNewPageDisplayAfterPage(Constant.OVERVIEW_PAGE, Constant.PAGE_NAME1));
		softAssert.assertAll();
	}

	@AfterMethod
	private void cleanUp() {
		homePage.deletePage(Constant.PAGE_NAME1);
	}
}
