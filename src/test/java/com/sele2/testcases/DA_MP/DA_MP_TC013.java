package com.sele2.testcases.DA_MP;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sele2.pages.HomePage;
import com.sele2.pages.LoginPage;
import com.sele2.pages.NewPage;
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
	NewPage newPage = new NewPage();

	@Test
	@Description("Verify that the newly added main parent page is positioned \"\r\n" + 
			"			+ \"at the location specified as set with 'Displayed After' field of 'New Page' form on the main page bar'Parent Page' dropped down menu")
	public void DA_MP_TC013_CanAddPagesBesidesOverviewPage() throws InterruptedException {
		Log.info("Step 1: Navigate to Dashboard login page");
		goToDashboardLoginPage();

		Log.info("Step 2: Log in specific repository with valid account");
		loginPage.login(Constant.REPOSITORY, Constant.VALID_USERNAME, Constant.VALID_PASSWORD);
		
		Log.info("Step 3: Go to Global Setting -> Add page");
		homePage.deleteAllPages("Tes1");

		
		
	}
}
