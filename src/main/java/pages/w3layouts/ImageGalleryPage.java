package pages.w3layouts;

import org.openqa.selenium.WebDriver;
import pages.AbsBasePage;

public class ImageGalleryPage extends AbsBasePage {
    private final static String URL = System.getProperty("host2");

    public ImageGalleryPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(URL);
    }
}
