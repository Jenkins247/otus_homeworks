package components.w3layouts.modal;

import components.AbsBaseComponent;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ImageModal extends AbsBaseComponent {

    public ImageModal(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "img[id='fullResImage']")
    private WebElement fullResImage;

    public void modalIsDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(fullResImage));
        Assertions.assertTrue(fullResImage.isDisplayed());
    }

}
