package pages.duckduckgo;

import org.openqa.selenium.WebDriver;
import pages.AbsBasePage;

public class DuckDuckGoSearchPage extends AbsBasePage {

    private final static String URL = System.getProperty("host1");
    public DuckDuckGoSearchPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(URL);
    }
}
