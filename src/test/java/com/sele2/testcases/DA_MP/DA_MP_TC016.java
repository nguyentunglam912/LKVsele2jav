package com.sele2.testcases.DA_MP;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
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
	@Description("Verify that user is able to edit the 'Public' setting of any page successfully")
	public void DA_MP_TC016_CanEditPublicSettingSuccessfully() {
		Log.info("Step 1: Navigate to Dashboard login page");
		goToDashboardLoginPage();

		Log.info("Step 2: Login with valid account");
		loginPage.login(Constant.REPOSITORY, Constant.VALID_USERNAME, Constant.VALID_PASSWORD);

		Log.info("Step 3: Go to Global Setting -> Add page");
		homePage.selectAddPageButtonInGlobalSettingMenu();

		Log.info("Step 4: Enter info into all required fields on New Page dialog and click OK");
		newPage.submitNewPage(Constant.PAGE_NAME1, Constant.OVERVIEW_PAGE, null, null, null);

		Log.info("Step 5: Go to Global Setting -> Add page");
		homePage.selectAddPageButtonInGlobalSettingMenu();
		
		Log.info("Step 6: Enter Page Name, check public checkbox and click OK");
		newPage.submitNewPage(Constant.PAGE_NAME2, Constant.OVERVIEW_PAGE, null, null, true);

		Log.info("Step 7: Click on "+Constant.PAGE_NAME1+" page, click on Edit link, Check public checkbox and click OK");
		newPage.editPage(pagePath1, null, Constant.OVERVIEW_PAGE, null, null, true);

		Log.info("Step 8: Click on "+Constant.PAGE_NAME2+" page, click on Edit link, uncheck public checkbox and click OK");
		newPage.editPage(pagePath2, null, Constant.OVERVIEW_PAGE, null, null, false);
		
		Log.info("Step 9: Logout TA Dashboard");
		homePage.logOut();
		
		Log.info("Step 10: Login with another account");
		loginPage.login(Constant.REPOSITORY, Constant.TC008_USERNAME, Constant.TC008_PASSWORD);
		
		Log.info("VP: "+Constant.PAGE_NAME1+" Page is visible and can be accessed");
		homePage.goToPage(pagePath1);
		Assert.assertEquals(homePage.getCurrentPage(), Constant.PAGE_NAME1);
		
		Log.info("VP: Check 'Another Test' page is invisible");
		softAssert.assertFalse(homePage.doesItemExistInMenu(Constant.PAGE_NAME2, Constant.OVERVIEW_PAGE));
		softAssert.assertAll();
	}

	@AfterMethod
	private void cleanUp() {
		homePage.logOut();
		loginPage.login(Constant.REPOSITORY, Constant.VALID_USERNAME, Constant.VALID_PASSWORD);
		homePage.deletePage(Constant.OVERVIEW_PAGE + "/" + Constant.PAGE_NAME1);
		homePage.deleteAllPagesByPath(Constant.OVERVIEW_PAGE + "/" + Constant.PAGE_NAME2);
	}
}
