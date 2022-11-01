package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import pageobject.AbsPageObject;

public abstract class AbsBasePage extends AbsPageObject {

    protected Logger logger = LogManager.getLogger();

    public AbsBasePage(WebDriver driver) {
        super(driver);
    }

    public abstract void open();

    public void printAllCookiesInLog() {
        for (Cookie cookie : driver.manage().getCookies()) {
            logger.info(cookie);
        }
    }
}
