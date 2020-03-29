package com.sele2.elements;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Combobox extends BaseElement {

	public Combobox(String locator) {
		super(locator);
	}
	
	public Select select() {	
		return new Select(findElement());
	}

	public void selectByVisibleText(String text) {		
		this.select().selectByVisibleText(text);
	}
	
	public void selectByIndex(int index) {
		this.select().selectByIndex(index);
	}
	
	public void selectByValue(String value) {
		this.select().selectByValue(value);
	}

	public void selectBySpecialText(String text) {
		if(text != null) {
			this.findElement().click();
			List<WebElement> options = this.select().getOptions();
			for(WebElement option : options) {
				if(option.getText().trim().equals(text)) {
					option.click();
					break;
				}
			}
		}
	}
}
