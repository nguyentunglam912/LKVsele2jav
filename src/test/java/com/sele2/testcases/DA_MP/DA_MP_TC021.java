package com.sele2.testcases.DA_MP;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sele2.support.Constant;
import com.sele2.helper.Log;
import com.sele2.testcases.testbase.TestBase;
import com.sele2.utils.listeners.TestListener;

import io.qameta.allure.Description;

@Listeners({ TestListener.class })
public class DA_MP_TC021 extends TestBase {
	/**
	 * DA_MP_TC021
	 * 
	 * @author khang.ha
	 */

	private String pagePath1 = Constant.OVERVIEW_PAGE + "/" + Constant.PAGE_NAME1;
	private String pagePath2 = pagePath1 + "/" + Constant.PAGE_NAME2;
	private String pagePath3 = Constant.OVERVIEW_PAGE + "/" + Constant.PAGE_NAME3;
	private String pagePath4 = pagePath3 + "/" + Constant.PAGE_NAME4;

	@Test
	@Description("Verify that user is able to edit the name of the page (Parent/Sibbling) successfully")
	public void DA_MP_TC021_CanEditNameSuccessfully() {
		Log.info("Step 1: Navigate to Dashboard login page");
		goToDashboardLoginPage();

		Log.info("Step 2: Login with valid account");
		loginPage.login(Constant.REPOSITORY, Constant.VALID_USERNAME, Constant.VALID_PASSWORD);

		Log.info("Step 3: Go to Global Setting -> Add page");
		homePage.selectAddPageButtonInGlobalSettingMenu();

		Log.info("Step 4: Enter info into all required fields on New Page dialog and click OK");
		newPage.submitNewPage(Constant.PAGE_NAME1, Constant.OVERVIEW_PAGE, null, null, null);

		Log.info("Step 5: Go to Global Setting -> Add page");
		homePage.selectAddPageButtonInGlobalSettingMenu();

		Log.info("Step 6: Enter Page Name, check public checkbox and click OK");
		newPage.submitNewPage(Constant.PAGE_NAME2, Constant.PAGE_NAME1, null, null, null);

		Log.info("Step 7: Click on " + Constant.PAGE_NAME2 + " page, click on Edit link, change name and click OK");
		newPage.editPage(pagePath2, Constant.PAGE_NAME4, Constant.PAGE_NAME1, null, null, null);
		
		Log.info("VP: Verify page name is changed");
		softAssert.assertEquals(homePage.getCurrentPage(), Constant.PAGE_NAME4);
		softAssert.assertAll();
		
		Log.info("Step 8: Click on " + Constant.PAGE_NAME1 + " page, click on Edit link, change name and click OK");
		newPage.editPage(pagePath1, Constant.PAGE_NAME3, Constant.OVERVIEW_PAGE, null, null, null);
		
		Log.info("VP: Verify page name is changed");
		softAssert.assertEquals(homePage.getCurrentPage(), Constant.PAGE_NAME3);
	}
	
	@AfterMethod
	private void cleanUp() {
		homePage.deletePage(pagePath4);
		homePage.deletePage(pagePath3);
	}
}
