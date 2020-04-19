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
public class DA_PANEL_TC052 extends TestBase {
	/**
	 * DA_PANEL_TC052
	 *
	 * @author lam.tung.nguyen
	 */

	String invalidHeight = "200";
	String validHeight = "400";
	String invalidHeighMessage = "Panel height must be greater than or equal to 300 and less than or equal to 800.";

	@Test
	@Description("Verify that user is unable to edit  'Height *' field to anything apart from integer number with in 300-800 range")
	public void DA_PANEL_TC052_DataLabelsCheckboxStateCorrespondingToChartType() {
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

		Log.info("Step 6: Click 'Choose Panels' button below created page button");
		choosePanels.clickCreateNewPanel();

		Log.info("Step 7: Enter all required fields on Add New Panel page and click OK");
		panelPage.submitPanelForm(null, Constant.PANEL_NAME, Constant.SERIES, null);

		Log.info("Step 8: Enter invalid height into Height field and click OK");
		panelPage.configPanel(null, this.invalidHeight, null);

		Log.info("VP: Check that There is message 'Panel height must be greater than or equal to 300 and less than or equal to 800.'");
		softAssert.assertEquals(panelPage.getWarningMessageOnPanels(), invalidHeighMessage);

		Log.info("Step 9: Close Warning Message box");
		panelPage.closePopupMessage();

		Log.info("Step 10: Enter valid height into Height field and click OK");
		panelPage.configPanel(null, this.validHeight, null);

		Log.info("VP: Check that User is able to edit Height field to anything apart from integer number with in 300-800 range");
		softAssert.assertFalse(panelPage.doesConfigPanelDisplay());
		softAssert.assertAll();
	}

	@AfterMethod
	private void cleanUp() {
		homePage.selectPanelinAdministerMenu();
		panelPage.deletePanel(Constant.PANEL_NAME);
		homePage.deletePage(Constant.PAGE_NAME1);
	}
}
