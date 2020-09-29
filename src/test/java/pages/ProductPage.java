package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProductPage extends AbstractPage {

    public ProductPage() {
        super();
    }

    private static final By PRODUCT_ID_SPAN = By.xpath("//span[@class='pr-card-code']");
    private static final By PRODUCT_NAME = By.tagName("h1");
    private static final By PRODUCT_COST = By.xpath("//div[text()='Без клубной карты']/following-sibling::div");
    private static final By PUT_PRODUCT_IN_BUCKET_BUTTON = By.id("but_car_main");
    private static final By GO_TO_BUCKET_BUTTON = By.xpath("//a[@class='h-cart']");

    public By getProductIdSpan() {
        return PRODUCT_ID_SPAN;
    }

    public By getProductName() {
        return PRODUCT_NAME;
    }

    public By getProductCost() {
        return PRODUCT_COST;
    }

    public ProductPage addProductInBucket() {
        $(PUT_PRODUCT_IN_BUCKET_BUTTON).click();
        return this;
    }

    public BucketPage goToBucketPage() {
        $(GO_TO_BUCKET_BUTTON).click();
        return new BucketPage();
    }
}
