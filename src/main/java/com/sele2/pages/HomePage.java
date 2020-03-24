package com.sele2.pages;

import org.testng.Assert;

import com.sele2.elements.BaseElement;

public class HomePage extends GeneralPage{

	public void checkGlobalSettingMenuDoesNotDisplay() {
		BaseElement menu = new BaseElement(String.format(dynamicMenuItems, "Global Setting"));
		Assert.assertFalse(menu.size() != 0);
	}
}
