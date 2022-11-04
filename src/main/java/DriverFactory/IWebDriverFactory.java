package DriverFactory;

import exceptions.DriverNotExistsException;
import org.openqa.selenium.WebDriver;

public interface IWebDriverFactory {
    WebDriver getDriver() throws DriverNotExistsException;
}
