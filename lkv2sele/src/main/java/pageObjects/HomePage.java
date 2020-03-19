package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import element.Alert;
import element.BaseElement;
import element.Button;
import element.CustomCombobox;
import element.TextBox;
import helper.DriverUtils;

public class HomePage {
	BaseElement baseElement;
	DriverUtils driverUtils = new DriverUtils();
	
	public void selectOptionInMenu(String menuName, String option) {
		driverUtils.waitForPageLoad();
	}
}
