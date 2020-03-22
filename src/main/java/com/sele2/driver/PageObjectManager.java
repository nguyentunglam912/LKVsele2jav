package com.sele2.driver;
  
import org.openqa.selenium.WebDriver;

import com.sele2.pages.HomePage;
import com.sele2.pages.LoginPage;


public class PageObjectManager {
 
	public WebDriver driver;
	public HomePage homePage;
	public LoginPage loginPage;
 
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
 
	public HomePage getHomePage(){
		return (homePage == null) ? homePage = new HomePage() : homePage;
 
	}

	public LoginPage getLoginPage() {
		return (loginPage == null) ? loginPage = new LoginPage() : loginPage;
	}
}
