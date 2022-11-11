import DriverFactory.WebDriverFactory;
import components.CategoryComponent;
import components.MainMenuComponent;
import data.courses.CourseData;
import data.courses.MainMenuItemsData;
import exceptions.DriverNotExistsException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.otus.MainPage;

public class TestCategoryItemsAmount {
    private WebDriver driver;

    @BeforeEach
    public void init() throws DriverNotExistsException {
        this.driver = new WebDriverFactory().getDriver();
    }

    @Test
    public void testCategoryItemsAmount(){
        new MainPage(driver)
                .open("/");

        new MainMenuComponent(driver)
                .moveCursorToItem(MainMenuItemsData.Courses)
                .clickToCategoryByName(CourseData.Testing)
                .pageHeaderShouldBeSameAs(CourseData.Testing.getName());

        new CategoryComponent(driver).catItemsAmountShouldBeExpectedAs(14);
    }

    @AfterEach
    public void close(){
        if(this.driver != null){
            this.driver.close(); //close browser
            this.driver.quit(); //close session
        }
    }
}
