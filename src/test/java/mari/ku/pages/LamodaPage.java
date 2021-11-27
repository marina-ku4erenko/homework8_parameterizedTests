package mari.ku.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class LamodaPage {

    private SelenideElement
            buttonRegionDelivery = $(".header__go-geo-wrapper"),
            buttonRemember = $(".d-modal__bottom div").$(withText("Запомнить выбор")),
            regionDelivery = $(".popover-target .notranslate");

    private ElementsCollection
            listRegionDelivery = $$("a[role='button'] span.notranslate");


    public LamodaPage openPage() {
        open("https://www.lamoda.ru/");

        return this;
    }

    public LamodaPage clickButtonRegionDelivery() {
        buttonRegionDelivery.click();

        return this;
    }

    public LamodaPage selectRegionDelivery(String city) {
        listRegionDelivery.findBy(text(city)).click();

        return this;
    }

    public LamodaPage clickButtonRemember() {
        buttonRemember.click();

        return this;
    }

    public LamodaPage checkRegionDelivery(String city) {
        regionDelivery.shouldHave(text(city));

        return this;
    }

}
