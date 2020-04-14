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
public class DA_PANEL_TC040 extends TestBase {
	/**
	 * DA_PANEL_TC040
	 *
	 * @author lam.tung.nguyen
	 */

	@Test
	@Description("Verify that all 'Data Labels' check boxes are enabled and disabled correctly corresponding to each type of 'Chart Type'")
	public void DA_PANEL_TC040_DataLabelsCheckboxStateCorrespondingToChartType() {
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

		Log.info("Step 7: Click 'Chart Type' drop-down menu and select 'Pie' Chart Type");
		panelPage.selectChartType("Pie");

		Log.info("VP: Check that 'Categories' checkbox is disabled, 'Series' checkbox, 'Value' checkbox and 'Percentage' checkbox are enabled");
		softAssert.assertTrue(panelPage.isDataLabelsCheckBoxesStateCorrect(true, false, true, true));
		
		Log.info("Step 8: Click 'Chart Type' drop-down menu and select 'Single Bar' Chart Type");
		panelPage.selectChartType("Single Bar");

		Log.info("VP: Check that 'Categories' checkbox is disabled, 'Series' checkbox, 'Value' checkbox and 'Percentage' checkbox are enabled");
		softAssert.assertTrue(panelPage.isDataLabelsCheckBoxesStateCorrect(true, false, true, true));
		
		Log.info("Step 9: Click 'Chart Type' drop-down menu and select 'Stacked Bar' Chart Type");
		panelPage.selectChartType("Stacked Bar");

		Log.info("VP: Check that 'Categories' checkbox, 'Series' checkbox, 'Value' checkbox and 'Percentage' checkbox are enabled");
		softAssert.assertTrue(panelPage.isDataLabelsCheckBoxesStateCorrect(true, true, true, true));
		
		Log.info("Step 10: Click 'Chart Type' drop-down menu and select 'Group Bar' Chart Type");
		panelPage.selectChartType("Group Bar");

		Log.info("VP: Check that 'Categories' checkbox, 'Series' checkbox, 'Value' checkbox and 'Percentage' checkbox are enabled");
		softAssert.assertTrue(panelPage.isDataLabelsCheckBoxesStateCorrect(true, true, true, true));
		
		Log.info("Step 11: Click 'Chart Type' drop-down menu and select 'Line' Chart Type");
		panelPage.selectChartType("Line");

		Log.info("VP: Check that 'Categories' checkbox, 'Series' checkbox, 'Value' checkbox and 'Percentage' checkbox are disabled");
		softAssert.assertTrue(panelPage.isDataLabelsCheckBoxesStateCorrect(false, false, false, false));
		softAssert.assertAll();
	}

	@AfterMethod
	private void cleanUp() {
		panelPage.cancelPanelDialog();
		homePage.deleteAllPagesByPath(Constant.PAGE_NAME1);
	}
}
