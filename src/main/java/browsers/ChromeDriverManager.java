package browsers;

import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import managers.DriverManager;

public class ChromeDriverManager extends DriverManager {

	@Override
	public void createWebDriver() {
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();
	}
}
