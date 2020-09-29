package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class BucketPage extends AbstractPage {

    public BucketPage() {
        super();
    }

    private static final By PRODUCT_NAME_FROM_BUCKET = By.xpath("//div[@class='cart-item-product-title']//a");
    private static final By PRODUCT_COST_FROM_BUCKET = By.xpath("//div[@class='cart-item-price']");
    private static final By COST_FROM_EMPTY_BUCKET = By.xpath("//span[@class='total-clubcard-price summa_car1']");
    private static final By DELETE_PRODUCT_FROM_BUCKET_BUTTON = By.xpath("//a[@class='delItem cart-item-remove']");

    public BucketPage deleteProductFromBucket() {
        $(DELETE_PRODUCT_FROM_BUCKET_BUTTON).click();
        logger.info("Delete product from the bucket");
        return this;
    }

    public By getProductNameFromBucket() {
        return PRODUCT_NAME_FROM_BUCKET;
    }

    public By getProductCostFromBucket() {
        return PRODUCT_COST_FROM_BUCKET;
    }

    public By getCostFromEmptyBucket() {
        return COST_FROM_EMPTY_BUCKET;
    }
}
