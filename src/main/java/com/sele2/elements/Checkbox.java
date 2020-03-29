package com.sele2.elements;

public class Checkbox extends BaseElement {

	public Checkbox(String locator) {
		super(locator);
	}

	public void check() {
		if (!isChecked()) {
			this.click();
		}
	}

	public void uncheck() {
		if (isChecked()) {
			this.click();
		}
	}

	public boolean isChecked() {
		return this.findElement().isSelected();
	}

	public void selectValue(Boolean value) {
		if(value == true) this.check();
		else if(value == false) this.uncheck();
	}

}
