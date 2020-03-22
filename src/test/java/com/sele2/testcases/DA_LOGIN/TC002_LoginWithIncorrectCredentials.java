package com.sele2.testcases.DA_LOGIN;

import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import com.sele2.pages.LoginPage;
import com.sele2.support.Constant;
import com.sele2.support.Log;
import com.sele2.testcases.testbase.TestBase;

import io.qameta.allure.*;
import com.sele2.utils.listeners.TestListener;

@Listeners({ TestListener.class })
public class TC002_LoginWithIncorrectCredentials extends TestBase{
	/**
	 * DA_LOGIN_TC002 - Verify that user fails to login specific repository successfully via Dashboard login page with incorrect credentials
	 * @author lam.tung.nguyen
	 */

	LoginPage loginPage = new LoginPage();

	@Test(description = "DA_LOGIN_TC002 - Verify that user fails to login specific repository successfully via Dashboard login page with incorrect credentials")
	@Description("Test Description: Verify that user fails to login specific repository successfully via Dashboard login page with incorrect credentials")
	public void TC002() {
		Log.info("Step 1: Navigate to Dashboard login page");
		goToDashboardLoginPage();

		Log.info("Step 2: Enter invalid username and password");
		Log.info("Step 3: Click on Login button");
		loginPage.login(Constant.REPOSITORY, Constant.INVALID_USERNAME, Constant.INVALID_PASSWORD);

		Log.info("VP: Verify that Dashboard Error message 'Username or password is invalid' appears");
		loginPage.checkLoginErrorMessage(Constant.LOGIN_ERROR_MESSAGE);
	}
}