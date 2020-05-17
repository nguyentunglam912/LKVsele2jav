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
public class DA_PANEL_TC064 extends TestBase {
	/**
	 * DA_PANEL_TC064
	 *
	 * @author lam.tung.nguyen
	 */

	@Test
	@Description("Verify that 'Check All/Uncheck All' links are working correctly.")
	public void DA_PANEL_TC064_CheckAndUncheckAllLinkAreWorkingCorrectly() {
		Log.info("Step 1: Navigate to Dashboard login page");
		goToDashboardLoginPage();

		Log.info("Step 2: Login with valid account");
		loginPage.login(Constant.REPOSITORY, Constant.VALID_USERNAME, Constant.VALID_PASSWORD);

		Log.info("Step 3: Click 'Add Page' button");
		homePage.selectAddPageButtonInGlobalSettingMenu();

		Log.info("Step 4: Enter Page name and click OK");
		newPage.submitNewPage(Constant.PAGE_NAME1, null, null, null, null);
		
		Log.info("Step 5: Click 'Choose Panels' button below"+Constant.PAGE_NAME1+"button");
		homePage.selectChoosePanelsMenu();
		
		Log.info("Step 6: Click 'Create new panel' button");
		choosePanels.clickCreateNewPanel();
		
		Log.info("Step 7: Enter a name to Display Name and click OK");
		panelPage.submitPanelForm(null, Constant.PANEL_NAME, Constant.SERIES, null, null);
		
		Log.info("Step 8: Click Cancel button on Config Panel");
		panelPage.cancelConfigPanel();
		
		Log.info("Step 9: Click 'Create new panel' button");
		choosePanels.clickCreateNewPanel();
		
		Log.info("Step 10: Enter a name to Display Name and click OK");
		panelPage.submitPanelForm(null, Constant.PANEL_NAME1, Constant.SERIES1, null, null);
		
		Log.info("Step 11: Click Cancel button on Config Panel");
		panelPage.cancelConfigPanel();

		Log.info("Step 12: Select Panels below 'Administer' link");
		homePage.selectPanelinAdministerMenu();
		
		Log.info("Step 13: Click 'Check All' link");
		panelPage.clickCheckAllLink();
		
		Log.info("VP: Check that all checkboxes are checked");
		softAssert.assertTrue(panelPage.isAllPanelCheckboxesSelected());

		Log.info("Step 14: Click 'UnCheck All' link");
		panelPage.clickUncheckAllLink();

		Log.info("VP: Check that all checkboxes are unchecked");
		softAssert.assertFalse(panelPage.isAllPanelCheckboxesSelected());
	}
	
	@AfterMethod
	private void cleanUp() {
		panelPage.deleteAllPanels();
		homePage.deletePage(Constant.PAGE_NAME1);
	}
}
