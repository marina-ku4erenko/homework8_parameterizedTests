package mari.ku.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1600x900";
        Configuration.holdBrowserOpen = true;
    }

}
