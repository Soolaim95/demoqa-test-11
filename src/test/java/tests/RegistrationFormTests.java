package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "593x593";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }

    @AfterEach
    void closeBrowser() {
        Selenide.closeWebDriver();
    }

    @Test
    void successFillTest() {
        open("/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));

        $("#firstName").setValue("Ivan Smith");
        $("#lastName").setValue("Smith");
        $("#userEmail").setValue("qwerty@gmail.com");

        $(byText("Male")).click();

        $("#userNumber").setValue("8980283637");

        $("#dateOfBirthInput").scrollTo().click();
        $(".react-datepicker__month-select").selectOptionByValue("3");
        $(".react-datepicker__year-select").selectOptionByValue("1996");
        $(".react-datepicker__day--008").click();

        $("#subjectsInput").setValue("science");
        $(byText("Computer Science")).click();

        $(byText("Sports")).click();
        $(byText("Reading")).click();
        $(byText("Music")).click();

        $("#uploadPicture").uploadFromClasspath("img/img.png");

        $("#currentAddress").setValue("New York, 50");

        $("#react-select-3-input").setValue("Rajasthan").pressEnter();
        $("#react-select-4-input").setValue("Jaipur").pressEnter();


        $("#submit").click();

        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Student Name Ivan Smith Smith"), text("Student Email qwerty@gmail.com"),
                text("Gender Male"), text("Mobile 8980283637"), text("Date of Birth 08 April,1996"),
                text("Subjects Computer Science"), text("Hobbies Sports, Reading, Music"), text("Picture img.png"),
                text("Address New York, 50"), text("State and City Rajasthan Jaipur"));
    }
}


