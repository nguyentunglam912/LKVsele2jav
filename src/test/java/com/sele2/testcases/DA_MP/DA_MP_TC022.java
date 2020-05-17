package com.sele2.testcases.DA_MP;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sele2.support.Constant;
import com.sele2.helper.Log;
import com.sele2.testcases.testbase.TestBase;
import com.sele2.utils.listeners.TestListener;

import io.qameta.allure.Description;

@Listeners({ TestListener.class })
public class DA_MP_TC022 extends TestBase {
	/**
	 * DA_MP_TC022
	 * 
	 * @author khang.ha
	 */

	private String DuplicateErrorMessage = Constant.PAGE_NAME2 +" already exists. Please enter a different name.";

	@Test
	@Description("Verify that user is unable to duplicate the name of sibbling page under the same parent page")
	public void DA_MP_TC022_UnableToDuplicateSiblingName() {
		Log.info("Step 1: Navigate to Dashboard login page");
		goToDashboardLoginPage();

		Log.info("Step 2: Login with valid account");
		loginPage.login(Constant.REPOSITORY, Constant.VALID_USERNAME, Constant.VALID_PASSWORD);

		Log.info("Step 3: Go to Global Setting -> Add page");
		homePage.selectAddPageButtonInGlobalSettingMenu();

		Log.info("Step 4: Enter info into all required fields on New Page dialog and click OK");
		newPage.submitNewPage(Constant.PAGE_NAME1, null, null, null, null);

		Log.info("Step 5: Go to Global Setting -> Add page");
		homePage.selectAddPageButtonInGlobalSettingMenu();

		Log.info("Step 6: Enter Page Name, select Parent Page and click OK");
		newPage.submitNewPage(Constant.PAGE_NAME2, Constant.PAGE_NAME1, null, null, null);

		Log.info("Step 7: Go to Global Setting -> Add page");
		homePage.selectAddPageButtonInGlobalSettingMenu();

		Log.info("Step 8: Enter Page Name, select Parent Page and click OK");
		newPage.submitNewPage(Constant.PAGE_NAME2, Constant.PAGE_NAME1, null, null, null);
		
		Log.info("VP: There is a message  'Test Child 1 already exist. Please enter a diffrerent name.'");
		softAssert.assertEquals(homePage.getErrorMessage(), this.DuplicateErrorMessage);
	}
	
	@AfterMethod
	private void cleanUp() {
		newPage.cancelAddPage();
		homePage.deleteAllPagesByPath(Constant.PAGE_NAME1 +"/"+ Constant.PAGE_NAME2);
	}

}
