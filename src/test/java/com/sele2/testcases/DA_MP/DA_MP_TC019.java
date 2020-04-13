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
public class DA_MP_TC019 extends TestBase {
	/**
	 * DA_MP_TC019
	 * @author khang.ha
	 */

	@Test
	@Description("Verify that user is able to add additional sibbling page levels to the parent page successfully.")
	public void DA_MP_TC019_AddSiblingPageLevelToParentPage() {
		Log.info("Step 1: Navigate to Dashboard login page");
		goToDashboardLoginPage();

		Log.info("Step 2: Login with valid account");
		loginPage.login(Constant.REPOSITORY, Constant.VALID_USERNAME, Constant.VALID_PASSWORD);

		Log.info("Step 3: Go to Global Setting -> Add page");
		homePage.selectAddPageButtonInGlobalSettingMenu();

		Log.info("Step 4: Enter info into all required fields on New Page dialog");
		newPage.submitNewPage(Constant.PAGE_NAME1, Constant.OVERVIEW_PAGE, null, null, null);

		Log.info("VP: User is able to add additional sibbling page levels to parent page successfully");
		softAssert.assertEquals(homePage.getCurrentPage(), Constant.PAGE_NAME1);
		softAssert.assertAll();
	}

	@AfterMethod
	private void cleanUp() {
		homePage.deleteAllPagesByPath(Constant.OVERVIEW_PAGE+"/"+Constant.PAGE_NAME1);
	}

}
