package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import element.Button;
import element.CustomCombobox;
import element.TextBox;

public class LoginPage {
	WebDriver driver;
	CustomCombobox cbbRepository = new CustomCombobox("id = repository");
	TextBox txtUserName = new TextBox("id=username");
	TextBox txtPassword = new TextBox("id = password");
	Button btnSignIn = new Button("className = btn-login");
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
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

}