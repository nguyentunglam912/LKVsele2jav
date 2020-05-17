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
public class DA_MP_TC020 extends TestBase {
	/**
	 * DA_MP_TC020
	 * 
	 * @author khang.ha
	 */

	private String pagePath1 = Constant.OVERVIEW_PAGE + "/" + Constant.PAGE_NAME1;
	private String pagePath2 = pagePath1 + "/" + Constant.PAGE_NAME2;
	private String deleteErrorMessage = "Cannot delete page '"+ Constant.PAGE_NAME1 +"' since it has child page(s).";

	@Test
	@Description("Verify that user is able to delete sibbling page as long as that page has no children page under it")
	public void DA_MP_TC020_DeleteSiblingPage() {
		Log.info("Step 1: Navigate to Dashboard login page");
		goToDashboardLoginPage();

		Log.info("Step 2: Login with valid account");
		loginPage.login(Constant.REPOSITORY, Constant.VALID_USERNAME, Constant.VALID_PASSWORD);

		Log.info("Step 3: Go to Global Setting -> Add page");
		homePage.selectAddPageButtonInGlobalSettingMenu();

		Log.info("Step 4: Enter info into all required fields on New Page dialog");
		newPage.submitNewPage(Constant.PAGE_NAME1, Constant.OVERVIEW_PAGE, null, null, null);

		Log.info("Step 5: Go to Global Setting -> Add page");
		homePage.selectAddPageButtonInGlobalSettingMenu();

		Log.info("Step 6: Enter info into all required fields on New Page dialog");
		newPage.submitNewPage(Constant.PAGE_NAME2, Constant.PAGE_NAME1, null, Constant.PAGE_NAME1, null);

		Log.info("Step 7: Go to the first created page");
		homePage.goToPage(pagePath1);

		Log.info("Step 8: Click Delete link");
		Log.info("Step 9: Click Ok button on Confirmation Delete page");
		homePage.deletePage(pagePath1);

		Log.info("VP: There is a message 'Cannot delete page \"page 1\" since it has child page(s).\"");
		softAssert.assertEquals(homePage.getErrorMessage(), this.deleteErrorMessage);

		Log.info("Step 10: Close confirmation dialog");
		generalPage.closePopupMessage();

		Log.info("Step 11: Go to the second page");
		homePage.goToPage(pagePath2);

		Log.info("Step 12: Click Delete link");
		Log.info("Step 13: Click Ok button on Confirmation Delete page");
		homePage.deletePage(pagePath2);

		Log.info("VP: Page 2 is deleted successfully");
		softAssert.assertEquals(homePage.getCurrentPage(), Constant.OVERVIEW_PAGE);
	}

	@AfterMethod
	private void cleanUp() {
		homePage.deleteAllPagesByPath(pagePath1);
	}

}
