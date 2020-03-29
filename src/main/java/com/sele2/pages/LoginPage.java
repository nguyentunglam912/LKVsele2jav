package com.sele2.pages;

import io.qameta.allure.Step;
import com.sele2.elements.Button;
import com.sele2.elements.Combobox;
import com.sele2.elements.TextBox;

public class LoginPage extends GeneralPage{
	Combobox cbbRepository = new Combobox("id = repository");
	TextBox txtUserName = new TextBox("id=username");
	TextBox txtPassword = new TextBox("id=password");
	Button btnSignIn 	= new Button("className=btn-login");
	
	private void selectRepository(String repository) {
		cbbRepository.selectByVisibleText(repository);
	}

	private void enterUsername(String username){
		txtUserName.clearAndSendKeys(username);
	}
	
	private void enterPassword(String password){
		txtPassword.clearAndSendKeys(password);
	}
	
	private void clickSignIn(){
		btnSignIn.click();
	}

	@Step("Enter usernamen, password and click Sign In button")
	public void login(String repository, String username, String password){
		selectRepository(repository);
		enterUsername(username);
		enterPassword(password);
		clickSignIn();
	}

	public String getLoginErrorMessage() {
		alert.waitForAlertPresent();
		return alert.getText();
	}
}
