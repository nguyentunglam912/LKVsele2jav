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
public class DA_MP_TC013 extends TestBase{
	/**
	 * DA_MP_TC013
	 * @author lam.tung.nguyen
	 */

	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();

	@Test(groups = "DA_MP")
	@Description("Verify that the newly added main parent page is positioned \"\r\n" + 
			"			+ \"at the location specified as set with 'Displayed After' field of 'New Page' form on the main page bar'Parent Page' dropped down menu")
	public void DA_MP_TC013_CanAddPagesBesidesOverviewPage() {
		Log.info("Step 1: Navigate to Dashboard login page");
		goToDashboardLoginPage();

		Log.info("Step 2: Log in specific repository with valid account");
		loginPage.login(Constant.REPOSITORY, Constant.VALID_USERNAME, Constant.VALID_PASSWORD);
		
		Log.info("Step 3: Go to Global Setting -> Add page");
		homePage.selectAddPageButtonInGlobalSettingMenu();
		
		Log.info("Step 4: Submit New Page with Page Name");
		homePage.submitNewPage(Constant.PAGE_NAME1, Constant.NULL, Constant.NULL, Constant.NULL, false);

		Log.info("Step 5: Go to Global Setting -> Add page");
		homePage.selectAddPageButtonInGlobalSettingMenu();

		Log.info("Step 7: Submit New Page with Page Name and Displayed After");
		homePage.submitNewPage(Constant.PAGE_NAME2, Constant.NULL, Constant.NULL, Constant.PAGE_NAME1, false);

		Log.info("VP: Check Another Test page is positioned besides the Test page");
		homePage.checkNewPageDisplayAfterPage(Constant.PAGE_NAME1, Constant.PAGE_NAME2);
	}
}
