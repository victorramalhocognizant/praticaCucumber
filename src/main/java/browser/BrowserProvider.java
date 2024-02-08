package browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserProvider {

	public static WebDriver createDriver(Browser browser, DesiredCapabilities capabilities) {
		capabilities.setBrowserName(browser.toString().toLowerCase());
		return browser.initialize(capabilities);
	}

	/**
	 * Create a driver with default capabilities.
	 */
	public static WebDriver createDriver(Browser browser) {
		return createDriver(browser, new DesiredCapabilities());
	}
}