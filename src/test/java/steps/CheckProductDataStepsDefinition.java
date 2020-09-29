package steps;

import com.codeborne.selenide.Condition;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.BucketPage;
import pages.MainPage;
import pages.ProductPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CheckProductDataStepsDefinition {
    private ProductPage productPage;
    private BucketPage bucketPage;
    private String productName;
    private String productCost;

    @Given("^User is on product page with (.*)$")
    public void userIsOnProductPageWithId(String id) {
        productPage = new MainPage().openPage().inputProductIdInSearchInput(id).clickOnSearchButton();
    }

    @When("^User adds product in bucket$")
    public void userAddsProductInBucket() {
        productPage.addProductInBucket();
        productName = $(productPage.getProductName()).getText();
        productCost = $(productPage.getProductCost()).getText();
    }

    @And("^User goes to the bucket$")
    public void userGoesToTheBucket() {
        bucketPage = productPage.goToBucketPage();
    }

    @Then("^User sees that name in bucket is the same with name from product page$")
    public void userSeesThatNameInBucketIsTheSameWithNameFromProductPage() {
        $$(bucketPage.getProductNameFromBucket()).get(1).shouldHave(Condition.text(productName));
    }

    @Then("^User sees that cost in bucket is the same with cost from product page$")
    public void userSeesThatCostInBucketIsTheSameWithCostFromProductPage() {
        $$(bucketPage.getProductCostFromBucket()).get(2).shouldHave(Condition.text(productCost));
    }
}
