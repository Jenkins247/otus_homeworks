package WebDriverFactory;

import exceptions.DriverNotSupportedException;
import org.openqa.selenium.WebDriver;

public interface IWebDriverFactory {
    WebDriver getDriver() throws DriverNotSupportedException;
}
