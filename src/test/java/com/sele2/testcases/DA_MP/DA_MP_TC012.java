package com.sele2.testcases.DA_MP;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sele2.pages.HomePage;
import com.sele2.pages.LoginPage;
import com.sele2.support.Constant;
import com.sele2.support.Log;
import com.sele2.testcases.testbase.TestBase;
import com.sele2.utils.listeners.TestListener;

import io.qameta.allure.Description;


@Listeners({ TestListener.class })
public class DA_MP_TC012 extends TestBase{
	/**
	 * DA_MP_TC012
	 * @author lam.tung.nguyen
	 */

	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();

	@Test
	@Description("Verify that user is able to add additional pages besides 'Overview' page successfully")
	public void DA_MP_TC012_CanAddPagesBesidesOverviewPage() {
		Log.info("Step 1: Navigate to Dashboard login page");
		goToDashboardLoginPage();

		Log.info("Step 2: Login with valid account");
		loginPage.login(Constant.REPOSITORY, Constant.VALID_USERNAME, Constant.VALID_PASSWORD);
		
		Log.info("Step 3: Go to Global Setting -> Add page");
		homePage.selectAddPageButtonInGlobalSettingMenu();
		
		Log.info("Step 4: Enter Page Name field");
		Log.info("Step 5: Click Ok button");
		homePage.submitNewPage(Constant.PAGE_NAME1, Constant.NULL, Constant.NULL, Constant.NULL, false);

		Log.info("VP: Check new page is displayed besides 'Overview' page");
		homePage.checkNewPageDisplayAfterPage(Constant.OVERVIEW_PAGE, Constant.PAGE_NAME1);
	}
}
