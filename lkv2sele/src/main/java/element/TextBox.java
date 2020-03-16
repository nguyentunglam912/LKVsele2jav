package element;

public class TextBox extends BaseElement {

	public TextBox(String locator) {
		super(locator);
	}

	public void sendKeys(CharSequence... keysToSend) {
		findElement().sendKeys(keysToSend);
	}

	public void clear() {
		findElement().clear();
	}

}
