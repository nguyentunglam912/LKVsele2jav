package com.sele2.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebElement;

import com.sele2.elements.BaseElement;
import com.sele2.elements.Table;
import com.sele2.support.DriverUtils;

public class DataProfilesPage extends HomePage{
	private BaseElement dataProfileItem = new BaseElement("//table[@class='GridView']//td[count(//th[text()='Data Profile'])+1]");
	
	public List<String> getListDataProfilesPopulated() {
		utils.waitForPageStable();
		List<WebElement> items = this.dataProfileItem.findElements();
		List<String> listActual = new ArrayList<String>();
		for(WebElement item : items) {
			listActual.add(item.getText().trim());
		}
		return listActual;
	}

	@SuppressWarnings("unlikely-arg-type")
	public Boolean isDataProfilesItemsPoputated(String[] listDataProfile) {
		for(String dataProfile : listDataProfile) {
			if(Arrays.asList(this.getListDataProfilesPopulated()).contains(dataProfile) == false) {
				return false;
			}
		}
		return true;
	}
}
