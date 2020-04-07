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
public class DA_MP_TC013 extends TestBase {
	/**
	 * DA_MP_TC013
	 *
	 * @author lam.tung.nguyen
	 */

	@Test
	@Description("Verify that the newly added main parent page is positioned \"\r\n"
			+ "			+ \"at the location specified as set with 'Displayed After' field of 'New Page' form on the main page bar'Parent Page' dropped down menu")
	public void DA_MP_TC013_CanAddPagesBesidesOverviewPage() {
		Log.info("Step 1: Navigate to Dashboard login page");
		goToDashboardLoginPage();

		Log.info("Step 2: Log in specific repository with valid account");
		loginPage.login(Constant.REPOSITORY, Constant.VALID_USERNAME, Constant.VALID_PASSWORD);

		Log.info("Step 3: Go to Global Setting -> Add page");
		homePage.selectAddPageButtonInGlobalSettingMenu();

		Log.info("Step 4: Submit New Page with Page Name");
		newPage.submitNewPage(Constant.PAGE_NAME1, null, null, null, null);

		Log.info("Step 5: Go to Global Setting -> Add page");
		homePage.selectAddPageButtonInGlobalSettingMenu();

		Log.info("Step 7: Submit New Page with Page Name and Displayed After");
		newPage.submitNewPage(Constant.PAGE_NAME2, null, null, Constant.PAGE_NAME1, null);

		Log.info("VP: Check Another Test page is positioned besides the Test page");
		Assert.assertTrue(homePage.isNewPageDisplayAfterPage(Constant.PAGE_NAME1, Constant.PAGE_NAME2));
	}

	@AfterMethod
	private void cleanUp(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			homePage.deleteAllPagesFromMenu(Constant.PAGE_NAME1);
			homePage.deleteAllPagesFromMenu(Constant.PAGE_NAME2);
		}
	}
}
