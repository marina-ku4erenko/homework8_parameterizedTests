package mari.ku.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class LitresPage {

    private SelenideElement
            searchField = $("input[name='q']");

    private ElementsCollection
            listAuthor = $$(".art-item__author a");


    public LitresPage openPage() {
        open("https://www.litres.ru/");

        return this;
    }

    public LitresPage setValueAndSearchQuery(String searchQuery) {
        searchField.setValue(searchQuery).pressEnter();

        return this;
    }

    public LitresPage checkExpectedResultAuthor(String expectedResultAuthor) {
        listAuthor.findBy(text(expectedResultAuthor)).click();

        return this;
    }
}
