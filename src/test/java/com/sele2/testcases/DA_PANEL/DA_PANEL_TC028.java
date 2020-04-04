package com.sele2.testcases.DA_PANEL;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sele2.support.Constant;
import com.sele2.helper.Log;
import com.sele2.testcases.testbase.TestBase;
import com.sele2.utils.listeners.TestListener;

import io.qameta.allure.Description;

@Listeners({ TestListener.class })
public class DA_PANEL_TC028 extends TestBase {
	/**
	 * DA_PANEL_TC028
	 *
	 * @author lam.tung.nguyen
	 */

	@Test
	@Description("Verify that when 'Add New Panel' form is on focused all other control/form is disabled or locked.")
	public void DA_PANEL_TC028_AllControlIsDisabledWhenAddNewPanelDisplays() {
		Log.info("Step 1: Navigate to Dashboard login page");
		goToDashboardLoginPage();

		Log.info("Step 2: Login with valid account");
		loginPage.login(Constant.REPOSITORY, Constant.VALID_USERNAME, Constant.VALID_PASSWORD);

		Log.info("Step 3: Click Administer link");
		Log.info("Step 4: Click Panel link");
		homePage.selectPanelinAdministerMenu();

		Log.info("Step 5: Click Add New link");
		panelPage.selectAddNewButtonOnPanel();

		Log.info("Step 6: Try to click other controls when Add New Panel dialog is opening");
		panelPage.clickOnMenu("Global Setting");

		Log.info("VP: All control/form are disabled or locked when Add New Panel dialog is opening");
		Assert.assertFalse(panelPage.isGlobalSettingMenuDisplayed());
	}
}
