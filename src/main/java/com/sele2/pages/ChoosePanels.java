package com.sele2.pages;

import com.sele2.elements.Button;
import com.sele2.support.DriverUtils;

import io.qameta.allure.Step;

public class ChoosePanels extends HomePage{
	Button btnCreateNewPanel = new Button("//div[@class='ccpanels']/div[@class='cpbutton']/span[contains(text(),'Create new panel')]");

	@Step("Click on Create New Panel button under Choose Panels")
	public void clickCreateNewPanel () {
		this.btnCreateNewPanel.waitForVisible(DriverUtils.loadTimeout);
		this.btnCreateNewPanel.click();
	}

}
