package components.w3layouts;

import components.AbsBaseComponent;
import components.w3layouts.modal.ImageModal;
import exceptions.ElementListIsEmptyException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GalleryComponent extends AbsBaseComponent {
    public GalleryComponent(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "span[class='image-block']>a")
    private List<WebElement> imageList;


    public ImageModal clickPreviewImage(int index) throws ElementListIsEmptyException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getImageFromList(index));
        return new ImageModal(driver);
    }

    public WebElement getImageFromList(int index) throws ElementListIsEmptyException {
        if (imageList.size() == 0) {
            throw new ElementListIsEmptyException();
        }
        return imageList.get(index);
    }

}
