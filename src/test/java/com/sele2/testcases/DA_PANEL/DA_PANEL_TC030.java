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
public class DA_PANEL_TC030 extends TestBase {
	/**
	 * DA_PANEL_TC030
	 *
	 * @author lam.tung.nguyen
	 */

	private String displayNameExceptAtSign = "Logigear#$%";
	private String displayNameWithAtSign = "Logigear@";
	private String invalidDisplayNameMessage = "Invalid display name. The name cannot contain high"
			+ " ASCII characters or any of the following characters: /:*?<>|\\\"#[]{}=%;";

	@Test
	@Description("Verify that no special character except '@' character is allowed to be inputted into 'Display Name' field")
	public void DA_PANEL_TC030_NoSepecialCharIsAllowedToInputDisplayName() {
		Log.info("Step 1: Navigate to Dashboard login page");
		goToDashboardLoginPage();

		Log.info("Step 2: Login with valid account");
		loginPage.login(Constant.REPOSITORY, Constant.VALID_USERNAME, Constant.VALID_PASSWORD);

		Log.info("Step 3: Click on Administer/Panels link");
		homePage.selectPanelinAdministerMenu();

		Log.info("Step 4: Click Add New link");
		panelPage.selectAddNewButtonOnPanel();

		Log.info("Step 5: Enter value into Display Name field with special characters except '@' and click OK");
		panelPage.submitPanelForm(null, displayNameExceptAtSign, Constant.SERIES, null);

		Log.info("VP: Check warning message is shown up");
		softAssert.assertEquals(panelPage.getWarningMessageOnPanels(), invalidDisplayNameMessage);

		Log.info("Step 6: Close warning message");
		panelPage.closePopupMessage();

		Log.info("Step 7: Enter value into Display Name field with special characters except '@' and click OK");
		panelPage.submitPanelForm(null, displayNameWithAtSign, Constant.SERIES, null);

		Log.info("VP: Check The new panel is created");
		softAssert.assertTrue(panelPage.isNewPanelExisted(displayNameWithAtSign));
		softAssert.assertAll();
	}

	@AfterMethod
	private void cleanUp() {
		panelPage.deletePanel(displayNameWithAtSign);
	}
}
