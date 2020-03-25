package com.sele2.testcases.DA_LOGIN;

import org.testng.annotations.Test;
import org.testng.annotations.Listeners;

import com.sele2.pages.HomePage;
import com.sele2.pages.LoginPage;
import com.sele2.support.Constant;
import com.sele2.support.Log;
import com.sele2.testcases.testbase.TestBase;

import io.qameta.allure.*;
import com.sele2.utils.listeners.TestListener;

@Listeners({ TestListener.class })
public class DA_LOGIN_TC004 extends TestBase {
	/**
	 * DA_LOGIN_TC006
	 * @author khang.ha
	 */

	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();

	@Test
    @Description("Test Description: Verify that user is able to log in different repositories successfully after logging out current repository")
	public void DA_LOGIN_TC004_SwitchRepoAfterLoggingOut() {
		Log.info("Step 1: Navigate to Dashboard login page");
		goToDashboardLoginPage();

		Log.info("Step 2: Enter invalid username and password");
		Log.info("Step 3: Click on Login button");
		loginPage.login(Constant.REPOSITORY, Constant.VALID_USERNAME, Constant.VALID_PASSWORD);

		Log.info("Step 4: Logout TA Dashboard");
		homePage.logOut();

		Log.info("Step 5: Select a different repository");
		Log.info("Step 6: Enter valid username and password of this repository");
		loginPage.login(Constant.REPOSITORY2, Constant.VALID_USERNAME, Constant.VALID_PASSWORD);

		Log.info("VP: Verify that Dashboard Mainpage appears");
		loginPage.checkLoginSuccessfully();
		}
	}
