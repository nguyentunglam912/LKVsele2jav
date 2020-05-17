package com.sele2.testcases.DA_DP;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sele2.support.Constant;
import com.sele2.helper.Log;
import com.sele2.testcases.testbase.TestBase;
import com.sele2.utils.listeners.TestListener;

import io.qameta.allure.Description;

@Listeners({ TestListener.class })
public class DA_DP_TC065 extends TestBase {
	/**
	 * DA_DP_TC065
	 *
	 * @author lam.tung.nguyen
	 */

	@Test
	@Description("Verify that all Pre-set Data Profiles are populated correctly")
	public void DA_DP_TC065_EditPanelDisplayAsOriginalAfterChangeChartType() {
		Log.info("Step 1: Navigate to Dashboard login page");
		goToDashboardLoginPage();

		Log.info("Step 2: Login with valid account");
		loginPage.login(Constant.REPOSITORY, Constant.VALID_USERNAME, Constant.VALID_PASSWORD);

		Log.info("Step 3: Click Administer->Data Profiles");
		homePage.selectDataProfilesInAdministerMenu();

		Log.info("Step 3: Click Administer->Data Profiles");
		softAssert.assertTrue(this.dataProfilePage.isDataProfilesItemsPoputated(Constant.LIST_PRESET_DATAPROFILES));
		softAssert.assertAll();
	}
}
