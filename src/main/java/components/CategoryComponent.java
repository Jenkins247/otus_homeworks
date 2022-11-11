package components;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject.AbsPageObject;

import java.util.List;

public class CategoryComponent extends AbsPageObject {

    public CategoryComponent(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div[class='lessons']>a")
    private List<WebElement> lessonsList;

    public void catItemsAmountShouldBeExpectedAs(int expectedAmount){
        Assertions.assertEquals(lessonsList.size(), expectedAmount);
    }

}
