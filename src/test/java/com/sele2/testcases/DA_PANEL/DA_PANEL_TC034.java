package com.sele2.testcases.DA_PANEL;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sele2.support.Constant;
import com.sele2.helper.Log;
import com.sele2.testcases.testbase.TestBase;
import com.sele2.utils.listeners.TestListener;

import io.qameta.allure.Description;

@Listeners({ TestListener.class })
public class DA_PANEL_TC034 extends TestBase {
	/**
	 * DA_PANEL_TC034
	 *
	 * @author lam.tung.nguyen
	 */

	@Test
	@Description("Verify that newly created data profiles are populated correctly under the 'Data Profile' dropped down menu in  'Add New Panel' and 'Edit Panel' control/form")
	public void DA_PANEL_TC034_DataProfilesPopulatedCorrectlyUnderDataProfileDropdown() {
		Log.info("Step 1: Navigate to Dashboard login page");
		goToDashboardLoginPage();

		Log.info("Step 2: Login with valid account");
		loginPage.login(Constant.REPOSITORY, Constant.VALID_USERNAME, Constant.VALID_PASSWORD);

		Log.info("Step 3: Click on Administer/Data Profiles link");
		homePage.selectDataProfilesInAdministerMenu();

		Log.info("Step 4: Click Add New link");
		dataProfilePage.selectAddNewButtonOnDataProfiles();

		Log.info("Step 5: Enter name to Name textbox and click Finish");
		dataProfilePage.submitGeneralSettings(Constant.DATA_PROFILE_NAME, null, null);

		Log.info("Step 6: Click on Administer/Panels link");
		homePage.selectPanelinAdministerMenu();

		Log.info("Step 7: Click Add new");
		panelPage.selectAddNewButtonOnPanel();

		Log.info("VP: " + Constant.DATA_PROFILE_NAME
				+ " data profiles are populated correctly under the 'Data Profile' dropped down menu.");
		softAssert.assertTrue(panelPage.isDataProfilePopulated(Constant.DATA_PROFILE_NAME));

		Log.info("Step 6:Enter a display name to display name field and click OK");
		panelPage.submitPanelForm(null, Constant.PANEL_NAME, Constant.SERIES, null, null);

		Log.info("Step 7: Click Edit ");
		panelPage.openEditPanel(Constant.PANEL_NAME);

		Log.info("VP: " + Constant.DATA_PROFILE_NAME
				+ " data profiles are populated correctly under the 'Data Profile' dropped down menu.");
		softAssert.assertTrue(panelPage.isDataProfilePopulated(Constant.DATA_PROFILE_NAME));
	}

	@AfterMethod
	private void cleanUp() {
		panelPage.cancelPanelDialog();
		panelPage.deletePanel(Constant.PANEL_NAME);

	}
}
