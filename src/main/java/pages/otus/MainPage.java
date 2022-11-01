package pages.otus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbsBasePage;

public class MainPage extends AbsBasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    private final static String URL = System.getProperty("host3");

    @Override
    public void open() {
        driver.get(URL);
    }

    @FindBy(xpath = "//button[contains(text(),'Вход')]")
    private WebElement authButton;

    public void openAuthForm() {
        authButton.click();
    }


}
