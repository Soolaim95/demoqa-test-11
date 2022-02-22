package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationFormWithPageObjectsTests {

    RegistrationPage registrationPage = new RegistrationPage();
    String firstName = "John Michael",
            lastName = "Smith",
            userEmail = "qwerty@gmail.com",
            gender  = "Male",
            userNumber = "8979674434",
            day = "10",
            month = "March",
            year = "1995",
            subjects = "Computer Science",
            hobbies = "Sports" + "," + " " + "Reading" + "," + " " + "Music",
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
                .setName(firstName, lastName)
                .setEmailInput(userEmail)
                .selectGender(gender)
                .setUserNumber(userNumber)
                .setBirthDate(day, month, year)
                .setSubjectsInput(subjects)
                .selectHobbies(hobbies)
                .setPicture(picture)
                .setAddress(address, state, city)
                .clickButton();

        registrationPage
                .checkForm("Student Name", firstName + " " + lastName)
                .checkForm("Student Email", userEmail)
                .checkForm("Gender", gender)
                .checkForm("Mobile", userNumber)
                .checkForm("Date of Birth", day + " " + month + "," + year)
                .checkForm("Subjects", subjects)
                .checkForm("Hobbies", hobbies)
                .checkForm("Picture", picture)
                .checkForm("Address", address)
                .checkForm("State and City", state + " " + city);

    }

}



