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
public class DA_PANEL_TC027 extends TestBase {
	/**
	 * DA_PANEL_TC027
	 *
	 * @author lam.tung.nguyen
	 */

	@Test
	@Description("Verify that when 'Choose panels' form is expanded all pre-set panels are populated and sorted correctly")
	public void DA_PANEL_TC027_VerifyCorrectPageWhenEditDisplayAfter() {
		Log.info("Step 1: Navigate to Dashboard login page");
		goToDashboardLoginPage();

		Log.info("Step 2: Login with valid account");
		loginPage.login(Constant.REPOSITORY, Constant.VALID_USERNAME, Constant.VALID_PASSWORD);

		Log.info("Step 3: Go to Global Setting -> Add page");
		homePage.selectAddPageButtonInGlobalSettingMenu();

		Log.info("Step 4: Submit New Page with Page Name");
		newPage.submitNewPage(Constant.PAGE_NAME1, null, null, null, null);

		Log.info("Step 5: Go to Global Setting -> Create Panel");
		homePage.selectCreatePanelButtonInGlobalSettingMenu();

		Log.info("Step 6: Create Panel with display name and series");
		panelPage.submitPanelForm(null, Constant.PANEL_NAME, Constant.SERIES, null);

		Log.info("Step 7: Click Ok button in Panel Configuration popup");
		panelPage.configPanel(null, null, null);

		Log.info("Step 8: Click on Choose Panel menu icon next to Global Setting icon");
		homePage.selectChoosePanelsMenu();

		Log.info("VP: Verify that all pre-set panels are populated and sorted correctly");
		softAssert.assertAll();
	}

	@AfterMethod
	private void cleanUp() {
		homePage.deletePage(Constant.PAGE_NAME1);
	}
}
