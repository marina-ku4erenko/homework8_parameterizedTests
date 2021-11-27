package mari.ku.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MvideoPage {

    private SelenideElement
            searchField = $(".input__field"),
            buttonSearch = $("[type=search]");

    private ElementsCollection
            titleProduct = $$(".product-title__text");


    public MvideoPage openPage() {
        open("https://www.mvideo.ru/");

        return this;
    }

    public MvideoPage inputSearchQuery(String searchProduct) {
        searchField.setValue(searchProduct);

        return this;
    }

    public MvideoPage clickButtonSearch() {
        buttonSearch.click();

        return this;
    }

    public MvideoPage checkNameProduct(String searchProduct) {
        for (int i = 0; i < 12; i++) {
            titleProduct.get(i).shouldHave(text(searchProduct));
        }
        return this;
    }
}
