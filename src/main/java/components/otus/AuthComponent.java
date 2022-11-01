package components.otus;

import components.AbsBaseComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.otus.MainPage;

public class AuthComponent extends AbsBaseComponent {
    public AuthComponent(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "form[action*='login'] input[name='email']")
    private WebElement emailField;

    @FindBy(css = "form[action*='login'] input[name='password']")
    private WebElement passwordField;

    @FindBy(css = "form[action*='login'] button[type='submit']")
    private WebElement enterButton;

    public void typeEmail(String email) {
        emailField.clear();
        emailField.click();
        emailField.sendKeys(email);
    }

    public void typePassword(String password) {
        emailField.clear();
        passwordField.click();
        passwordField.sendKeys(password);
    }

    public void clickEnterButton() {
        enterButton.submit();
    }

    public MainPage authUser(String email, String password) {
        typeEmail(email);
        typePassword(password);
        clickEnterButton();
        return new MainPage(driver);
    }
}
