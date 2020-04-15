package com.sele2.testcases.DA_PANEL;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sele2.support.Constant;
import com.sele2.helper.Log;
import com.sele2.testcases.testbase.TestBase;
import com.sele2.utils.listeners.TestListener;

import io.qameta.allure.Description;

@Listeners({ TestListener.class })
public class DA_PANEL_TC031 extends TestBase {
	/**
	 * DA_PANEL_TC031
	 *
	 * @author lam.tung.nguyen
	 */

	@Test
	@Description("Verify that correct panel setting form is displayed with corresponding panel type selected")
	public void DA_PANEL_TC031_CorrectPanelSettingFormDisplayWithPanelTypeSelected() {
		Log.info("Step 1: Navigate to Dashboard login page");
		goToDashboardLoginPage();

		Log.info("Step 2: Login with valid account");
		loginPage.login(Constant.REPOSITORY, Constant.VALID_USERNAME, Constant.VALID_PASSWORD);

		Log.info("Step 3: Click on Administer/Panels link");
		homePage.selectPanelinAdministerMenu();

		Log.info("Step 4: Click Add New link");
		panelPage.selectAddNewButtonOnPanel();

		Log.info("VP: Verify that chart panel setting form is displayed with corresponding panel type selected");
		softAssert.assertEquals(panelPage.getCurrentSettingForm(), "Chart Settings");

		Log.info("Step 5: Select Indicator type");
		panelPage.selectPanelType("Indicator");

		Log.info("Step VP: Verify that indicator panel setting form is displayed with corresponding panel type selected");
		softAssert.assertEquals(panelPage.getCurrentSettingForm(), "Indicator Settings");

		Log.info("Step 6: Select Heat Map type");
		panelPage.selectPanelType("Heat Map");

		Log.info("VP: Verify that report panel setting form is displayed with corresponding panel type selected");
		softAssert.assertEquals(panelPage.getCurrentSettingForm(), "Heat Map Settings");
		softAssert.assertAll();
	}
}
