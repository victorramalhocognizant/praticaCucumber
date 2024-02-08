package browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public enum Browser {
	FIREFOX {
		@Override
		public WebDriver initialize(DesiredCapabilities capabilities) {
			synchronized (BrowserProvider.class) {
				FirefoxOptions options = new FirefoxOptions();
				options.merge(capabilities);
				return new FirefoxDriver(options);
			}
		}
	},

	CHROME {
		@Override
		public WebDriver initialize(DesiredCapabilities capabilities) {
			synchronized (BrowserProvider.class) {
				ChromeOptions options = new ChromeOptions();
				return new ChromeDriver(options);
			}
		}
	},

	IE {
		@Override
		public WebDriver initialize(DesiredCapabilities capabilities) {
			synchronized (BrowserProvider.class) {
				InternetExplorerOptions options = new InternetExplorerOptions();
				options.merge(capabilities);
				return new InternetExplorerDriver(options);
			}
		}
	};


	public abstract WebDriver initialize(DesiredCapabilities capabilities);

	@Override
	public String toString() {
		switch (this) {
		case FIREFOX:
			return "FIREFOX";
		case CHROME:
			return "CHROME";
		case IE:
			return "IE";
		default:
			throw new IllegalArgumentException();
		}
	}
}