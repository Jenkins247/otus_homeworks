package components.w3layouts.modal;

import components.AbsBaseComponent;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ImageModal extends AbsBaseComponent implements IModalVisibility{

    public ImageModal(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "img[id='fullResImage']")
    private WebElement fullResImage;

    @Override
    public void modalShouldNotBeView() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Assertions.assertEquals(true, wait.until(ExpectedConditions.invisibilityOf(fullResImage)));
    }

    @Override
    public void modalShouldBeView() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(fullResImage));
        Assertions.assertTrue(fullResImage.isDisplayed());
    }
}
