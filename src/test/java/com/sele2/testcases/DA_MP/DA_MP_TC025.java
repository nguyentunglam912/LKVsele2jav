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
public class DA_MP_TC025 extends TestBase{
	/**
	 * DA_MP_TC025
	 * @author lam.tung.nguyen
	 */

	@Test
	@Description("Verify that page listing is correct when user edit 'Display After'  field of a specific page")
	public void DA_MP_TC025_VerifyCorrectPageWhenEditDisplayAfter() {
		Log.info("Step 1: Navigate to Dashboard login page");
		goToDashboardLoginPage();

		Log.info("Step 2: Login with valid account");
		loginPage.login(Constant.REPOSITORY, Constant.VALID_USERNAME, Constant.VALID_PASSWORD);
		
		Log.info("Step 3: Go to Global Setting -> Add page");
		homePage.selectAddPageButtonInGlobalSettingMenu();
		
		Log.info("Step 4: Submit New Page with Page Name");
		newPage.submitNewPage(Constant.PAGE_NAME1, null, null, Constant.OVERVIEW_PAGE, null);

		Log.info("Step 5: Go to Global Setting -> Add page");
		homePage.selectAddPageButtonInGlobalSettingMenu();

		Log.info("Step 6: Submit New Page with another new page name");
		newPage.submitNewPage(Constant.PAGE_NAME2, null, null, Constant.PAGE_NAME1, null);

		Log.info("Step 7: Edit value Display After for the second created page to after Overview page");
		newPage.editPage(Constant.PAGE_NAME2, null, null, null, Constant.OVERVIEW_PAGE, null);

		Log.info("VP: Position of the second page follow Overview page");
		softAssert.assertTrue(homePage.isNewPageDisplayAfterPage(Constant.OVERVIEW_PAGE, Constant.PAGE_NAME2));
	}

	@AfterMethod
	private void cleanUp() {
		homePage.deletePage(Constant.PAGE_NAME1);
		homePage.deletePage(Constant.PAGE_NAME2);
	}
}
