package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class HomePage {
	WebElement element;
	WebDriver driver;
	
	@FindBy(id = "username")
	private WebElement getTitle;
	
	@FindBy(id = "repository")
	private Select selectRepository;
	
	@FindBy(id = "password")
	private WebElement enterPassword;
	
	@FindBy(className = "btn-login")
	private WebElement signIn;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}

	public void checkLoginSuccessfully(String expectedTitle){
		String actualTitle = driver.getTitle();
		Assert.assertTrue(expectedTitle.contains(actualTitle));
	}
}
