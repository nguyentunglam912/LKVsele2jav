package element;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import element.BaseElement;

public class CustomCombobox extends BaseElement {

	public CustomCombobox(String locator) {
		super(locator);
	}

	public Select select() {
		return new Select(findElement());
	}

	public void selectByVisibleText(String value) {
		findElement().click();
		List<WebElement> options = select().getOptions();
		for (WebElement option : options) {
			if (value.equals(option.getText().trim())) {
				option.click();
				break;
			}
		}
	}

}