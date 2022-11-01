import WebDriverFactory.WebDriverFactory;
import components.duckduckgo.SearchComponent;
import components.duckduckgo.SearchResultComponent;
import exceptions.DriverNotSupportedException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.duckduckgo.DuckDuckGoSearchPage;

public class TestDriverConfiguration {
    private WebDriver driver;

    @BeforeEach
    public void setUp() throws DriverNotSupportedException {
        this.driver = new WebDriverFactory().getDriver();
    }


    @Test
    public void testDuckDuckGoSearch() {
        new DuckDuckGoSearchPage(driver).open();
        new SearchComponent(driver).searchQueryExecute("ОТУС");
        new SearchResultComponent(driver)
                .resultHeaderShouldBeSameAs(
                        "Онлайн‑курсы для профессионалов, дистанционное обучение современным ...",
                        0);

    }

    @AfterEach
    public void close() {
        if (this.driver != null) {
            this.driver.close(); //close browser
            this.driver.quit(); //close session
        }
    }
}
