package element;

public class IFrame extends BaseElement {

	public IFrame(String locator) {
		super(locator);
	}

	public void switchToIFrame() {
		getDriver().switchTo().frame(findElement());
	}
}
