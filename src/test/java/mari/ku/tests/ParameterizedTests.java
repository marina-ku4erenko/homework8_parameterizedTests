package mari.ku.tests;

import mari.ku.pages.AwdeePage;
import mari.ku.pages.LamodaPage;
import mari.ku.pages.LitresPage;
import mari.ku.pages.MvideoPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ParameterizedTests extends TestBase {

    MvideoPage mvideoPage = new MvideoPage();
    LamodaPage lamodaPage = new LamodaPage();
    AwdeePage awdeePage = new AwdeePage();
    LitresPage litresPage = new LitresPage();

    @Tag("NORMAL")
    @ValueSource(strings = {"холодильник", "зубная щетка", "электрогриль"})
    @ParameterizedTest(name = "Поиск товара {0} на сайте Mvideo и проверка отображения текста \"{0}\" в каждой карточке товара")
    @DisplayName("Поиск товаров на сайте 'Mvideo'")
    void searchProductOnMvideo(String searchProduct) {
        mvideoPage.
                openPage().
                inputSearchQuery(searchProduct).
                clickButtonSearch().
                checkNameProduct(searchProduct);
    }

    @Tag("NORMAL")
    @EnumSource(DeliveryRegion.class)
    @ParameterizedTest(name = "Выбор региона доставки {0} на сайте Lamoda и проверка его отображения в шапке сайта")
    @DisplayName("Выбор региона доставки на сайте 'Lamoda'")
    void celectPopularDeliveryRegionOnLamoda(DeliveryRegion deliveryRegion) {
        lamodaPage.
                openPage().
                clickButtonRegionDelivery().
                selectRegionDelivery(deliveryRegion.getTitle()).
                clickButtonRemember().
                checkRegionDelivery(deliveryRegion.getTitle());
    }

    static Stream<Arguments> searchInfoAboutDesign() {
        return Stream.of(
                Arguments.of("шрифт", Arrays.asList("Как сочетать шрифты, не сочетая шрифты",
                        "Меня часто просят рассказать про сочетания шрифтов, а я никогда не хотел этого делать.")),
                Arguments.of("каллиграфия", Arrays.asList("Каллиграфия, как текстура для иллюстрации",
                        "Все композиции состоят из русских букв, выполненных Павлом Дракуновым в авторском стиле.")),
                Arguments.of("градиенты", Arrays.asList("«Небесные градиенты»",
                        "Американский фотограф Эрик Кахан (Eric Cahan) фотографирует небо в разных штатах США."))
        );
    }

    @Tag("NORMAL")
    @MethodSource
    @ParameterizedTest(name = "Поиск информации по запросу \"{0}\" и проверка наличия карточки с заголовком \"{1}\" в результатах поиска")
    @DisplayName("Поиск информации на сайте 'О дизайне'")
    void searchInfoAboutDesign(String searchQuery, List<String> expectedResult) {
        awdeePage.
                openPage().
                clickButtonSearch().
                setValueAndSearchQuery(searchQuery).
                checkExpectedResultTitle(expectedResult.get(0)).
                checkExpectedResultBody(expectedResult.get(1));
    }

    @Tag("NORMAL")
    @CsvSource(value = {
            "Старик и море| Эрнест Хемингуэй",
            "Страна чудес без тормозов и конец света | Харуки Мураками",
            "Сияние | Стивен Кинг"
    },
            delimiter = '|')
    @ParameterizedTest(name = "Найти книгу \"{0}\" и проверить, что её автор \"{1}\"")
    @DisplayName("Поиск книг на сайте 'Litres'")
    void searchBookAndCheckAuthorCsv(String nameBook, String author) {
        litresPage.
                openPage().
                setValueAndSearchQuery(nameBook).
                checkExpectedResultAuthor(author);
    }

    @Tag("NORMAL")
    @CsvFileSource(resources = "/csvData.csv")
    @ParameterizedTest(name = "Найти книгу \"{0}\" и проверить, что её автор \"{1}\"")
    @DisplayName("Поиск книг на сайте 'Litres'")
    void searchBookAndCheckAuthorCsvFile(String nameBook, String author) {
        litresPage.
                openPage().
                setValueAndSearchQuery(nameBook).
                checkExpectedResultAuthor(author);
    }

}
