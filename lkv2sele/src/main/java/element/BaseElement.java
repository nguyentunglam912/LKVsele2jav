package element;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import managers.DriverManager;

public class BaseElement {
	protected String locator;
	protected DriverManager driverManager;

	public BaseElement(String locator) {
		this.locator = locator;
	}

	private By getByLocator() {
		String body = this.locator.replaceAll("[\\w\\s]*=(.*)", "$1").trim();
		String type = this.locator.replaceAll("([\\w\\s]*)=.*", "$1").trim();
		switch (type) {
		case "css":
			return By.cssSelector(body);
		case "id":
			return By.id(body);
		case "xpath":
			return By.xpath(body);
		case "name":
			return By.name(body);
		case "className":
			return By.className(body);
		default:
			return By.xpath(locator);
		}
	}

	protected WebDriver getDriver() {
		return ge;
	}

	protected WebElement findElement() {
		return getDriver().findElement(getByLocator());
	}

	public List<WebElement> findElements() {
		return getDriver().findElements(getByLocator());
	}

	public void submit() {
		findElement().submit();
	}

	public void click() {
		findElement().click();
	}

	public void forceClick() {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].click();", findElement());
	}

	public boolean isEnabled() {
		return findElement().isEnabled();
	}

	public String getText() {
		return findElement().getText();
	}

	public boolean isDisplayed() {
		return findElement().isDisplayed();
	}

	public void moveMouse() {
		Actions action = new Actions(getDriver());
		action.moveToElement(findElement()).perform();
	}

	public int size() {
		return findElements().size();
	}

	public void waitForClickable(int timeOut) {
		WebDriverWait wait = new WebDriverWait(getDriver(), timeOut);
		wait.until(ExpectedConditions.elementToBeClickable(findElement()));
	}

	public void waitForVisible(int timeOut) {
		WebDriverWait wait = new WebDriverWait(getDriver(), timeOut);
		wait.until(ExpectedConditions.visibilityOf(findElement()));
	}

	public void waitForInVisible(int timeOut) {
		WebDriverWait wait = new WebDriverWait(getDriver(), timeOut);
		wait.until(ExpectedConditions.invisibilityOf(findElement()));
	}
}