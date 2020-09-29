package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import models.User;
import pages.MainPage;
import pages.PersonalCabinetPage;
import services.UserBuilder;

import static com.codeborne.selenide.Selenide.$;

public class LoginStepsDefinition {
    MainPage mainPage = new MainPage();
    User user;

    @Given("^User is on login form$")
    public void userIsOnLoginForm() {
        mainPage.openPage().clickOnLoginSpan().clickOnPersonalCabinetReference();
    }

    @Given("^User has valid credentials$")
    public void userHasValidCredentials() {
        user = UserBuilder.getUserWithValidCredentials();
    }

    @When("^User inputs name$")
    public void userInputsName() {
        mainPage.inputName(user.getName());
    }

    @And("^User inputs password$")
    public void userInputsPassword() {
        mainPage.inputPassword(user.getPassword());
    }

    @And("^User clicks on login button$")
    public void userClicksOnLoginButton() {
        mainPage.clickOnLoginButton();
    }

    @Then("^User verify that login with correct name and password is successfully and User on 'Personal cabinet' page$")
    public void userVerifyThatLoginWithCorrectNameAndPasswordIsSuccessfullyAndUserOnPersonalCabinetPage() {
        $(new PersonalCabinetPage().getPersonalCabinetTitle()).shouldHave(Condition.text("Личный кабинет"));
    }

    @Given("^User doesn't has valid credentials$")
    public void userDoesntHasValidCredentials() {
        user = UserBuilder.getUserWithoutValidCredentials();
    }

    @When("^User inputs (.*) name$")
    public void userInputsNameName(String name) {
        mainPage.inputName(name);
    }

    @And("^User inputs (.*) password$")
    public void userInputsPasswordPassword(String password) {
        mainPage.inputPassword(password);
    }

    @Then("^User verify that login with incorrect name and password isn't successfully and User on remind login or password page$")
    public void userVerifyThatLoginWithIncorrectNameAndPasswordIsnTSuccessfullyAndUserOnRemindLoginOrPasswordPage() {
        $(new PersonalCabinetPage().getPersonalCabinetTitle()).shouldHave(Condition.text("Забыли пароль?"));
    }

    @After
    public void closeBrowser(){
        WebDriverRunner.closeWebDriver();
    }
}
