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
public class DA_MP_TC016 extends TestBase {
	/**
	 * DA_MP_TC016
	 * 
	 * @author khang.ha
	 */

	private String pagePath1 = Constant.OVERVIEW_PAGE + "/" + Constant.PAGE_NAME1;
	private String pagePath2 = Constant.OVERVIEW_PAGE + "/" + Constant.PAGE_NAME2;
	@Test
	@Description("Verify that user is able to edit the \"Public\" setting of any page successfully")
	public void DA_MP_TC016_EditPublicSetting() {
		Log.info("Step 1: Navigate to Dashboard login page");
		goToDashboardLoginPage();

		Log.info("Step 2: Login with valid account");
		loginPage.login(Constant.REPOSITORY, Constant.VALID_USERNAME, Constant.VALID_PASSWORD);

		Log.info("Step 3: Go to Global Setting -> Add page");
		homePage.selectAddPageButtonInGlobalSettingMenu();

		Log.info("Step 4: Enter info into all required fields on New Page dialog");
		Log.info("Step 5: Click OK button");
		newPage.submitNewPage(Constant.PAGE_NAME1, Constant.OVERVIEW_PAGE, null, null, null);

		Log.info("Step 6: Go to Global Setting -> Add page");
		homePage.selectAddPageButtonInGlobalSettingMenu();
		
		Log.info("Step 7: Enter Page Name");
		Log.info("Step 8: Check Public checkbox");
		Log.info("Step 9: Click OK button");
		newPage.submitNewPage(Constant.PAGE_NAME2, Constant.OVERVIEW_PAGE, null, null, true);

		Log.info("Step 10: Click on \"Test\" page");
		Log.info("Step 11: Click on \"Edit\" link");
		Log.info("Step 12: Check \"Edit Page\" pop up window is displayed");
		Log.info("Step 13: Check Public checkbox");
		Log.info("Step 14: Click OK button");
		newPage.editPage(pagePath1, null, Constant.OVERVIEW_PAGE, null, null, true);

		Log.info("Step 15: Click on \"Another Test\" page");
		Log.info("Step 16: Click on \"Edit\" link");
		Log.info("VP: Check \"Edit Page\" pop up window is displayed");
		Log.info("Step 17: Unheck Public checkbox");
		Log.info("VP: Click OK button");
		newPage.editPage(pagePath2, null, Constant.OVERVIEW_PAGE, null, null, false);
		
		Log.info("Step 18: Logout TA Dashboard");
		homePage.logOut();
		
		Log.info("Step 19: Login with another account");
		loginPage.login(Constant.REPOSITORY, Constant.TC008_USERNAME, Constant.TC008_PASSWORD);
		
		Log.info("VP: \"Test\" Page is visible and can be accessed");
		homePage.goToPage(pagePath1);
		Assert.assertEquals(homePage.getCurrentPage(), Constant.PAGE_NAME1);
		
		Log.info("VP: Check \"Another Test\" page is invisible");
		Assert.assertFalse(homePage.isPagePresentUnderOverview());

	}

}
