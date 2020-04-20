package com.sele2.pages;

import com.sele2.elements.Button;
import com.sele2.elements.Checkbox;
import com.sele2.elements.Combobox;
import com.sele2.elements.TextBox;

import io.qameta.allure.Step;

public class NewPage extends HomePage{
	private TextBox txtPageName 		= new TextBox("id=name");
	private Combobox cmbParentPage 		= new Combobox("id=parent");
	private Combobox cmbNumberOfColumn 	= new Combobox("id=columnnumber");
	private Combobox cmbDisplayAfter 	= new Combobox("id=afterpage");
	private Checkbox chkIsPublic 		= new Checkbox("id=ispublic");
	private Button btnOk 				= new Button("//div[@id='div_popup']//input[@id='OK']");
	private Button btnCancel            = new Button("//input[@id='Cancel']");

	public void fillNewPageInfo(String pageName, String parentPage, Integer numberOfColumn, String displayAfter, Boolean isPublic){
		utils.waitForPageStable();
		if(pageName != null) txtPageName.sendKeys(pageName);
		cmbParentPage.selectBySpecialText(parentPage);
		if(numberOfColumn != null) cmbNumberOfColumn.selectByValue(numberOfColumn.toString());
		cmbDisplayAfter.selectBySpecialText(displayAfter);
		if(isPublic != null) chkIsPublic.selectValue(isPublic);
	}

	@Step("Enter info into New Page dialog and click OK button")
	public void submitNewPage(String pageName, String parentPage, Integer numberOfColumn, String displayAfter, Boolean isPublic) {
		utils.waitForPageStable();
		fillNewPageInfo(pageName, parentPage, numberOfColumn, displayAfter, isPublic);
		btnOk.moveMouse();
		btnOk.click();
	}

	@Step("Edit info into Edit Page dialog and click OK button")
	public void editPage(String pagePath, String pageName, String parentPage,
			Integer numberOfColumn, String displayAfter, Boolean isPublic) {
		if(pagePath != null) goToPage(pagePath);
		selectOptionInMenu("Global Setting", "Edit");
		utils.waitForPageStable();
		submitNewPage(pageName, parentPage, numberOfColumn, displayAfter, isPublic);
	}

	public void cancelAddPage() {
		btnCancel.moveMouse();
		btnCancel.click();
		utils.waitForPageStable();
	}
}
