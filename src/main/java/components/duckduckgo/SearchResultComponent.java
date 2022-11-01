package components.duckduckgo;

import components.AbsBaseComponent;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultComponent extends AbsBaseComponent {

    public SearchResultComponent(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "article")
    private List<WebElement> resultsBlock;

    @FindBy(tagName = "h2")
    private WebElement resultHeader;

    public WebElement getResultOfSearch(int index) {
        return resultsBlock.get(index);
    }

    public String getResultHeader(int resultIndex) {
        return getResultOfSearch(resultIndex).findElement(By.tagName("h2")).getText();
    }

    public SearchResultComponent resultHeaderShouldBeSameAs(String header, int resultIndex) {
        Assertions
                .assertEquals(header,
                        getResultHeader(resultIndex),
                        String.format("Header should be %s", header));

        return new SearchResultComponent(driver);
    }

}