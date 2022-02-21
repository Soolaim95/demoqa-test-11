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
    String firstName = "John Michael",
            lastName = "Smith",
            userEmail = "qwerty@gmail.com",
            gender  = "Male",
            userNumber = "8979674434",
            subjects = "Computer Science",
            hobbies = "Sports" + "Music" + "Reading",
            picture = "img.png",
            address = "New York, 50",
            state = "Rajasthan",
            city = "Jaipur";

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void successFillTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmailInput(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setSubjectsInput(subjects)
                .setHobbies(hobbies)
                .setPicture(picture)
                .setAddress(address)
                .setState(state)
                .setCity(city);


        registrationPage.setBirthDate("2", "1995");


        // $("#submit").scrollTo().click();

        $(".modal-header").shouldHave(text("Thanks for submitting the form"));

        registrationPage
                .checkForm("Student Name" + firstName + " " + lastName)
                .checkForm("Student Email" + userEmail)
                .checkForm("Gender" + gender)
                .checkForm("Mobile" + userNumber)
                .checkForm("Date of Birth 08 March,1995")
                .checkForm("Subjects" + subjects)
                .checkForm("Hobbies" + hobbies)
                .checkForm("Picture" + picture)
                .checkForm("Address" + address)
                .checkForm("State and City" + state + city);

    }
}



