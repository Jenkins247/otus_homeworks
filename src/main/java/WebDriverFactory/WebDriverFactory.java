package WebDriverFactory;

import WebDriverFactory.impl.ChromeWebDriver;
import exceptions.DriverNotSupportedException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class WebDriverFactory implements IWebDriverFactory {

    protected WebDriver driver = null;

    private String browserType = System.getProperty("browser").toLowerCase();

    @Override
    public WebDriver getDriver() throws DriverNotSupportedException {
        switch (this.browserType) {
            case "chrome":
                if (driver == null) {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeWebDriver().newDriver();
                }
                break;
            case "firefox":
                if (driver == null) {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                }
                break;
            case "edge":
                if (driver == null) {
                    WebDriverManager.edgedriver();
                    driver = new EdgeDriver();
                }
                break;

            default:
                throw new DriverNotSupportedException(this.browserType);
        }

        return driver;
    }
}
