package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormWithPageObjectsTests {

    RegistrationPage registrationPage = new RegistrationPage();
    String firstName = "John Michael";
    String lastName = "Smith";
    String userEmail = "qwerty@gmail.com";

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void successFillTest() {
        open("/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));

        registrationPage.setFirstName(firstName);
        registrationPage.setLastName(lastName);
        registrationPage.setEmailInput(userEmail);

        $(byText("Male")).click();

        $("#userNumber").setValue("8979674434");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("2");
        $(".react-datepicker__year-select").scrollTo().selectOptionByValue("1995");
        $(".react-datepicker__day--008").click();

        $("#subjectsInput").setValue("science");
        $(byText("Computer Science")).click();

        $(byText("Sports")).click();
        $(byText("Reading")).click();
        $(byText("Music")).click();

        $("#uploadPicture").uploadFile(new File("C:/Users/polia/Desktop/photos/detroit.jpg"));

        $("#currentAddress").setValue("New York, 50");

        $("#react-select-3-input").setValue("Rajasthan").pressEnter();
        $("#react-select-4-input").setValue("Jaipur").pressEnter();


        $("#submit").scrollTo().click();

        $(".modal-header").shouldHave(text("Thanks for submitting the form"));

        registrationPage.checkForm(firstName + lastName + "Student Name");
        registrationPage.checkForm(userEmail + "Student Email");
        registrationPage.checkForm("Gender Male");
        registrationPage.checkForm("Mobile 8979674434");
        registrationPage.checkForm("Date of Birth 08 March,1995");
        registrationPage.checkForm("Subjects Computer Science");
        registrationPage.checkForm("Hobbies Sports, Reading, Music");
        registrationPage.checkForm("Picture detroit.jpg");
        registrationPage.checkForm("Address New York, 50");
        registrationPage.checkForm("State and City Rajasthan Jaipur");

    }
}



