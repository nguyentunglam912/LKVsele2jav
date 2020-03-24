package com.sele2.pages;

import org.testng.Assert;

import com.sele2.elements.Button;
import com.sele2.elements.Checkbox;
import com.sele2.elements.Combobox;
import com.sele2.elements.TextBox;

import io.qameta.allure.Step;

public class NewPage extends HomePage{
	TextBox txtPageName = new TextBox("id=name");
	Combobox cmbParentPage = new Combobox("id=parent");
	Combobox cmbNumberOfColumn = new Combobox("id=columnnumber");
	Combobox cmbDisplayAfter = new Combobox("id=afterpage");
	Checkbox chkIsPublic = new Checkbox("id=ispublic");
	Button btnOk = new Button("id=OK");
	Button btnCancel = new Button("id=Cancel");

	
	private void fillNewPageInformation(String pageName, String parentPage,
			String numberOfColumn, String displayAfter, Boolean isPublic){
		driverUtils.waitForPageLoad();
		txtPageName.sendKeys(pageName);
		cmbParentPage.selectBySpecialText(numberOfColumn);
		cmbDisplayAfter.selectBySpecialText(displayAfter);
		chkIsPublic.selectValue(isPublic);
	}

	@Step("Enter info into New Page dialog and click OK button")
	public void submitNewPage(String pageName, String parentPage,
			String numberOfColumn, String displayAfter, Boolean isPublic) throws InterruptedException {
		fillNewPageInformation(pageName, parentPage, numberOfColumn, displayAfter, isPublic);
		btnOk.moveMouse();
		btnOk.click();
		driverUtils.waitForPageLoad();
	}

	@Step("Check '{1}' page is displayed besides '{0}' page")
	public void checkNewPageDisplayAfterPage(String displayAfterPage, String newPage) {
		Button newAddedPage = new Button(String.format("//li[a[text()='%s']]/following::li[a[text()='%s']]", displayAfterPage, newPage));
		Assert.assertTrue(newAddedPage.size() != 0);
	}
}
