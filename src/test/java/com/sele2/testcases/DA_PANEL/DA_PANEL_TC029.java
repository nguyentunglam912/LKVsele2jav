package com.sele2.testcases.DA_PANEL;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sele2.support.Constant;
import com.sele2.helper.Log;
import com.sele2.testcases.testbase.TestBase;
import com.sele2.utils.listeners.TestListener;

import io.qameta.allure.Description;

@Listeners({ TestListener.class })
public class DA_PANEL_TC029 extends TestBase {
	/**
	 * DA_PANEL_TC029
	 *
	 * @author lam.tung.nguyen
	 */

	private String expectedWarningMessage = "Display Name is a required field.";

	@Test
	@Description("Verify that user is unable to create new panel when (*) required field is not filled")
	public void DA_PANEL_TC029_CannotCreateNewPanelWhenRequiredFieldIsNotFilled() {
		Log.info("Step 1: Navigate to Dashboard login page");
		goToDashboardLoginPage();

		Log.info("Step 2: Login with valid account");
		loginPage.login(Constant.REPOSITORY, Constant.VALID_USERNAME, Constant.VALID_PASSWORD);

		Log.info("Step 3: Click on Administer/Panels link");
		homePage.selectPanelinAdministerMenu();

		Log.info("Step 4: Click Add New link");
		panelPage.selectAddNewButtonOnPanel();

		Log.info("Step 6: Click Ok button");
		panelPage.submitPanelForm(null, null, null, null, null);

		Log.info("VP: Warning message: 'Display Name is a required field.' show up");
		softAssert.assertEquals(panelPage.getWarningMessageOnPanels(), expectedWarningMessage);
	}
}
