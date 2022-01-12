package uni.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;
import uni.factory.WebDriverFactory;

@Component
public class HomePage extends CommonPageObject {



    @FindBy(id="felvesz")
    private WebElement felveszButton;

    public HomePage(final WebDriverFactory factory) {
        super(factory);
    }



    public void clickOnFelveszButton() {

        waitForElementToBeClickable(felveszButton);
        felveszButton.click();

        waitForPageReadiness();
    }


}
