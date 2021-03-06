package com.sele2.pages;

import com.sele2.elements.Alert;
import com.sele2.elements.BaseElement;
import com.sele2.elements.Button;
import com.sele2.elements.Link;
import com.sele2.helper.JSONReader;
import com.sele2.support.DriverUtils;
import com.sele2.support.Utilities;

import io.qameta.allure.Step;

public class GeneralPage {
	BaseElement baseElement;
	DriverUtils driverUtils = new DriverUtils();
	Utilities utils = new Utilities();
	JSONReader jsonReader = new JSONReader();
	Alert alert = new Alert();
	String xpathDynamicPage = "//div[@class = 'container']//a[text()='%s']";

	public String getCurrentPageTitle() {
		return DriverUtils.driver.getTitle();
	}

	public String getCurrentPageURL() {
		return DriverUtils.driver.getCurrentUrl();
	}

	public void closePopupMessage() {
		alert.dissmiss();
	}

	public void clickOnMenu(String menuname) {
		utils.waitForPageStable();
		String xpathMenuOption = jsonReader.getValueFromJson(String.format("/menu name/%s",menuname));
		Button btnMenuOption = new Button(String.format(xpathMenuOption));
		btnMenuOption.waitForVisible(DriverUtils.loadTimeout);
		try {
			btnMenuOption.click();
		} catch(Exception e){
			   //ignore
		}
	}

	public void selectOptionInMenu(String menuname, String option) {
		Link lnkOption = new Link(String.format("//a[text()='%s']", option));
		this.clickOnMenu(menuname);
		if(lnkOption.size() != 0)
			lnkOption.click();
	}

	public void goToPage(String pagePath) {
		utils.waitForPageStable();
		Button btnDynamicPage = null;
		String[] nodes = pagePath.split("/");
		for(String node:nodes) {
			btnDynamicPage = new Button(String.format(xpathDynamicPage, node.replace(" ", "\\u00a0")));
			btnDynamicPage.moveMouse();
		}
		btnDynamicPage.click();
		utils.waitForPageLoad();
	}

	@Step("Logout TA Dashboard")
	public void logOut() {
		this.selectOptionInMenu("Profile", "Logout");
	}
}
