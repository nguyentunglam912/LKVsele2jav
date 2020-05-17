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
public class DA_PANEL_TC037 extends TestBase {
	/**
	 * DA_PANEL_TC037
	 *
	 * @author lam.tung.nguyen
	 */

	@Test
	@Description("Verify that 'Category', 'Series' and 'Caption' field are enabled and disabled correctly corresponding to each type of the 'Chart Type'")
	public void DA_PANEL_TC037_OptionStateCorrectlyCorrespondingToChartType() {
		Log.info("Step 1: Navigate to Dashboard login page");
		goToDashboardLoginPage();

		Log.info("Step 2: Login with valid account");
		loginPage.login(Constant.REPOSITORY, Constant.VALID_USERNAME, Constant.VALID_PASSWORD);
		
		Log.info("Step 3: Add a new page");
		homePage.selectAddPageButtonInGlobalSettingMenu();
		newPage.submitNewPage(Constant.PAGE_NAME1, null, null, null, null);

		Log.info("Step 4: Select choose panels");
		homePage.selectChoosePanelsMenu();

		Log.info("Step 5: Click 'Create new panel' button ");
		choosePanels.clickCreateNewPanel();
		
		Log.info("Step 6: Click 'Chart Type' drop-down menu and select 'Pie' Chart Type");
		panelPage.selectChartType("Pie");

		Log.info("VP: Check that 'Category' and 'Caption' are disabled, 'Series' is enabled");
		softAssert.assertTrue(panelPage.isControlStateCorrect(true, false, false, false));
		
		Log.info("Step 7: Click 'Chart Type' drop-down menu and select 'Single Bar' Chart Type");
		panelPage.selectChartType("Single Bar");

		Log.info("VP: Check that 'Category' is disabled, 'Series' and 'Caption' are enabled");
		softAssert.assertTrue(panelPage.isControlStateCorrect(true, false, true, true));
		
		Log.info("Step 8: Click 'Chart Type' drop-down menu and select 'Stacked Bar' Chart Type");
		panelPage.selectChartType("Stacked Bar");

		Log.info("VP: Check that 'Category' ,'Series' and 'Caption' are enabled");
		softAssert.assertTrue(panelPage.isControlStateCorrect(true, true, true, true));
		
		Log.info("Step 9: Click 'Chart Type' drop-down menu and select 'Group Bar' Chart Type");
		panelPage.selectChartType("Group Bar");

		Log.info("VP: Check that 'Category' ,'Series' and 'Caption' are enabled");
		softAssert.assertTrue(panelPage.isControlStateCorrect(true, true, true, true));
		
		Log.info("Step 10: Click 'Chart Type' drop-down menu and select 'Line' Chart Type");
		panelPage.selectChartType("Line");

		Log.info("VP: Check that 'Category' ,'Series' and 'Caption' are enabled");
		softAssert.assertTrue(panelPage.isControlStateCorrect(true, true, true, true));
	}

	@AfterMethod
	private void cleanUp() {
		panelPage.cancelPanelDialog();
		panelPage.deletePage(Constant.PAGE_NAME1);

	}
}
