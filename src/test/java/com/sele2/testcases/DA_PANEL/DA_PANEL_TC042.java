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
public class DA_PANEL_TC042 extends TestBase {
	/**
	 * DA_PANEL_TC042
	 *
	 * @author lam.tung.nguyen
	 */

	String[] listCreatedPages = {Constant.PAGE_NAME1, Constant.PAGE_NAME2, Constant.PAGE_NAME3};

	@Test
	@Description("Verify that all pages are listed correctly under the 'Select page *' dropped down menu of 'Panel Configuration' form control")
	public void DA_PANEL_TC042_AllPagesListedUnderSelectPageDropdownMenu() {
		Log.info("Step 1: Navigate to Dashboard login page");
		goToDashboardLoginPage();

		Log.info("Step 2: Login with valid account");
		loginPage.login(Constant.REPOSITORY, Constant.VALID_USERNAME, Constant.VALID_PASSWORD);

		Log.info("Step 3: Click Add page button");
		homePage.selectAddPageButtonInGlobalSettingMenu();

		Log.info("Step 4: Submit New Page 1 with Page Name");
		newPage.submitNewPage(Constant.PAGE_NAME1, null, null, null, null);

		Log.info("Step 5: Click Add page button");
		homePage.selectAddPageButtonInGlobalSettingMenu();

		Log.info("Step 6: Submit New Page 2 with Page Name");
		newPage.submitNewPage(Constant.PAGE_NAME2, null, null, null, null);

		Log.info("Step 7: Click Add page button");
		homePage.selectAddPageButtonInGlobalSettingMenu();

		Log.info("Step 8: Submit New Page 3 with Page Name");
		newPage.submitNewPage(Constant.PAGE_NAME3, null, null, null, null);

		Log.info("Step 9: Click 'Choose panels' button");
		homePage.selectChoosePanelsMenu();

		Log.info("Step 10: Click on any Chart panel instance");
		choosePanels.selectChartPanelInChoosePanels(Constant.CHART_PANEL);

		Log.info("Step 11: Click 'Select Page*' drop-down menu");
		Log.info("VP: Check that 'Select Page*' drop-down menu contains 3 created items");
		softAssert.assertTrue(panelPage.doesOptionsExistInSelectPageCombobox(this.listCreatedPages));
	}

	@AfterMethod
	private void cleanUp() {
		panelPage.cancelPanelDialog();
		panelPage.deletePage(Constant.PAGE_NAME1);
		panelPage.deletePage(Constant.PAGE_NAME2);
		panelPage.deletePage(Constant.PAGE_NAME3);
	}
}
