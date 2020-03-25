package com.sele2.pages;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.sele2.elements.Alert;
import com.sele2.elements.BaseElement;
import com.sele2.elements.Button;
import com.sele2.elements.Link;
import com.sele2.helper.JSONFileReader;
import com.sele2.support.DriverUtils;
import com.sele2.support.Utilities;

public class GeneralPage {
	BaseElement baseElement;
	DriverUtils driverUtils = new DriverUtils();
	Utilities utils = new Utilities();
	JSONFileReader jsonFileReader = new JSONFileReader();
	Alert alert = new Alert();
	String xpathDynamicPage = "//div[@class = 'container']//a[text()='%s']";
	public String dynamicMenuItems = "//li[a[normalize-space()='%s']]/ul/li/a";
	BaseElement mainMenu = new BaseElement("//div[@id=\"main-menu\"]/div/ul/li");
	
	public void moveMouseToMenu(String menuname) {
		utils.waitForPageLoad();
		String xpathMenuOption = jsonFileReader.getValueFromJson(String.format("/menu name/%s",menuname));
		Button btnMenuOption = new Button(String.format(xpathMenuOption));
		btnMenuOption.waitForVisible(DriverUtils.loadTimeout);
		btnMenuOption.moveMouse();
	}
	
	public void selectOptionInMenu(String menuname, String option) {
		Link lnkOption = new Link(String.format("//a[text()='%s']", option));
		moveMouseToMenu(menuname);
		if(lnkOption.size() != 0)
			lnkOption.click();
	}
	
	public void selectAddPageButtonInGlobalSettingMenu() {
		selectOptionInMenu("Global Setting", "Add Page");
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
	
	public void deletePage(String pagePath) {
        goToPage(pagePath);
        utils.waitForPageLoad();
        selectOptionInMenu("Global Setting", "Delete");
        alert.accept();
	}
	
	public Dictionary getMenuItems(String menuName) {
		BaseElement menu = new BaseElement(String.format(dynamicMenuItems, menuName));
		Dictionary dictItems = new Hashtable();
		List<WebElement> items = menu.findElements();
		for(WebElement item:items) {
			String itemName = item.getAttribute("text");
			String itemHref = item.getAttribute("href");
			dictItems.put(itemName, itemHref);
			}
		return dictItems;
	}

	public void deleteAllPagesFromMenu(String parentPage) {
		Dictionary pages = getMenuItems(parentPage);
		for(Enumeration<String> page = pages.elements(); page.hasMoreElements();) {
			if(!page.toString().equals("Overview") && !page.toString().equals("Execution Dashboard")) {
				deleteAllPagesFromMenu(page.toString());
				DriverUtils.driver.get(page.nextElement());
		        selectOptionInMenu("Global Setting", "Delete");
		        alert.accept();
		        utils.waitForPageLoad();
			}
		}
	}

	public void deleteAllPages() {
		List<WebElement> menus = mainMenu.findElements();
		for(WebElement menu : menus) {
			if(!menu.getText().trim().equals("")) {
				deleteAllPagesFromMenu(menu.getText());
			}
		}
	}
}
