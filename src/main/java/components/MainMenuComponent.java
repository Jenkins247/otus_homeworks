package components;

import data.courses.CourseData;
import data.courses.ICourseData;
import data.courses.MainMenuItemsData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.otus.CategoryPage;

public class MainMenuComponent extends AbsBaseComponent{

    public MainMenuComponent(WebDriver driver) {
        super(driver);
    }

    private String mainMenuTemplateLocator = "//*[contains(@class, 'header2-menu_main')]/*[contains(@class, 'header2-menu__item')][.//*[text()='%s']]";
    private String subMenuLocator = mainMenuTemplateLocator + "//a[@title='%s']";

    public MainMenuComponent moveCursorToItem(MainMenuItemsData mainMenuItemsData){
        String locator = String.format(mainMenuTemplateLocator, mainMenuItemsData.getName());

        WebElement webElement = driver.findElement(By.xpath(locator));
        action.moveToElement(webElement).build().perform();

        return this;
    }

    public CategoryPage clickToCategoryByName(CourseData courseData){
        String locator = String.format(subMenuLocator,
                MainMenuItemsData.Courses.getName(), courseData.getName());
        WebElement subMenu = driver.findElement(By.xpath(locator));
        action.moveToElement(subMenu).click().build().perform();
        return new CategoryPage(driver);
    }
}
