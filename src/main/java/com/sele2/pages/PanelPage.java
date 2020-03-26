package com.sele2.pages;

import com.sele2.elements.Button;
import com.sele2.elements.Checkbox;
import com.sele2.elements.Combobox;
import com.sele2.elements.TextBox;

public class PanelPage extends HomePage{
	private String xpathPanelType 		= "//input[@name='radPanelType']//preceding::label[contains(text(),'%s')]";
	private TextBox txtDisplayName 		= new TextBox("id=txtDisplayName");
	private Combobox cmbSeries 			= new Combobox("id=cbbSeriesField");
	private Button btnOkAddNewPanel 	= new Button("//div[@id='div_panelPopup']//input[@id='OK']");
	private Combobox cmbSelectPage 		= new Combobox("//div[@id='div_panelConfigurationDlg']//select[@id='cbbPages']");
	private TextBox txtHeight 			= new TextBox("//div[@id='div_panelConfigurationDlg']//input[@id='txtHeight']");
	private TextBox txtFolder			= new TextBox("//div[@id='div_panelConfigurationDlg']//input[@id='txtFolder']");
	private Button btnOKConfigPanel 	= new Button("//div[@id='div_panelConfigurationDlg']//input[@id='OK']");

	private void selectPanelType(String type) {
		Checkbox chkPanelType = new Checkbox(String.format(xpathPanelType, type));
		chkPanelType.check();	
	}

	private void fillNewPanelInformation(String type, String displayName, String series){
		if(type!=null) selectPanelType(type);
		if(displayName!=null) txtDisplayName.sendKeys(displayName);
		if(series!=null) cmbSeries.selectByVisibleText(series);
	}
	
	public void createNewPanel(String type, String displayName, String series) {
		fillNewPanelInformation(type, displayName, series);
		btnOkAddNewPanel.click();
		utils.waitForPageStable();
	}
	
	private void fillConfigPanel(String page, Integer height, String folder) {
		utils.waitForPageLoad();
		if(page!=null) cmbSelectPage.selectByVisibleText(page);
		if(height!=null) txtHeight.sendKeys(height.toString());
		if(folder!=null) txtFolder.sendKeys(folder);
	}
	
	public void configPanel(String page, Integer height, String folder) {
		fillConfigPanel(page, height, folder);
		btnOKConfigPanel.click();
		utils.waitForPageStable();
	}
}
