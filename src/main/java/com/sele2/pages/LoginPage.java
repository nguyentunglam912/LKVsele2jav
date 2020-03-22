package com.sele2.pages;

import org.testng.Assert;

import io.qameta.allure.Step;
import com.sele2.elements.Alert;
import com.sele2.elements.BaseElement;
import com.sele2.elements.Button;
import com.sele2.elements.CustomCombobox;
import com.sele2.elements.TextBox;
import com.sele2.support.DriverUtils;

public class LoginPage{
	BaseElement baseElement;
	CustomCombobox cbbRepository = new CustomCombobox("id = repository");
	TextBox txtUserName = new TextBox("id=username");
	TextBox txtPassword = new TextBox("id=password");
	Button btnSignIn 	= new Button("className=btn-login");
	Alert alert = new Alert();
	
	private void selectRepository(String repository) {
		cbbRepository.selectByVisibleText(repository);
	}

	private void enterUsername(String username){
		txtUserName.sendKeys(username);
	}
	
	private void enterPassword(String password){
		txtPassword.sendKeys(password);
	}
	
	private void clickSignIn(){
		btnSignIn.click();
	}

	@Step("Enter username: {1}, password: {2}, and click Sign In button")
	public void login(String repository, String username, String password){
		selectRepository(repository);
		enterUsername(username);
		enterPassword(password);
		clickSignIn();
	}

	@Step("Verify that Dashboard Mainpage appears")
	public void checkLoginSuccessfully() {
		String expectedTitle = "TestArchitect";
		String actualTitle = DriverUtils.driver.getTitle();
		Assert.assertTrue(actualTitle.contains(expectedTitle));
	}

	@Step("VP: Verify that Dashboard Error message {0}")
	public void checkLoginErrorMessage(String expectedErrorMessagge) {
		alert.waitForAlertPresent();
		String actualMessage = alert.getText();
		Assert.assertTrue(actualMessage.contains(expectedErrorMessagge));
	}
}
