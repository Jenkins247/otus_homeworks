package WebDriverFactory.impl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeWebDriver implements iDriver {
    @Override
    public WebDriver newDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(System.getProperty("mode"));

        return new ChromeDriver(chromeOptions);
    }
}
