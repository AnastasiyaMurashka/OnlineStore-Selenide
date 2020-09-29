package steps;

import com.codeborne.selenide.Condition;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.MainPage;
import pages.ProductPage;

import static com.codeborne.selenide.Selenide.$;

public class SearchProductStepsDefinition {

    MainPage mainPage = new MainPage();

    @Given("^User is on main page$")
    public void userIsOnMainPage() {
        mainPage.openPage();
    }

    @When("^User inputs product (.*) ID$")
    public void userInputsProductIdID(String id) {
        mainPage.inputProductIdInSearchInput(id);
    }

    @And("^User clicks search button$")
    public void userClicksSearchButton() {
        mainPage.clickOnSearchButton();
    }

    @Then("^User is on product page which the same product (.*) ID$")
    public void userIsOnProductPageWhichTheSameProductIdID(String id) {
        $(new ProductPage().getProductIdSpan()).shouldHave(Condition.text(id));
    }
}
