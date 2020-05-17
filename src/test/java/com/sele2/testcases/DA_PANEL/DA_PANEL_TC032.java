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
public class DA_PANEL_TC032 extends TestBase {
	/**
	 * DA_PANEL_TC032
	 *
	 * @author lam.tung.nguyen
	 */

	private String duplicateErrorMessage = Constant.PANEL_NAME + " already exists. Please enter a different name.";

	@Test
	@Description("Verify that user is not allowed to create panel with duplicated 'Display Name'  ")
	public void DA_PANEL_TC032_NotAllowedCreatePanelWithDupDisplayName() {
		Log.info("Step 1: Navigate to Dashboard login page");
		goToDashboardLoginPage();

		Log.info("Step 2: Login with valid account");
		loginPage.login(Constant.REPOSITORY, Constant.VALID_USERNAME, Constant.VALID_PASSWORD);

		Log.info("Step 3: Click on Administer/Panels link");
		homePage.selectPanelinAdministerMenu();

		Log.info("Step 4: Click Add New link");
		panelPage.selectAddNewButtonOnPanel();

		Log.info("Step 5: Enter display name to Display name field.");
		panelPage.submitPanelForm(null, Constant.PANEL_NAME, Constant.SERIES, null);

		Log.info("Step 6: Click Add New link");
		panelPage.selectAddNewButtonOnPanel();

		Log.info("Step 7: Enter display name same with previous display name to display name field. ");
		panelPage.submitPanelForm(null, Constant.PANEL_NAME, Constant.SERIES, null);

		Log.info("VP: Check warning message show up");
		softAssert.assertEquals(panelPage.getErrorMessage(), this.duplicateErrorMessage);
	}

	@AfterMethod
	private void cleanUp() {
		panelPage.cancelPanelDialog();
		panelPage.deletePanel(Constant.PANEL_NAME);
	}
}
