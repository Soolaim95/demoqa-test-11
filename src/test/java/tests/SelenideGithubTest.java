package tests;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SelenideGithubTest {

    @BeforeAll
    static void beforeAll() {
        open("https://github.com/");
        Configuration.browserSize="1920x1080";
    }

    @Test
    void SearchSelenideInGithub() {

        //Открыть страницу Selenide в Github
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        $("ul.repo-list li").$("a").click();
        $("h1").shouldHave(text("selenide / selenide"));
        //Перейти в раздел Wiki
        $(".js-repo-nav #wiki-tab").click();
        //Перейти в раздел SoftAssertions
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $$(".Box-row").findBy(visible).click();
        $("#repo-content-pjax-container").closest("h1").shouldHave(text("SoftAssertions"));
        //Найти пример кода для JUnit5
        $(".markdown-body").lastChild().shouldHave(text("Using JUnit5 extend test class:"));


        sleep(5000);


    }
}
