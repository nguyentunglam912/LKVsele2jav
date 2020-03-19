package pageObjects;

import element.BaseElement;
import element.Button;
import helper.DriverUtils;

public class HomePage {
	BaseElement baseElement;
	DriverUtils driverUtils = new DriverUtils();
	Button btnGlobalSetting = new Button("//li[@class = 'mn-setting']");
	
	public void selectOptionInMenu(Button menuname, String option) {
		driverUtils.waitForPageLoad();
		Button btnOption = new Button(String.format("//a[text()='%s']", option));
		menuname.moveMouse();
		btnOption.click();
	}

	public void selectAddPageButtonInGlobalSettingMenu() {
		selectOptionInMenu(btnGlobalSetting, "Add Page");
	}
}
