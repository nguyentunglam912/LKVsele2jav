package com.sele2.pages;

import org.openqa.selenium.By;

import com.sele2.elements.Button;
import com.sele2.elements.Checkbox;
import com.sele2.elements.Combobox;
import com.sele2.elements.Label;
import com.sele2.elements.Link;
import com.sele2.elements.Table;
import com.sele2.elements.TextBox;
import com.sele2.support.Constant;
import com.sele2.support.DriverUtils;

import io.qameta.allure.Step;

public class PanelPage extends HomePage{
	private String xpathPanelType 		= "//input[@name='radPanelType']//preceding::label[contains(text(),'%s')]";
	private String xpathLegends 		= "//label/input[@name='radPlacement' and @value='%s']";
	private String xpathPanelButton		= "//form[@id='form1']//a[text()='%s']";
	private String xpathInfoSettings	= "//table[@id='infoSettings']//tr/td[contains(text(),'%s')]";
	private String xpathChartSettings	= "//div[@id='tdSettings']//table//tr/td[contains(text(),'%s')]";
	private TextBox txtDisplayName 		= new TextBox("id=txtDisplayName");
	private Combobox cmbSeries 			= new Combobox("id=cbbSeriesField");
	private Button btnOkAddNewPanel 	= new Button("//div[@class='ui-dialog-container']//input[@id='OK']");
	private Button btnCancelPanel		= new Button("//div[@class='ui-dialog-container']//input[@id='Cancel']");
	private Combobox cmbSelectPage 		= new Combobox("//div[@id='div_panelConfigurationDlg']//select[@id='cbbPages']");
	private TextBox txtHeight 			= new TextBox("//div[@id='div_panelConfigurationDlg']//input[@id='txtHeight']");
	private TextBox txtFolder			= new TextBox("//div[@id='div_panelConfigurationDlg']//input[@id='txtFolder']");
	private Button btnOKConfigPanel 	= new Button("//div[@id='div_panelConfigurationDlg']//input[@id='OK']");
	private Table tblPanel 				= new Table("//table[@class='GridView']/tbody");

	private void selectPanelType(String type) {
		Checkbox chkPanelType = new Checkbox(String.format(xpathPanelType, type));
		chkPanelType.check();	
	}

	public void selectLegends(String legend) {
		Checkbox chkPanelType = new Checkbox(String.format(xpathLegends, legend));
		chkPanelType.waitForVisible(DriverUtils.loadTimeout);
		chkPanelType.check();
	}

	private void fillNewPanelInformation(String type, String displayName, String series, String legend){
		if(type!=null) this.selectPanelType(type);
		if(displayName!=null) txtDisplayName.clearAndSendKeys(displayName);
		if(series!=null) cmbSeries.selectBySpecialText(series);
		if(legend!=null) this.selectLegends(legend);
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
	public void createNewPanel(String type, String displayName, String series, String legend) {
		utils.waitForPageStable();
		this.fillNewPanelInformation(type, displayName, series, legend);
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

	public Boolean isAllSettingExists() {
		Label lblType = new Label(String.format(xpathInfoSettings, "Type"));
		Label lblDataProfile = new Label(String.format(xpathInfoSettings, "Data Profile"));
		Label lblDisplayName = new Label(String.format(xpathInfoSettings, "Display Name"));
		Label lblChartTitle = new Label(String.format(xpathChartSettings, "Chart Title"));
		Label lblChartType = new Label(String.format(xpathChartSettings, "Chart Type"));
		Label lblStyle = new Label(String.format(xpathChartSettings, "Style"));
		Label lblCategory = new Label(String.format(xpathChartSettings, "Category"));
		Label lblSeries = new Label(String.format(xpathChartSettings, "Series"));
		Label lblLegends = new Label(String.format(xpathChartSettings, "Legends"));
		Label lblDataLabels = new Label(String.format(xpathChartSettings, "Data Labels"));

		if(lblType.isDisplayed() && lblDataProfile.isDisplayed() && lblDisplayName.isDisplayed() && lblChartTitle.isDisplayed()
				&& lblChartType.isDisplayed() && lblStyle.isDisplayed() && lblCategory.isDisplayed() && lblSeries.isDisplayed()
				&& lblLegends.isDisplayed() && lblDataLabels.isDisplayed()) {
			return true;
		} else return false;
	}

	public String getWarningMessageOnPanels() {
		alert.waitForAlertPresent();
		String actualMessage = alert.getText();
		return actualMessage;
	}

	public Boolean isNewPanelExisted(String panelName) {
		utils.waitForPageStable();
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

	public void openEditPanel(String panelName) {
		this.btnOkAddNewPanel.waitForInVisible(DriverUtils.loadTimeout);
		int totalRows = this.tblPanel.getRowsCount();
		int panelNameCol = 2;
		int actionCol = 3;
		for(int i = 2; i < totalRows - 1; i++) {
			String currentPanel = this.tblPanel.getTableCellValue(i, panelNameCol);
			if(currentPanel.equals(panelName)) {
				this.tblPanel.table().findElement(By.xpath("//tr["+i+"]/td["+actionCol+"]/a[contains(text(),'Edit')]")).click();;
				this.btnOkAddNewPanel.waitForVisible(DriverUtils.loadTimeout);
				break;
			}
		}
	}

	public void cancelPanelDialog() {
		if(this.btnCancelPanel.isDisplayed()) this.btnCancelPanel.click();
	}

	public void deletePanel(String panelName) {
		this.selectPanel(panelName);
		this.selectDeleteButtonOnPanel();
		utils.waitForPageLoad();
	}
}
