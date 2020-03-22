package com.sele2.pages;

import com.sele2.elements.BaseElement;
import com.sele2.elements.Button;
import com.sele2.helper.JSONFileReader;
import com.sele2.support.DriverUtils;

public class HomePage {
	BaseElement baseElement;
	DriverUtils driverUtils = new DriverUtils();
	JSONFileReader jsonFileReader = new JSONFileReader();
	
	public void selectOptionInMenu(String menuname, String option) {
		driverUtils.waitForPageLoad();
		String xpathMenuOption = jsonFileReader.getValueFromJson(String.format("/menu name/%s",menuname));
		Button btnOption = new Button(String.format("//a[text()='%s']", option));
		Button btnMenuOption = new Button(String.format(xpathMenuOption));
		btnMenuOption.moveMouse();
		btnOption.click();
	}

	public void selectAddPageButtonInGlobalSettingMenu() {
		selectOptionInMenu("Global Setting", "Add Page");
	}
}
