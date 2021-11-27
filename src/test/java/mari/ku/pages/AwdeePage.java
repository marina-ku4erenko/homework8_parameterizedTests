package mari.ku.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class AwdeePage {

    private SelenideElement
            buttonSearch = $("a[title='Поиск']"),
            searchField = $("input[type='text']");

    private ElementsCollection
            listTitle = $$(".block-entry-title a"),
            listBody = $$(".block-text p");


    public AwdeePage openPage() {
        open("https://awdee.ru/");

        return this;
    }

    public AwdeePage clickButtonSearch() {
        buttonSearch.click();

        return this;
    }

    public AwdeePage setValueAndSearchQuery(String searchQuery) {
        searchField.setValue(searchQuery).pressEnter();

        return this;
    }

    public AwdeePage checkExpectedResultTitle(String expectedResultTitle) {
        listTitle.findBy(text(expectedResultTitle));

        return this;
    }

    public AwdeePage checkExpectedResultBody(String expectedResultBody) {
        listBody.findBy(text(expectedResultBody));

        return this;
    }
}
