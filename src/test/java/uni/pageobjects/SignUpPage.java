package uni.pageobjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;
import uni.factory.WebDriverFactory;

import java.util.Map;

@Component
public class SignUpPage extends CommonPageObject {

//    @FindBy(css = ".EmailForm__Center-jwtojv-0 > div")
//    private WebElement registrationButton;
    @FindBy(id = "login")
    private WebElement btnLogin;

    @FindBy(id = "username")
    private WebElement idInput;

    @FindBy(id = "confirm")
    private WebElement confirmEmailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "year")
    private WebElement yearInput;

    @FindBy(id="err")
    private WebElement hibaUzenet;

    @FindBy(id = "day")
    private WebElement dayInput;

    private final Map<String, WebElement> inputFieldsMap = Map.of(
        "Add meg a felhasználói neved", idInput,
        "Írd be újra az e-mail-címed.", confirmEmailInput,
        "Adj meg egy jelszót.", passwordInput,
        "ÉÉÉÉ", yearInput,
        "NN", dayInput,
        "Hiba üzenet", hibaUzenet
    );

    public SignUpPage(final WebDriverFactory factory) {
        super(factory);
    }

    public void clickOnBejelentkezesButton() {
        waitForElementToBeClickable(btnLogin);
        btnLogin.click();
        waitForPageReadiness();
    }

    public WebElement getInputFieldByName(final String name) {
        return inputFieldsMap.get(name);
    }
}
