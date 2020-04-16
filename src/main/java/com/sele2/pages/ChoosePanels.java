package com.sele2.pages;

import com.sele2.elements.Button;
import com.sele2.elements.Link;
import com.sele2.support.DriverUtils;

import io.qameta.allure.Step;

public class ChoosePanels extends HomePage{
	Button btnCreateNewPanel = new Button("//div[@class='ccpanels']/div[@class='cpbutton']/span[contains(text(),'Create new panel')]");
	String xpathChartItem = "//div[@class='cpanels']//div[@class='ptit pchart']//following-sibling::table//li/a[text()='%s']";

	@Step("Click on Create New Panel button under Choose Panels")
	public void clickCreateNewPanel () {
		this.btnCreateNewPanel.waitForVisible(DriverUtils.loadTimeout);
		this.btnCreateNewPanel.click();
	}

	public void selectChartPanelInChoosePanels(String chartPanel) {
		Link btnChartItem = new Link(String.format(xpathChartItem, chartPanel.replace(" ", "\u00A0")));
		if(!btnChartItem.isDisplayed()) this.selectChoosePanelsMenu();
		btnChartItem.waitForVisible(DriverUtils.loadTimeout);
		btnChartItem.click();
		utils.waitForPageStable();
	}
}
