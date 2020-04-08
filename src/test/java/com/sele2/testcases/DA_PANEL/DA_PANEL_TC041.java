package com.sele2.testcases.DA_PANEL;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sele2.support.Constant;
import com.sele2.helper.Log;
import com.sele2.testcases.testbase.TestBase;
import com.sele2.utils.listeners.TestListener;

import io.qameta.allure.Description;

@Listeners({ TestListener.class })
public class DA_PANEL_TC041 extends TestBase {
	/**
	 * DA_PANEL_TC041
	 *
	 * @author lam.tung.nguyen
	 */

	@Test
	@Description("Verify that all settings within 'Add New Panel' and 'Edit Panel' form stay unchanged when user switches between 'Data Labels' check boxes buttons")
	public void DA_PANEL_TC041_AllSettingUnchangedWhenSwitchingBetweenDataLabels() {
		Log.info("Step 1: Navigate to Dashboard login page");
		goToDashboardLoginPage();

		Log.info("Step 2: Login with valid account");
		loginPage.login(Constant.REPOSITORY, Constant.VALID_USERNAME, Constant.VALID_PASSWORD);

		Log.info("Step 3: Click on Administer/Panels link");
		homePage.selectPanelinAdministerMenu();

		Log.info("Step 4: Click Add New link");
		panelPage.selectAddNewButtonOnPanel();

		Log.info("Step 5: Check Series checkbox for Data Labels");
		panelPage.selectDataLabels(true, false, false, false);

		Log.info("VP: All settings are unchange in Add New Panel dialog");
		Assert.assertTrue(panelPage.isAllSettingExists());
		
		Log.info("Step 6: Uncheck Series checkbox");
		Log.info("Step 7: Check Value checkbox for Data Labels");
		panelPage.selectDataLabels(false, false, true, false);

		Log.info("VP: All settings are unchange in Add New Panel dialog");
		Assert.assertTrue(panelPage.isAllSettingExists());
		
		Log.info("Step 8: Uncheck Value checkbox");
		Log.info("Step 9: Check Percentage checbox for Data Labels");
		panelPage.selectDataLabels(false, false, false, true);

		Log.info("VP: All settings are unchange in Add New Panel dialog");
		Assert.assertTrue(panelPage.isAllSettingExists());
		
		Log.info("Step 10: Uncheck Percentage checkbox");
		panelPage.selectDataLabels(false, false, false, false);
		
		Log.info("Step 10: Create a new panel");
		panelPage.submitPanelForm(null, Constant.PANEL_NAME, Constant.SERIES, null);
		
		Log.info("Step 11: Click Edit Panel link");
		panelPage.openEditPanel(Constant.PANEL_NAME);

		Log.info("Step 12: Check Series checkbox for Data Labels");
		panelPage.selectDataLabels(true, false, false, false);

		Log.info("VP: All settings are unchange in Add New Panel dialog");
		Assert.assertTrue(panelPage.isAllSettingExists());
		
		Log.info("Step 13: Uncheck Series checkbox");
		Log.info("Step 14: Check Value checkbox for Data Labels");
		panelPage.selectDataLabels(false, false, true, false);

		Log.info("VP: All settings are unchange in Add New Panel dialog");
		Assert.assertTrue(panelPage.isAllSettingExists());
		
		Log.info("Step 15: Uncheck Value checkbox");
		Log.info("Step 16: Check Percentage checbox for Data Labels");
		panelPage.selectDataLabels(false, false, false, true);

		Log.info("VP: All settings are unchange in Add New Panel dialog");
		Assert.assertTrue(panelPage.isAllSettingExists());
	}

	@AfterMethod
	private void cleanUp(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			panelPage.cancelPanelDialog();
			panelPage.deletePanel(Constant.PANEL_NAME);
		}
	}
}
