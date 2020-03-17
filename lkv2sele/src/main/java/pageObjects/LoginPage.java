package pageObjects;

import org.testng.Assert;

import element.BaseElement;
import element.Button;
import element.CustomCombobox;
import element.TextBox;
import helper.DriverUtils;

public class LoginPage{
	BaseElement baseElement;
	CustomCombobox cbbRepository = new CustomCombobox("id = repository");
	TextBox txtUserName = new TextBox("id=username");
	TextBox txtPassword = new TextBox("id=password");
	Button btnSignIn 	= new Button("className=btn-login");
	
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

	public void login(String repository, String username, String password){
		selectRepository(repository);
		enterUsername(username);
		enterPassword(password);
		clickSignIn();
	}

	public void checkLoginSuccessfully() {
		String expectedTitle = "TestArchitect";
		String actualTitle = DriverUtils.driver.getTitle();
		Assert.assertTrue(actualTitle.contains(expectedTitle));
	}
}
