package com.sele2.testcases.DA_LOGIN;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import com.sele2.support.Constant;
import com.sele2.helper.Log;
import com.sele2.testcases.testbase.TestBase;

import io.qameta.allure.*;
import com.sele2.utils.listeners.TestListener;

@Listeners({ TestListener.class })
public class DA_LOGIN_TC003 extends TestBase{
	/**
	 * DA_LOGIN_TC003
	 * @author lam.tung.nguyen
	 */

	@Test
	@Description("Test Description: Verify that user fails to log in specific repository successfully via Dashboard login page with correct username and incorrect password")
	public void DA_LOGIN_TC003_LoginWithIncorrectPassword() {
		Log.info("Step 1: Navigate to Dashboard login page");
		goToDashboardLoginPage();

		Log.info("Step 2: Enter valid username and invalid password");
		Log.info("Step 3: Click on Login button");
		loginPage.login(Constant.REPOSITORY, Constant.VALID_USERNAME, Constant.INVALID_PASSWORD);

		Log.info("VP: Verify that Dashboard Error message 'Username or password is invalid' appears");
		Assert.assertEquals(loginPage.getLoginErrorMessage(), Constant.ERROR_MESSAGE_INVALID_USERNAME_OR_PASSWORD);
	}
}
