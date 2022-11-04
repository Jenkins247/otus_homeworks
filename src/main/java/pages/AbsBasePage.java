package pages;

import org.openqa.selenium.WebDriver;
import pageobject.AbsPageObject;

public abstract class AbsBasePage extends AbsPageObject {

    public AbsBasePage(WebDriver driver) {
        super(driver);
    }

    public abstract void open();
}
