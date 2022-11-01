package components.duckduckgo;

import components.AbsBaseComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchComponent extends AbsBaseComponent {

    public SearchComponent(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "search_form_input_homepage")
    private WebElement searchBar;

    @FindBy(id = "search_button_homepage")
    private WebElement searchButton;

    public void searchQueryExecute(String textQuery) {
        searchBar.sendKeys(textQuery);
        searchButton.click();

    }
}
