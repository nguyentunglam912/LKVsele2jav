package com.sele2.elements;

public class TextBox extends BaseElement {

	public TextBox(String locator) {
		super(locator);
	}

	public void sendKeys(CharSequence... keysToSend) {
		if(!keysToSend.equals(null)) findElement().sendKeys(keysToSend);
	}

	public void clear() {
		findElement().clear();
	}

}
