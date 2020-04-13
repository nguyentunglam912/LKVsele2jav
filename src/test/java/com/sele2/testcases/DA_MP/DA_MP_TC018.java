package com.sele2.testcases.DA_MP;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sele2.support.Constant;
import com.sele2.helper.Log;
import com.sele2.testcases.testbase.TestBase;
import com.sele2.utils.listeners.TestListener;

import io.qameta.allure.Description;

@Listeners({ TestListener.class })
public class DA_MP_TC018 extends TestBase {
	/**
	 * DA_MP_TC017
	 * 
	 * @author khang.ha
	 */

	private String pagePath1 = Constant.OVERVIEW_PAGE + "/" + Constant.PAGE_NAME1;
	private String pagePath3 = pagePath1 + "/" + Constant.PAGE_NAME3;
	
	@Test
	@Description("Verify that user is able to add additional sibbling pages to the parent page successfully")
	public void DA_MP_TC020_AdditionalSiblingPage() {
		Log.info("Step 1: Navigate to Dashboard login page");
		goToDashboardLoginPage();

		Log.info("Step 2: Login with valid account");
		loginPage.login(Constant.REPOSITORY, Constant.VALID_USERNAME, Constant.VALID_PASSWORD);
		
		Log.info("Step 3: Go to Global Setting -> Add page");
		homePage.selectAddPageButtonInGlobalSettingMenu();
		
		Log.info("Step 4: Enter info into all required fields on New Page dialog");
		Log.info("Step 5: Click OK button");
		newPage.submitNewPage(Constant.PAGE_NAME1, Constant.OVERVIEW_PAGE, null, null, null);
		
		Log.info("Step 5: Go to Global Setting -> Add page");
		homePage.selectAddPageButtonInGlobalSettingMenu();
		
		Log.info("Step 6: Enter Page Name");
		Log.info("Step 7: Click on  Parent Page dropdown list");
		Log.info("Step 8: Select a parent page");
		Log.info("Step 9: Click OK button");
		newPage.submitNewPage(Constant.PAGE_NAME2, Constant.PAGE_NAME1, null, Constant.PAGE_NAME1, null);
		
		Log.info("Step 10: Go to Global Setting -> Add page");
		homePage.selectAddPageButtonInGlobalSettingMenu();
		
		Log.info("Step 11: Enter Page Name");
		Log.info("Step 12: Click on  Parent Page dropdown list");
		Log.info("Step 13: Select a parent page");
		Log.info("Step 14: Click OK button");
		newPage.submitNewPage(Constant.PAGE_NAME3, Constant.PAGE_NAME1, null, Constant.PAGE_NAME1, null);
		
		Log.info("VP: Check \"Test Child 2\" is added successfully");
		homePage.goToPage(pagePath3);
		Assert.assertEquals(homePage.getCurrentPage(), Constant.PAGE_NAME3);
		
	}

}
