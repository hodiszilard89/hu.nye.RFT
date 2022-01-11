package uni.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;
import uni.factory.WebDriverFactory;

@Component
public class HomePage extends CommonPageObject {
    private static final String HOME_PAGE_URL = "http://localhost:8080/login";

    @FindBy(css = "header li:nth-child(5) > a")
    private WebElement registrationButton;

    @FindBy(id="err")
    private WebElement hibaUzenet;

    @FindBy(id="login")
    private WebElement loginButton;

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement cookieDisclaimer;

    public HomePage(final WebDriverFactory factory) {
        super(factory);
    }

    public void navigateToHomePage() {
        navigateToUrl(HOME_PAGE_URL);
    }

    public void clickOnLoginButton() {
        System.out.println("klikk");
        waitForElementToBeClickable(loginButton);
        loginButton.click(); System.out.println("klikk");

        waitForPageReadiness();
    }

//    public void clickOnRegistrationButton() {
//        waitForElementToBeClickable(registrationButton);
//        registrationButton.click();
//        waitForPageReadiness();
//    }

    public void clickOnCookieDisclaimer() {
        waitForElementToBeClickable(cookieDisclaimer);
        clickWithJsExecutor(cookieDisclaimer);
    }
}
