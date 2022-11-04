package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class AbsPageObject {

    protected WebDriver driver;
    protected Actions action;

    public AbsPageObject(WebDriver driver) {
        this.driver = driver;
        this.action = new Actions(driver);
        PageFactory.initElements(driver, this);
    }
}
