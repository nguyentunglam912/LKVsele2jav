package com.sele2.pages;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.sele2.elements.BaseElement;
import com.sele2.elements.Button;
import com.sele2.support.DriverUtils;

public class HomePage extends GeneralPage{
	private String dynamicMenuItems = "//li[a[normalize-space()='%s']]/ul/li/a";
	BaseElement pageColumns = new BaseElement("//div[@id='ccontent']/div[@id='columns']/ul[@class='column ui-sortable']");

	public Boolean isGlobalSettingMenuDisplayed() {
		BaseElement menu = new BaseElement(String.format(dynamicMenuItems, "Global Setting"));
		if(menu.size()!=0) {
			return true;
		} else return false;
	}

	public Boolean isNewPageDisplayAfterPage(String displayAfterPage, String newPage) {
		Button newAddedPage = new Button(String.format("//li[a[text()='%s']]/following::li[a[text()='%s']]", displayAfterPage, newPage));
		return newAddedPage.isDisplayed();
	}

	public void selectAddPageButtonInGlobalSettingMenu() {
		selectOptionInMenu("Global Setting", "Add Page");
	}

	public void selectCreatePanelButtonInGlobalSettingMenu() {
		selectOptionInMenu("Global Setting", "Create Panel");
	}

	public String getCurrentPage() {
		String currentPageTitle = getCurrentPageTitle();
		return currentPageTitle.substring(20, currentPageTitle.length()).trim();
	}

	public Integer getNumberOfColumnOnPage() {
		return pageColumns.size();
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
		if(pages.size()>0) {
			for(Enumeration<String> page = pages.elements(); page.hasMoreElements();) {
				deleteAllPagesFromMenu(page.toString());
				DriverUtils.driver.get(page.nextElement());
		        selectOptionInMenu("Global Setting", "Delete");
		        alert.accept();
		        utils.waitForPageLoad();
			}
		}
		else if(!parentPage.toString().equals("Overview") && !parentPage.toString().equals("Execution Dashboard")) {
			deletePage(parentPage);
		}
	}
}