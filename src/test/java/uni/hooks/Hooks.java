package uni.hooks;


import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import uni.factory.WebDriverFactory;

public class Hooks {

    @Autowired
    private WebDriverFactory webDriverFactory;

    @After
    public void afterScenario() {
        final WebDriver webDriver = webDriverFactory.getWebDriver();

        webDriver.manage().deleteAllCookies();
    }
}
