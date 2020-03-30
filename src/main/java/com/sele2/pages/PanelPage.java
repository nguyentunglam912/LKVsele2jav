package com.sele2.pages;

import com.sele2.elements.Button;
import com.sele2.elements.Checkbox;
import com.sele2.elements.Combobox;
import com.sele2.elements.Link;
import com.sele2.elements.Table;
import com.sele2.elements.TextBox;

import io.qameta.allure.Step;

public class PanelPage extends HomePage{
	private String xpathPanelType 		= "//input[@name='radPanelType']//preceding::label[contains(text(),'%s')]";
	private String xpathPanelButton		= "//form[@id='form1']//a[text()='%s']";
	private TextBox txtDisplayName 		= new TextBox("id=txtDisplayName");
	private Combobox cmbSeries 			= new Combobox("id=cbbSeriesField");
	private Button btnOkAddNewPanel 	= new Button("//div[@class='ui-dialog editpanelDlg']//input[@id='OK']");
	private Combobox cmbSelectPage 		= new Combobox("//div[@id='div_panelConfigurationDlg']//select[@id='cbbPages']");
	private TextBox txtHeight 			= new TextBox("//div[@id='div_panelConfigurationDlg']//input[@id='txtHeight']");
	private TextBox txtFolder			= new TextBox("//div[@id='div_panelConfigurationDlg']//input[@id='txtFolder']");
	private Button btnOKConfigPanel 	= new Button("//div[@id='div_panelConfigurationDlg']//input[@id='OK']");
	private Table tblPanel 				= new Table("//table[@class='GridView']/tbody");

	private void selectPanelType(String type) {
		Checkbox chkPanelType = new Checkbox(String.format(xpathPanelType, type));
		chkPanelType.check();	
	}

	private void fillNewPanelInformation(String type, String displayName, String series){
		if(type!=null) selectPanelType(type);
		if(displayName!=null) txtDisplayName.clearAndSendKeys(displayName);
		if(series!=null) cmbSeries.selectBySpecialText(series);
	}

	private void selectButtonOnPanel(String button) {
		Link lnkButton = new Link(String.format(xpathPanelButton, button));
		lnkButton.click();
	}

	@Step("Click Add New button on Panel")
	public void selectAddNewButtonOnPanel() {
		this.selectButtonOnPanel("Add New");
		utils.waitForPageStable();
	}

	@Step("Click Delete button on Panel")
	public void selectDeleteButtonOnPanel() {
		this.selectButtonOnPanel("Delete");
		utils.waitForPageStable();
	}

	@Step("Create a new Panel")
	public void createNewPanel(String type, String displayName, String series) {
		utils.waitForPageStable();
		this.fillNewPanelInformation(type, displayName, series);
		utils.waitForPageStable();
		this.btnOkAddNewPanel.click();
	}

	private void fillConfigPanel(String page, Integer height, String folder) {
		utils.waitForPageLoad();
		if(page!=null) cmbSelectPage.selectByVisibleText(page);
		if(height!=null) txtHeight.sendKeys(height.toString());
		if(folder!=null) txtFolder.sendKeys(folder);
	}

	@Step("Config new Panel")
	public void configPanel(String page, Integer height, String folder) {
		fillConfigPanel(page, height, folder);
		btnOKConfigPanel.click();
		utils.waitForPageStable();
	}

	public String getWarningMessageOnPanels() {
		alert.waitForAlertPresent();
		String actualMessage = alert.getText();
		return actualMessage;
	}

	public Boolean isNewPanelExisted(String panelName) {
		return this.tblPanel.presenceOfData(panelName);
	}

	public void selectPanel(String panelName) {
		int totalRows = this.tblPanel.getRowsCount();
		int panelNameCol = 2;
		int checkboxCol = 1;
		for(int i = 2; i < totalRows - 1; i++) {
			String currentPanel = this.tblPanel.getTableCellValue(i, panelNameCol);
			if(currentPanel.equals(panelName)) {
				this.tblPanel.clickTableCell(i, checkboxCol);
				break;
			}
		}
	}

	public void deletePanel(String panelName) {
		this.selectPanel(panelName);
		this.selectDeleteButtonOnPanel();
		alert.accept();
	}
}
