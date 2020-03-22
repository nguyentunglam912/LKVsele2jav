package com.sele2.elements;

public class Checkbox extends BaseElement {

	public Checkbox(String locator) {
		super(locator);
	}

	public void check() {
		if (!isChecked()) {
			click();
		}
	}

	public void uncheck() {
		if (isChecked()) {
			click();
		}
	}

	public boolean isChecked() {
		return findElement().isSelected();
	}

}
