package steps;

import com.codeborne.selenide.Condition;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.BucketPage;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.$;

public class DeleteProductFromBucketStepsDefinition {
    private BucketPage bucketPage;

    @Given("^User is on bucket page with product (.*) in the bucket$")
    public void userIsOnBucketPageWithProductIdInTheBucket(String id) {
        bucketPage = new MainPage().openPage().inputProductIdInSearchInput(id).clickOnSearchButton().addProductInBucket().
                goToBucketPage();
    }

    @When("^User deletes product from the bucket$")
    public void userDeletesProductFromTheBucket() {
        bucketPage.deleteProductFromBucket();
    }

    @Then("^User sees that bucket is empty and cost is null$")
    public void userSeesThatBucketIsEmptyAndCostIs() {

        $(bucketPage.getCostFromEmptyBucket()).shouldBe(Condition.text("0 руб. 00 коп."));
    }
}
