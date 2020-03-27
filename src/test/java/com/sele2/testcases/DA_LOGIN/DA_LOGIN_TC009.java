package com.sele2.testcases.DA_LOGIN;

import com.sele2.pages.LoginPage;
import com.sele2.support.Constant;
import com.sele2.support.Log;
import com.sele2.testcases.testbase.TestBase;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class DA_LOGIN_TC009 extends TestBase{
    /**
     * DA_LOGIN_TC009 - Verify that username with special characters is working correctly
     * @author vi.dao
     */

    private LoginPage loginPage = new LoginPage();

    @Test(description = "Verify that username with special characters is working correctly")
    @Description("Test Description: Verify that username with special characters is working correctly")
    public void DA_LOGIN_TC009_LoginWithUsernameContainSpecialCharacter(){

        Log.info("Step 1: Go to dashboard");
        goToDashboardLoginPage();

        Log.info("Step 2: Login with an account whose username containing special character");
        loginPage.login(Constant.REPOSITORY, Constant.TC009_USERNAME, Constant.TC009_PASSWORD);

        Log.info("VP: Verify main page is displayed");
        loginPage.checkLoginSuccessfully();
    }
}
