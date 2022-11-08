import WebDriverFactory.WebDriverFactory;
import components.w3layouts.GalleryComponent;
import components.w3layouts.modal.ImageModal;
import exceptions.DriverNotSupportedException;
import exceptions.ElementListIsEmptyException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.w3layouts.ImageGalleryPage;

public class TestOpenImageInModal {
    private WebDriver driver;

    @BeforeEach
    public void setUp() throws DriverNotSupportedException {
        this.driver = new WebDriverFactory().getDriver();
    }


    @Test
    public void testOpenImageInModal() throws ElementListIsEmptyException {
        new ImageGalleryPage(driver).open();
        new ImageModal(driver).modalShouldNotBeView();
        new GalleryComponent(driver).clickPreviewImage(4).modalShouldBeView();
    }


    @AfterEach
    public void close() {
        if (this.driver != null) {
            this.driver.close(); //close browser
            this.driver.quit(); //close session
        }
    }
}
