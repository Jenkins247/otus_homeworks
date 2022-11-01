import WebDriverFactory.WebDriverFactory;
import components.otus.AuthComponent;
import exceptions.DriverNotSupportedException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.otus.MainPage;

public class TestAuthUserOtus {
    private WebDriver driver;

    @BeforeEach
    public void setUp() throws DriverNotSupportedException {
        this.driver = new WebDriverFactory().getDriver();
    }


    @Test
    public void testAuthUserOtus(){
        MainPage mainOtus = new MainPage(driver);
        mainOtus.open();
        mainOtus.openAuthForm();
        new AuthComponent(driver).
                authUser(System.getProperty("email"),
                        System.getProperty("password")).
                printAllCookiesInLog();
    }


    @AfterEach
    public void close(){
        if(this.driver != null){
            this.driver.close(); //close browser
            this.driver.quit(); //close session
        }
    }
}
