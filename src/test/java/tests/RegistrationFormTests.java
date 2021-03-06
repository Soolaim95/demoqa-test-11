package tests;

import com.codeborne.selenide.Configuration;
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
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void successFillTest() {
        open("/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));

        $("#firstName").setValue("Ivan Michael");
        $("#lastName").setValue("Smith");
        $("#userEmail").setValue("qwerty@gmail.com");

        $(byText("Male")).click();

        $("#userNumber").setValue("89990057676");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("2");
        $(".react-datepicker__year-select").selectOptionByValue("1995");
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
        $(".table-responsive").shouldHave(text("Student Name John Michael Smith"), text("Student Email qwerty@gmail.com"),
                text("Gender Male"), text("Mobile 8979674434"), text("Date of Birth 08 March,1995"),
                text("Subjects Computer Science"), text("Hobbies Sports, Reading, Music"), text("Picture img.png"),
                text("Address New York, 50"), text("State and City Rajasthan Jaipur"));
    }
}


