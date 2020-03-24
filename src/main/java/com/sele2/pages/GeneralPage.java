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

public class GeneralPage {
	BaseElement baseElement;
	DriverUtils driverUtils = new DriverUtils();
	JSONFileReader jsonFileReader = new JSONFileReader();
	Alert alert = new Alert();
	String xpathDynamicPage = "//div[@class = 'container']//a[text()='%s']";
	public String dynamicMenuItems = "//li[a[normalize-space()='%s']]/ul/li/a";
	
	public void moveMouseToMenu(String menuname) {
		driverUtils.waitForPageLoad();
		String xpathMenuOption = jsonFileReader.getValueFromJson(String.format("/menu name/%s",menuname));
		Button btnMenuOption = new Button(String.format(xpathMenuOption));
		btnMenuOption.moveMouse();
	}
	
	public void selectOptionInMenu(String menuname, String option) {
		Link lnkOption = new Link(String.format("//a[text()='%s']", option));
		moveMouseToMenu(menuname);
		lnkOption.click();
	}
	
	public void selectAddPageButtonInGlobalSettingMenu() {
		selectOptionInMenu("Global Setting", "Add Page");
	}
	
	public void goToPage(String pagePath) {
		driverUtils.waitForPageLoad();
		Button btnDynamicPage = null;
		String[] nodes = pagePath.split("/");
		for(String node:nodes) {
			btnDynamicPage = new Button(String.format(xpathDynamicPage, node.replace(" ", "\\u00a0")));
			btnDynamicPage.moveMouse();
		}
		btnDynamicPage.click();
	}
	
	public void deletePage(String pagePath) {
        goToPage(pagePath);
        driverUtils.waitForPageLoad();
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

	public void deleteAllPages(String parentPage) {
		Dictionary pages = getMenuItems(parentPage);
		if(pages.size() > 0) {
			for(Enumeration<String> page = pages.elements(); page.hasMoreElements();) {
				deleteAllPages(page.toString());
				DriverUtils.driver.get(page.nextElement());
		        selectOptionInMenu("Global Setting", "Delete");
		        alert.accept();
				driverUtils.waitForPageLoad();
				}
		}
	}
}