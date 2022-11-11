package DriverFactory;

import exceptions.DriverNotExistsException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Locale;

public class WebDriverFactory implements IWebDriverFactory {

 //   private String browserName = System.getProperty("browserName").toLowerCase(Locale.ROOT);
    private String browserName = "chrome";

    @Override
    public WebDriver getDriver() throws DriverNotExistsException {
        switch (this.browserName) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();

            default:
                throw new DriverNotExistsException(this.browserName);
        }
    }
}
