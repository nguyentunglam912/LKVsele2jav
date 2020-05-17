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
public class DA_PANEL_TC035 extends TestBase {
	/**
	 * DA_PANEL_TC035
	 *
	 * @author lam.tung.nguyen
	 */
	
	private String chartTitleExceptAtSign = "Chart#$";
	private String chartTitleWithAtSign = "Chart@";
	private String invalidChartTitleMessage = "Invalid title name. The name cannot contain high ASCII characters or any of the following characters: /:*?<>|\\\"#[]{}=%;";

	@Test
	@Description("Verify that no special character except '@' character is allowed to be inputted into 'Chart Title' field")
	public void DA_PANEL_TC035_NoSpecialCharExceptAtSignChartTitle() {
		Log.info("Step 1: Navigate to Dashboard login page");
		goToDashboardLoginPage();

		Log.info("Step 2: Login with valid account");
		loginPage.login(Constant.REPOSITORY, Constant.VALID_USERNAME, Constant.VALID_PASSWORD);

		Log.info("Step 3: Click on Administer/Panels link");
		homePage.selectPanelinAdministerMenu();

		Log.info("Step 4: Click Add New link");
		panelPage.selectAddNewButtonOnPanel();
		
		Log.info("Step 5: Enter value into Display Name field and Chart title except at sign, click OK");
		panelPage.submitPanelForm(null, Constant.PANEL_NAME, Constant.SERIES, null, this.chartTitleExceptAtSign);
		
		Log.info("VP: Verify Message 'Invalid title name. The name cannot contain high ASCII characters or any of the following characters: /:*?<>|\"#[]{}=%;' is displayed");
		softAssert.assertEquals(panelPage.getWarningMessageOnPanels(), this.invalidChartTitleMessage);
		
		Log.info("Step 6: Close warning message");
		panelPage.closePopupMessage();
		
		Log.info("Step 7: Enter value into Display Name field and Chart title with at sign, click OK");
		panelPage.submitPanelForm(null, Constant.PANEL_NAME, Constant.SERIES, null, this.chartTitleWithAtSign);
		
		Log.info("VP: Check The new panel is created");
		softAssert.assertTrue(panelPage.isNewPanelExisted(Constant.PANEL_NAME));
	}

	@AfterMethod
	private void cleanUp() {
		panelPage.deletePanel(Constant.PANEL_NAME);

	}
}
