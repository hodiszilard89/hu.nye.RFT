package uni.stepdefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import org.awaitility.Awaitility;
import org.awaitility.Duration;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import uni.config.TestConfig;
import uni.pageobjects.HomePage;
import uni.pageobjects.SignInPage;

import java.util.concurrent.TimeUnit;

import static uni.config.TestConfig.PAGE_OR_ELEMENT_LOAD_WAIT_SECONDS;


@ContextConfiguration(classes = TestConfig.class)
public class SpotifySignupStepDefs {

    @Autowired
    private HomePage homePage;

   @Autowired
    private SignInPage signInPage;

    @Given("the home page is opened")
    public void theHomePageIsOpened() {
        signInPage.navigateToHomePage();
    }
    @And("the Felvesz header button is clicked")
    public void theFelveszHeaderButtonIsClicked() {
        homePage.clickOnFelveszButton();
    }

    @And("the Bejelentkezés header button is clicked")
    public void theRegistrationHeaderButtonIsClicked() {
        signInPage.clickOnBejelentkezesButton();
    }



    @And("^the \'(.*)\' error message of the \'(?:.*)\' (?:field|dropdown|radio buttons|checkbox) should be shown$")
    public void theErrorMessageShouldBeShown(final String message) {
        Awaitility.await(String.format("Element was not loaded in %s seconds", PAGE_OR_ELEMENT_LOAD_WAIT_SECONDS))
            .atMost(new Duration(PAGE_OR_ELEMENT_LOAD_WAIT_SECONDS, TimeUnit.SECONDS))
            .until(() -> signInPage.getWebDriverFromFactory().findElements(
                By.xpath(String.format("//div[text()='%s' or ./span[text()='%s']]", message, message))
                ).size(),
                Matchers.is(1));
    }

    @When("the {string} is filled in with {string}")
    public void theFieldIsFilledWithParameter(final String field, final String content) {
        signInPage.getInputFieldByName(field).sendKeys(content);
    }

}
