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
public class DA_PANEL_TC044 extends TestBase {
	/**
	 * DA_PANEL_TC044
	 *
	 * @author lam.tung.nguyen
	 */

	String emptyHeight = "";
	String requiredErrorMsg = "Panel height is a required field.";

	@Test
	@Description("Verify that 'Height *' field is not allowed to be empty")
	public void DA_PANEL_TC044_HeightFieldNotAllowedToBeEmpty() {
		Log.info("Step 1: Navigate to Dashboard login page");
		goToDashboardLoginPage();

		Log.info("Step 2: Login with valid account");
		loginPage.login(Constant.REPOSITORY, Constant.VALID_USERNAME, Constant.VALID_PASSWORD);

		Log.info("Step 3: Go to Global Setting -> Add page");
		homePage.selectAddPageButtonInGlobalSettingMenu();

		Log.info("Step 4: Enter Page Name and click Ok button");
		newPage.submitNewPage(Constant.PAGE_NAME1, null , null, null, null);

		Log.info("Step 5: Click 'Choose Panels' button below created page button");
		homePage.selectChoosePanelsMenu();

		Log.info("Step 6: Click on any Chart panel instance");
		choosePanels.selectChartPanelInChoosePanels(Constant.CHART_PANEL);

		Log.info("Step 7: Leave 'Height *' field empty");
		panelPage.configPanel(null, this.emptyHeight, null);

		Log.info("VP: Check that 'Panel height is required field' message display");
		softAssert.assertEquals(panelPage.getWarningMessageOnPanels(), this.requiredErrorMsg);
	}

	@AfterMethod
	private void cleanUp() {
		panelPage.cancelConfigPanel();
		homePage.deletePage(Constant.PAGE_NAME1);
	}
}
