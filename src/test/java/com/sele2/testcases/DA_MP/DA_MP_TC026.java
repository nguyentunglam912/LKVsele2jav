package com.sele2.testcases.DA_MP;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sele2.support.Constant;
import com.sele2.helper.Log;
import com.sele2.testcases.testbase.TestBase;
import com.sele2.utils.listeners.TestListener;

import io.qameta.allure.Description;


@Listeners({ TestListener.class })
public class DA_MP_TC026 extends TestBase{
	/**
	 * DA_MP_TC026
	 * @author lam.tung.nguyen
	 */
	
	private Integer numberOfColumn1 = 2;
	private Integer numberOfColumn2 = 3;

	@Test
	@Description("Verify that page column is correct when user edit 'Number of Columns' field of a specific page")
	public void DA_MP_TC025_VerifyCorrectPageWhenEditDisplayAfter() {
		Log.info("Step 1: Navigate to Dashboard login page");
		goToDashboardLoginPage();

		Log.info("Step 2: Login with valid account");
		loginPage.login(Constant.REPOSITORY, Constant.VALID_USERNAME, Constant.VALID_PASSWORD);

		Log.info("Step 3: Go to Global Setting -> Add page");
		homePage.selectAddPageButtonInGlobalSettingMenu();

		Log.info("Step 4: Submit New Page with Page Name");
		newPage.submitNewPage(Constant.PAGE_NAME1, null, numberOfColumn1, null, null);

		Log.info("Step 5: Edit Number of Columns for the above created page");
		newPage.editPage(Constant.PAGE_NAME1, null, null, numberOfColumn2, null, null);

		Log.info("VP: There are 3 columns on the above created page");
		Assert.assertEquals(homePage.getNumberOfColumnOnPage(), numberOfColumn2);
	}

	@AfterMethod
	private void cleanUp() {
		Log.info("Delete newly added page");
		homePage.deletePage(Constant.PAGE_NAME1);
	}
}
