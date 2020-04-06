package com.sele2.elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sele2.driver.DriverManager;
import com.sele2.support.DriverUtils;

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
		return DriverUtils.driver;
	}

	protected WebElement findElement() {
		return this.getDriver().findElement(getByLocator());
	}

	public List<WebElement> findElements() {
		return this.getDriver().findElements(getByLocator());
	}

	public void submit() {
		this.findElement().submit();
	}

	public void click() {
		this.findElement().click();
	}

	public void doubleClick() {
		Actions action = new Actions(getDriver());
		action.doubleClick(this.findElement()).perform();
	}

	public void forceClick() {
		JavascriptExecutor js = (JavascriptExecutor) this.getDriver();
		js.executeScript("arguments[0].click();", this.findElement());
	}

	public boolean isEnabled() {
		return this.findElement().isEnabled();
	}

	public String getText() {
		return this.findElement().getText();
	}

	public boolean isDisplayed() {
		return this.findElement().isDisplayed();
	}

	public void moveMouse() {
		Actions action = new Actions(getDriver());
		action.moveToElement(this.findElement()).perform();
	}

	public int size() {
		return this.findElements().size();
	}

	public void waitForClickable(int timeOut) {
		WebDriverWait wait = new WebDriverWait(this.getDriver(), timeOut);
		wait.until(ExpectedConditions.elementToBeClickable(this.findElement()));
	}

	public void waitForVisible(Long loadtimeout) {
		WebDriverWait wait = new WebDriverWait(this.getDriver(), loadtimeout);
		wait.until(ExpectedConditions.visibilityOf(this.findElement()));
	}

	public void waitForInVisible(Long loadtimeout) {
		WebDriverWait wait = new WebDriverWait(this.getDriver(), loadtimeout);
		wait.until(ExpectedConditions.invisibilityOf(this.findElement()));
	}
}
