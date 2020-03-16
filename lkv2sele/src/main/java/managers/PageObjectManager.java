package managers;
  
import org.openqa.selenium.WebDriver;
import pageObjects.LoginPage;
import pageObjects.HomePage;


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
