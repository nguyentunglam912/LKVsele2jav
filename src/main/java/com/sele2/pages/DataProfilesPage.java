package com.sele2.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebElement;

import com.sele2.elements.BaseElement;
import com.sele2.elements.Button;
import com.sele2.elements.Combobox;
import com.sele2.elements.Link;
import com.sele2.elements.Table;
import com.sele2.elements.TextBox;
import com.sele2.support.DriverUtils;

import io.qameta.allure.Step;

public class DataProfilesPage extends HomePage{
	private String xpathPanelButton		= "(//form[@id='form1']//a[text()='%s'])[1]";
	private BaseElement dataProfileItem = new BaseElement("//table[@class='GridView']//td[count(//th[text()='Data Profile'])+1]");
	private TextBox txtName 			= new TextBox("//table[@id='profilesettingsdetail']//input[@id='txtProfileName']");
	private Combobox cmbItemType 		= new Combobox("//table[@id='profilesettingsdetail']//select[@id='cbbEntityType']");
	private Combobox cmbRelatedData 	= new Combobox("//table[@id='profilesettingsdetail']//select[@id='cbbSubReport']");
	private Button btnFinish			= new Button("//table[@id='profilesettingsdetail']//input[@value='Finish']");
	private Button btnNext				= new Button("//table[@id='profilesettingsdetail']//input[@value='Next']");

	private void selectButtonOnDataProfiles(String button) {
		Link lnkButton = new Link(String.format(xpathPanelButton, button));
		lnkButton.click();
	}

	@Step("Click Add New button on Panel")
	public void selectAddNewButtonOnDataProfiles() {
		utils.waitForPageStable();
		this.selectButtonOnDataProfiles("Add New");
	}
	
	public void submitGeneralSettings(String name, String itemType, String relatedData) {
		if (name != null) {
			this.txtName.clearAndSendKeys(name);
		}
		if (itemType != null) {
			this.cmbItemType.selectBySpecialText(itemType);
		}
		if (relatedData != null) {
			this.cmbRelatedData.selectBySpecialText(relatedData);
		}
		this.btnFinish.click();
		utils.waitForPageStable();
	}

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
