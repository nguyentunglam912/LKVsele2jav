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
public class DA_PANEL_TC055 extends TestBase {
	/**
	 * DA_PANEL_TC055
	 *
	 * @author lam.tung.nguyen
	 */

	String invalidFolderPath = "/Car Rental/Actions/abc";

	@Test
	@Description("Verify that user is unable to edit 'Folder' field with invalid path")
	public void DA_PANEL_TC055_CannotEditFolderWithInvalidPath() {
		Log.info("Step 1: Navigate to Dashboard login page");
		goToDashboardLoginPage();

		Log.info("Step 2: Login with valid account");
		loginPage.login(Constant.REPOSITORY, Constant.VALID_USERNAME, Constant.VALID_PASSWORD);

		Log.info("Step 3: Create new page");
		homePage.selectAddPageButtonInGlobalSettingMenu();
		newPage.submitNewPage(Constant.PAGE_NAME1, null , null, null, null);

		Log.info("Step 4: Create a new panel");
		homePage.selectChoosePanelsMenu();
		choosePanels.clickCreateNewPanel();
		panelPage.submitPanelForm(null, Constant.PANEL_NAME, Constant.SERIES, null, null);
		panelPage.configPanel(null, null, null);

		Log.info("Step 5: Click on the newly created panel link under Choose Panels");
		choosePanels.selectChartPanelInChoosePanels(Constant.PANEL_NAME);

		Log.info("Step 6: Enter invalid folder path in Config Panel and click OK");
		panelPage.configPanel(null, null, this.invalidFolderPath);

		Log.info("VP: User is unable to edit 'Folder' field with invalid path");
		softAssert.assertTrue(panelPage.doesConfigPanelDisplay());
	}

	@AfterMethod
	private void cleanUp() {
		panelPage.cancelConfigPanel();
		homePage.selectPanelinAdministerMenu();
		panelPage.deletePanel(Constant.PANEL_NAME);
		homePage.deletePage(Constant.PAGE_NAME1);
	}
}
