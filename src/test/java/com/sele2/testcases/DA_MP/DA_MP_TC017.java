package com.sele2.testcases.DA_MP;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sele2.support.Constant;
import com.sele2.helper.Log;
import com.sele2.testcases.testbase.TestBase;
import com.sele2.utils.listeners.TestListener;

import io.qameta.allure.Description;

@Listeners({ TestListener.class })
public class DA_MP_TC017 extends TestBase {
	/**
	 * DA_MP_TC017
	 * 
	 * @author khang.ha
	 */

	private String pagePath1 = Constant.OVERVIEW_PAGE + "/" + Constant.PAGE_NAME1;
	private String pagePath2 = pagePath1 + "/" + Constant.PAGE_NAME2;
	private String deleteErrorMessage = "Cannot delete page '"+ Constant.PAGE_NAME1 +"' since it has child page(s).";

	@Test
	@Description("Verify that user can remove any main parent page except 'Overview' page successfully and the order of pages stays persistent as long as there is not children page under it")
	public void DA_MP_TC017_CannotDeleteOverviewPage() {
		Log.info("Step 1: Navigate to Dashboard login page");
		goToDashboardLoginPage();

		Log.info("Step 2: Login with valid account");
		loginPage.login(Constant.REPOSITORY, Constant.VALID_USERNAME, Constant.VALID_PASSWORD);
		
		Log.info("Step 3: Add a new parent page");
		homePage.selectAddPageButtonInGlobalSettingMenu();
		newPage.submitNewPage(Constant.PAGE_NAME1, Constant.OVERVIEW_PAGE, null, null, null);
		
		Log.info("Step 4: Add a children page of newly added page");
		homePage.selectAddPageButtonInGlobalSettingMenu();
		newPage.submitNewPage(Constant.PAGE_NAME2, Constant.PAGE_NAME1, null, Constant.PAGE_NAME1, null);
		
		Log.info("Step 5: Click on parent page");
		homePage.goToPage(pagePath1);
		
		Log.info("Step 6: Click 'Delete' link, Check confirm message 'Are you sure you want to remove this page?' appears and click OK ");
		homePage.deletePage(pagePath1);
		
		Log.info("VP: There is a message 'Cannot delete page 'page 1' since it has child page(s).'");
		Assert.assertEquals(homePage.getErrorMessage(), this.deleteErrorMessage);
		
		Log.info("Step 7: Click OK button");
		generalPage.closePopupMessage();
		
		Log.info("Step 8: Go to the children page");
		homePage.goToPage(pagePath2);
		
		Log.info("Step 9: Click 'Delete' link, Check confirm message 'Are you sure you want to remove this page?' appears and click OK");
		homePage.deletePage(pagePath2);
		
		Log.info("VP: children page is deleted successfully");
		Assert.assertEquals(homePage.getCurrentPage(), Constant.OVERVIEW_PAGE);
		
		Log.info("Step 10: Click on parent page");
		homePage.goToPage(pagePath1);
		
		Log.info("Step 11: Click 'Delete' link, Check confirm message 'Are you sure you want to remove this page?' appears and click OK");
		homePage.deletePage(pagePath1);
		
		Log.info("VP: parent page is deleted successfully");
		softAssert.assertEquals(homePage.getCurrentPage(), Constant.OVERVIEW_PAGE);
		
		Log.info("VP: delete link is not present on Overview page");
		softAssert.assertFalse(homePage.doesItemExistInGlobalSettingMenu("Delete",""));
		softAssert.assertAll();
	}
}