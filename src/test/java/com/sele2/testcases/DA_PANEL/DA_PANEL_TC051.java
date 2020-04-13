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
public class DA_PANEL_TC051 extends TestBase {
	/**
	 * DA_PANEL_TC051
	 *
	 * @author lam.tung.nguyen
	 */

	private String displayNameExceptAtSign = "test#$";
	private String displayNameWithAtSign = "test@";
	private String invalidDisplayNameMessage = "Invalid display name. The name cannot contain high ASCII characters or any of the following characters: /:*?<>|\"#[]{}=%;";

	@Test
	@Description("Verify that user is unable to change 'Display Name' of any Panel if there is special character except '@' inputted")
	public void DA_PANEL_TC051_CannotChangeDisplayNameOfPanelWithSpecialCharExceptAtSign() {
		Log.info("Step 1: Navigate to Dashboard login page");
		goToDashboardLoginPage();

		Log.info("Step 2: Login with valid account");
		loginPage.login(Constant.REPOSITORY, Constant.VALID_USERNAME, Constant.VALID_PASSWORD);

		Log.info("Step 3: Click on Administer/Panels link");
		homePage.selectPanelinAdministerMenu();

		Log.info("Step 4: Click Add New link");
		panelPage.selectAddNewButtonOnPanel();

		Log.info("Step 5: Enter value into Display Name field with special characters except '@' and click OK");
		panelPage.submitPanelForm(null, Constant.PANEL_NAME, Constant.SERIES, null);

		Log.info("Step 6: Click Edit link");
		panelPage.openEditPanel(Constant.PANEL_NAME);

		Log.info("Step 7: Edit panel name with special characters");
		panelPage.submitPanelForm(null, this.displayNameExceptAtSign, null, null);

		Log.info("VP: Check warning message is shown up");
		softAssert.assertEquals(panelPage.getWarningMessageOnPanels(), invalidDisplayNameMessage);

		Log.info("Step 8: Close warning message");
		panelPage.closePopupMessage();

		Log.info("Step 9: Edit panel name with special character is @");
		panelPage.submitPanelForm(null, displayNameWithAtSign, null, null);

		Log.info("VP: Check The new panel is created");
		softAssert.assertTrue(panelPage.isNewPanelExisted(displayNameWithAtSign));
		softAssert.assertAll();
	}

	@AfterMethod
	private void cleanUp() {
		panelPage.deletePanel(displayNameWithAtSign);
	}
}
