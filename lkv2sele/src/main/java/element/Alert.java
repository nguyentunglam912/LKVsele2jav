package element;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import support.DriverUtils;

public class Alert {

	public void waitForAlertPresent() {
		WebDriverWait wait = new WebDriverWait(DriverUtils.driver, DriverUtils.loadTimeout);
		wait.until(ExpectedConditions.alertIsPresent()); 
	}

	public void dissmiss() {
		DriverUtils.driver.switchTo().alert().dismiss();
	}

	public void accept() {
		DriverUtils.driver.switchTo().alert().accept();
	}
	
	public String getText() {
		return DriverUtils.driver.switchTo().alert().getText();
	}

	public void sendKey(String text) {
		DriverUtils.driver.switchTo().alert().sendKeys(text);
	}
}
