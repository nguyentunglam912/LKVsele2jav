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
public class DA_LOGIN_TC010 extends TestBase{
	/**
	 * DA_LOGIN_TC010
	 * @author vi.dao
	 */

	LoginPage loginPage = new LoginPage();

	@Test(description = "Verify that the page works correctly for the case when no input entered to Password and Username field")
	@Description("Test Description: Verify that the page works correctly for the case when no input entered to Password and Username field")
	public void DA_LOGIN_TC0010_LoginWithEmptyUsernameAndPassword() {
		Log.info("Step 1: Open Dash Board's login page");
		goToDashboardLoginPage();

		Log.info("Step 2: Click Login button without entering username and password");
		loginPage.login(Constant.REPOSITORY, Constant.BLANK_USERNAME, Constant.BLANK_PASSWORD);

		Log.info("VP: Verify the error message 'Please enter username!' is displayed");
		loginPage.checkLoginErrorMessage(Constant.ERROR_MESSAGE_PLEASE_ENTER_USERNAME);
	}
}