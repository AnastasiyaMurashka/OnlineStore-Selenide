package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class MainPage extends AbstractPage {

    public MainPage() {
        super();
    }

    private static final By LOGIN_SPAN = By.xpath("//ul[@class='b-user_tools  ']");
    private static final By LOGIN_PERSONAL_CABINET_REFERENCE = By.xpath("//a[contains(text(),'Войти')]");
    private static final By LOGIN_INPUT = By.name("login");
    private static final By PASSWORD_INPUT = By.name("pwd");
    private static final By LOGIN_BUTTON = By.xpath("//button[text()='Войти в личный кабинет']");
    private static final By SEARCH_INPUT = By.xpath("//input[@name='q']");
    private static final By SEARCH_BUTTON = By.xpath("//input[@class='button_search']");

    public MainPage openPage() {
        open("https://www.777555.by/");
        logger.info("Main page has been opened");
        return this;
    }

    public MainPage clickOnLoginSpan() {
        $(LOGIN_SPAN).click();
        logger.info("Click on login span");
        return this;
    }

    public MainPage clickOnPersonalCabinetReference() {
        $(LOGIN_PERSONAL_CABINET_REFERENCE).click();
        logger.info("Click on personal cabinet reference");
        return this;
    }

    public MainPage inputName(String name) {
        $(LOGIN_INPUT).setValue(name);
        logger.info("Input login");
        return this;
    }

    public MainPage inputPassword(String password) {
        $(PASSWORD_INPUT).setValue(password);
        logger.info("Input password");
        return this;
    }

    public PersonalCabinetPage clickOnLoginButton() {
        $(LOGIN_BUTTON).click();
        logger.info("Click on login button");
        return new PersonalCabinetPage();
    }

    public MainPage inputProductIdInSearchInput(String productId) {
        $(SEARCH_INPUT).setValue(productId);
        logger.info("Input product ID in search field");
        return this;
    }

    public ProductPage clickOnSearchButton() {
        $(SEARCH_BUTTON).click();
        logger.info("Click on search button");
        return new ProductPage();
    }
}
