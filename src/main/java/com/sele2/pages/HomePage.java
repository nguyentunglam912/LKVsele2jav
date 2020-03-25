package com.sele2.pages;

import org.testng.Assert;

import com.sele2.elements.BaseElement;
import com.sele2.elements.Button;
import com.sele2.elements.Checkbox;
import com.sele2.elements.Combobox;
import com.sele2.elements.TextBox;
import com.sele2.support.DriverUtils;

import io.qameta.allure.Step;

public class HomePage extends GeneralPage{

	TextBox txtPageName = new TextBox("id=name");
	Combobox cmbParentPage = new Combobox("id=parent");
	Combobox cmbNumberOfColumn = new Combobox("id=columnnumber");
	Combobox cmbDisplayAfter = new Combobox("id=afterpage");
	Checkbox chkIsPublic = new Checkbox("id=ispublic");
	Button btnOk = new Button("id=OK");
	Button btnCancel = new Button("id=Cancel");

	public void checkGlobalSettingMenuDoesNotDisplay() {
		BaseElement menu = new BaseElement(String.format(dynamicMenuItems, "Global Setting"));
		Assert.assertFalse(menu.size() != 0);
	}

	private void fillNewPageInformation(String pageName, String parentPage,
			String numberOfColumn, String displayAfter, Boolean isPublic){
		utils.waitForPageLoad();
		txtPageName.sendKeys(pageName);
		cmbParentPage.selectBySpecialText(parentPage);
		cmbNumberOfColumn.selectBySpecialText(numberOfColumn);
		cmbDisplayAfter.selectBySpecialText(displayAfter);
		chkIsPublic.selectValue(isPublic);
	}

	@Step("Enter info into New Page dialog and click OK button")
	public void submitNewPage(String pageName, String parentPage,
			String numberOfColumn, String displayAfter, Boolean isPublic) {
		fillNewPageInformation(pageName, parentPage, numberOfColumn, displayAfter, isPublic);
		btnOk.moveMouse();
		btnOk.click();
		utils.waitForPageStable();
	}

	@Step("Check '{1}' page is displayed besides '{0}' page")
	public void checkNewPageDisplayAfterPage(String displayAfterPage, String newPage) {
		Button newAddedPage = new Button(String.format("//li[a[text()='%s']]/following::li[a[text()='%s']]", displayAfterPage, newPage));
		Assert.assertTrue(newAddedPage.size() != 0);
	}
	
	@Step("Check '{0}' is navigated")
	public void checkPageNavigated(String pageName) {
		String expectedTitle = String.format("TestArchitect ™ - %s", pageName);
		String actualTitle = DriverUtils.driver.getTitle();
		Assert.assertTrue(actualTitle.contains(expectedTitle));
	}

	@Step("Logout TA Dashboard")
	public void logOut() {
		selectOptionInMenu("Profile", "Logout");
	}
}
