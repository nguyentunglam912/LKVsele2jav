package pageObjects;

import element.BaseElement;
import element.Button;
import helper.JSONFileReader;
import support.DriverUtils;

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
