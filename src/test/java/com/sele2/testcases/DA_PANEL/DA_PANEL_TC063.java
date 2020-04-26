package com.sele2.testcases.DA_PANEL;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sele2.support.Constant;
import com.sele2.helper.Log;
import com.sele2.testcases.testbase.TestBase;
import com.sele2.utils.listeners.TestListener;

import io.qameta.allure.Description;

@Listeners({ TestListener.class })
public class DA_PANEL_TC063 extends TestBase {
	/**
	 * DA_PANEL_TC063
	 *
	 * @author lam.tung.nguyen
	 */

	@Test
	@Description("Verify that for 'Action Implementation By Status' panel instance,"
			+ " when user changes from 'Pie' chart to any other chart type then "
			+ "change back the 'Edit Panel' form should be as original")
	public void DA_PANEL_TC063_EditPanelDisplayAsOriginalAfterChangeChartType() {
		Log.info("Step 1: Navigate to Dashboard login page");
		goToDashboardLoginPage();

		Log.info("Step 2: Login with valid account");
		loginPage.login(Constant.REPOSITORY, Constant.VALID_USERNAME, Constant.VALID_PASSWORD);

		Log.info("Step 3: Click 'Choose Panels' button below created page button");
		homePage.selectChoosePanelsMenu();

		Log.info("Step 4: Click on any Chart panel instance");
		choosePanels.selectChartPanelInChoosePanels(Constant.CHART_PANEL);

		Log.info("Step 5: Click Ok button on Panel Configuration dialog");
		panelPage.configPanel(null, null, null);

		Log.info("Step 6: Click Edit Panel icon");
		choosePanels.selectEditChartIconInChoosePanels(Constant.CHART_PANEL);

		Log.info("Step 7: Click on Chart Type dropped down menu and select Single Bar");
		panelPage.selectChartType("Single Bar");

		Log.info("Step 8: Click on Chart Type dropped down menu and select Pie");
		panelPage.selectChartType("Pie");

		Log.info("VP: Check original 'Pie' - Edit Panel form is displayed");
		softAssert.assertTrue(panelPage.isAllSettingExists());

		Log.info("Step 9: Close Edit Panel");
		panelPage.cancelPanelDialog();

		Log.info("Step 10: Click Edit Panel icon");
		choosePanels.selectEditChartIconInChoosePanels(Constant.CHART_PANEL);

		Log.info("Step 11: Click on Chart Type dropped down menu and select Stacked Bar");
		panelPage.selectChartType("Stacked Bar");

		Log.info("Step 12: Click on Chart Type dropped down menu and select Pie");
		panelPage.selectChartType("Pie");

		Log.info("VP: Check original 'Pie' - Edit Panel form is displayed");
		softAssert.assertTrue(panelPage.isAllSettingExists());

		Log.info("Step 13: Close Edit Panel");
		panelPage.cancelPanelDialog();

		Log.info("Step 14: Click Edit Panel icon");
		choosePanels.selectEditChartIconInChoosePanels(Constant.CHART_PANEL);

		Log.info("Step 15: Click on Chart Type dropped down menu and select Group Bar");
		panelPage.selectChartType("Group Bar");

		Log.info("Step 16: Click on Chart Type dropped down menu and select Pie");
		panelPage.selectChartType("Pie");

		Log.info("VP: Check original 'Pie' - Edit Panel form is displayed");
		softAssert.assertTrue(panelPage.isAllSettingExists());

		Log.info("Step 17: Close Edit Panel");
		panelPage.cancelPanelDialog();

		Log.info("Step 18: Click Edit Panel icon");
		choosePanels.selectEditChartIconInChoosePanels(Constant.CHART_PANEL);

		Log.info("Step 19: Click on Chart Type dropped down menu and select Group Bar");
		panelPage.selectChartType("Group Bar");

		Log.info("Step 20: Click on Chart Type dropped down menu and select Pie");
		panelPage.selectChartType("Pie");

		Log.info("VP: Check original 'Pie' - Edit Panel form is displayed");
		softAssert.assertTrue(panelPage.isAllSettingExists());
		softAssert.assertAll();
	}
}
