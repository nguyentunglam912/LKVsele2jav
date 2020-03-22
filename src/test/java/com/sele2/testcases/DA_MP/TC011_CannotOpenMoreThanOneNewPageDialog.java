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
public class TC011_CannotOpenMoreThanOneNewPageDialog extends TestBase{
	/**
	 * DA_MP_TC011
	 * @author lam.tung.nguyen
	 */

	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();

	@Test(description = "DA_MP_TC011 - Verify that user is unable open more than 1 'New Page' dialog")
	@Description("Verify that user is unable open more than 1 'New Page' dialog")
	public void TC011() {
		Log.info("Step 1: Navigate to Dashboard login page");
		goToDashboardLoginPage();

		Log.info("Step 2: Login with valid account");
		loginPage.login(Constant.REPOSITORY, Constant.VALID_USERNAME, Constant.VALID_PASSWORD);
		
		Log.info("Step 3: Go to Global Setting -> Add page");
		homePage.selectAddPageButtonInGlobalSettingMenu();
		
		Log.info("Step 4: Try to go to Global Setting -> Add page again");
		homePage.selectAddPageButtonInGlobalSettingMenu();

		Log.info("VP: User cannot go to Global Setting -> Add page while 'New Page' dialog appears.");
		
	}
}
