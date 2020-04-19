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
public class DA_PANEL_TC043 extends TestBase {
	/**
	 * DA_PANEL_TC043
	 *
	 * @author lam.tung.nguyen
	 */

	String lowerHeight = "299";
	String higherHeight = "801";
	String minusHeight = "-2";
	String decimalHeight = "3.1";
	String stringHeight = "abc";
	String invalidHeightMsg1 = "Panel height must be greater than or equal to 300 and less than or equal to 800.";
	String invalidHeightMsg2 = "Panel height must be an integer number";

	@Test
	@Description("Verify that only integer number inputs from 300-800 are valid for 'Height field ")
	public void DA_PANEL_TC043_OnlyIntegerInputFromRangeForHeight() {
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

		Log.info("Step 7: Enter integer number to 'Height *' field");
		panelPage.configPanel(null, this.lowerHeight, null);

		Log.info("VP: Check that There is message 'Panel height must be greater than or equal to 300 and less than or equal to 800.'");
		softAssert.assertEquals(panelPage.getWarningMessageOnPanels(), this.invalidHeightMsg1);

		Log.info("Step 8: Close Warning Message box");
		panelPage.closePopupMessage();

		Log.info("Step 9: Enter integer number to 'Height *' field");
		panelPage.configPanel(null, this.higherHeight, null);

		Log.info("VP: Check that There is message 'Panel height must be greater than or equal to 300 and less than or equal to 800.'");
		softAssert.assertEquals(panelPage.getWarningMessageOnPanels(), this.invalidHeightMsg1);

		Log.info("Step 10: Close Warning Message box");
		panelPage.closePopupMessage();

		Log.info("Step 11: Enter integer number to 'Height *' field");
		panelPage.configPanel(null, this.minusHeight, null);

		Log.info("VP: Check that There is message 'Panel height must be greater than or equal to 300 and less than or equal to 800.'");
		softAssert.assertEquals(panelPage.getWarningMessageOnPanels(), this.invalidHeightMsg1);

		Log.info("Step 12: Close Warning Message box");
		panelPage.closePopupMessage();

		Log.info("Step 13: Enter integer number to 'Height *' field");
		panelPage.configPanel(null, this.decimalHeight, null);

		Log.info("VP: Error message 'Panel height must be an integer number' display");
		softAssert.assertEquals(panelPage.getWarningMessageOnPanels(), this.invalidHeightMsg2);

		Log.info("Step 14: Close Warning Message box");
		panelPage.closePopupMessage();

		Log.info("Step 15: Enter integer number to 'Height *' field");
		panelPage.configPanel(null, this.stringHeight, null);

		Log.info("VP: Error message 'Panel height must be an integer number' display");
		softAssert.assertEquals(panelPage.getWarningMessageOnPanels(), this.invalidHeightMsg2);
		softAssert.assertAll();
	}

	@AfterMethod
	private void cleanUp() {
		panelPage.cancelConfigPanel();
		homePage.deletePage(Constant.PAGE_NAME1);
	}
}
