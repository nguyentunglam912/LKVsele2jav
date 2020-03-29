package com.sele2.elements;

public class IFrame extends BaseElement {

	public IFrame(String locator) {
		super(locator);
	}

	public void switchToIFrame() {
		this.getDriver().switchTo().frame(findElement());
	}
}
