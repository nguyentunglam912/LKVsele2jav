package com.sele2.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.sele2.elements.BaseElement;
import com.sele2.elements.Button;
import com.sele2.elements.Label;
import com.sele2.support.Constant;
import io.qameta.allure.Step;

public class HomePage extends GeneralPage{
	private String dynamicMenuItems = "//li[a[normalize-space()='%s']]/ul/li/a";
	BaseElement pageColumns = new BaseElement("//div[@id='ccontent']/div[@id='columns']/ul[@class='column ui-sortable']");
	Label lblCurrentRepo = new Label("//a[@href='#Repository']//span");

	public Boolean isGlobalSettingMenuDisplayed() {
		BaseElement menu = new BaseElement(String.format(dynamicMenuItems, "Global Setting"));
		if(menu.size()!=0) return true ; return false;
	}

	public Boolean isNewPageDisplayAfterPage(String displayAfterPage, String newPage) {
		Button newAddedPage = new Button(String.format("//li[a[text()='%s']]/following::li[a[text()='%s']]", displayAfterPage, newPage));
		return newAddedPage.isDisplayed();
	}

	@Step("Go to Global Setting -> Add page")
	public void selectAddPageButtonInGlobalSettingMenu() {
		this.selectOptionInMenu("Global Setting", "Add Page");
	}

	@Step("Go to Administer -> Panel")
	public void selectPanelinAdministerMenu() {
		this.selectOptionInMenu("Administer", "Panels");
	}

	@Step("Go to Global Setting -> Create Panel")
	public void selectCreatePanelButtonInGlobalSettingMenu() {
		this.selectOptionInMenu("Global Setting", "Create Panel");
	}

	@Step("Click on Choose Panel menu icon ")
	public void selectChoosePanelsMenu() {
		this.clickOnMenu("Choose Panels");
		utils.waitForPageStable();
	}

	public void switchRepository(String switchRepo) {
		this.selectOptionInMenu("Repository", switchRepo);
		utils.waitForPageStable();
	}

	public String getCurrentPage() {
		utils.waitForPageStable();
		String currentPageTitle = this.getCurrentPageTitle();
		return currentPageTitle.substring(18, currentPageTitle.length()).trim();
	}

	public Integer getNumberOfColumnOnPage() {
		return this.pageColumns.size();
	}

	public String getCurrentRepo() {
		return this.lblCurrentRepo.getText();
	}

	public void deletePage(String pagePath) {
        goToPage(pagePath);
        utils.waitForPageLoad();
        selectOptionInMenu("Global Setting", "Delete");
        alert.accept();
        utils.waitForPageLoad();
	}

	public void deleteAllPagesByPath(String path) {
		String[] nodes = path.split("/");
		if(nodes.length>1) {
			this.deletePage(path);
			String newPath = path.substring(0, path.lastIndexOf("/"));
			deleteAllPagesByPath(newPath);
			}
		else if(!path.equals("Overview") && !path.equals("Execution Dashboard")) {
			this.deletePage(path);
		}
	}

	public String getErrorMessage() {
		this.alert.waitForAlertPresent();
		return this.alert.getText().trim();
	}

	public ArrayList<String> getMenuItems(String menuName) {
		BaseElement menu = new BaseElement(String.format(dynamicMenuItems, menuName));
		ArrayList<String> listItems = new ArrayList<String>();
		List<WebElement> items = menu.findElements();
		for(WebElement item:items) {
			listItems.add(item.getAttribute("text"));
			}
		return listItems;
	}

	public Boolean doesItemExistInMenu(String itemExist, String menuName) {
		ArrayList<String> items = getMenuItems(menuName);
		for(String item : items) {
			if(item.equals(itemExist)) {
				return true;
			}
		}
		return false;
	}

	public Boolean doesItemExistInGlobalSettingMenu(String itemExist, String menuName) {
		ArrayList<String> items = getMenuItems(menuName);
		for(String item : items) {
			if(item.equals(itemExist)) {
				return true;
			}
		}
		return false;
	}
}
