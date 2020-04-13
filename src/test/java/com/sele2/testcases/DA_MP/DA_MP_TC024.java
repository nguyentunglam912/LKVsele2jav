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
public class DA_MP_TC024 extends TestBase {
	/**
	 * DA_MP_TC024
	 *
	 * @author lam.tung.nguyen
	 */

	private String pagePath1 = Constant.OVERVIEW_PAGE + "/" + Constant.PAGE_NAME1;
	private String pagePath2 = pagePath1 + "/" + Constant.PAGE_NAME2;

	@Test
	@Description("Verify that 'Bread Crums' navigation is correct")
	public void DA_MP_TC024_VerifyBreadCrumNavigationCorrectly() {
		Log.info("Step 1: Navigate to Dashboard login page");
		goToDashboardLoginPage();

		Log.info("Step 2: Login with valid account");
		loginPage.login(Constant.REPOSITORY, Constant.VALID_USERNAME, Constant.VALID_PASSWORD);

		Log.info("Step 3: Go to Global Setting -> Add page");
		homePage.selectAddPageButtonInGlobalSettingMenu();

		Log.info("Step 4: Submit New Page with Page Name and Parrent Page");
		newPage.submitNewPage(Constant.PAGE_NAME1, Constant.OVERVIEW_PAGE, null, null, null);

		Log.info("Step 5: Go to Global Setting -> Add page");
		homePage.selectAddPageButtonInGlobalSettingMenu();

		Log.info("Step 6: Submit New Page with another new page name and parrent page");
		newPage.submitNewPage(Constant.PAGE_NAME2, Constant.PAGE_NAME1, null, Constant.PAGE_NAME1, null);

		Log.info("Step 7: Click the first breadcrums");
		homePage.goToPage(pagePath1);

		Log.info("VP: The first page is navigated");
		softAssert.assertEquals(homePage.getCurrentPage(), Constant.PAGE_NAME1);

		Log.info("Step 8: Click the second breadcrums");
		homePage.goToPage(pagePath2);

		Log.info("VP: The second page is navigated");
		softAssert.assertEquals(homePage.getCurrentPage(), Constant.PAGE_NAME2);
		softAssert.assertAll();
	}

	@AfterMethod
	private void cleanUp() {
		homePage.deleteAllPagesByPath(pagePath2);
	}
}
