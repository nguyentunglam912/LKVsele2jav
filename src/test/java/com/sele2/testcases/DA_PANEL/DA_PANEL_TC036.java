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
public class DA_PANEL_TC036 extends TestBase {
	/**
	 * DA_PANEL_TC036
	 *
	 * @author lam.tung.nguyen
	 */

	@Test
	@Description("Verify that all chart types ( Pie, Single Bar, Stacked Bar, Group Bar, Line ) are listed correctly under 'Chart Type' dropped down menu.")
	public void DA_PANEL_TC036_AllChartTypesListedUnderChartType() {
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

		Log.info("Step 6: Click 'Chart Type' drop-down menu");
		Log.info("VP: 'Chart Type' are listed 5 options: 'Pie', 'Single Bar', 'Stacked Bar', 'Group Bar' and 'Line'");
		softAssert.assertEquals(panelPage.getListChartType(), Constant.LIST_CHART_TYPE);
	}

	@AfterMethod
	private void cleanUp() {
		panelPage.cancelPanelDialog();
		panelPage.deletePage(Constant.PAGE_NAME1);

	}
}
