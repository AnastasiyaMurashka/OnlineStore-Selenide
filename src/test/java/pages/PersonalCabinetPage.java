package pages;

import org.openqa.selenium.By;

public class PersonalCabinetPage extends AbstractPage {

    public PersonalCabinetPage() {
        super();
    }

    private static final By PERSONAL_CABINET_TITLE = By.tagName("h1");

    public By getPersonalCabinetTitle() {
        return PERSONAL_CABINET_TITLE;
    }
}
