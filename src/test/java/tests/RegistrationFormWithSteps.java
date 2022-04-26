package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class RegistrationFormWithSteps {

    RegistrationPage steps = new RegistrationPage();
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

    private static final String FORM = "Practice Form";
                         String TABLE_TITLE = "Thanks for submitting the form";

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "593x593";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Table screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }

    @Test
    @Owner("polyakovaea")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Регистрационная форма студента") //название функциональности
    @Story("Заполнение формы и отправка данных студента") //краткое общее описание для группировки тестов
    @DisplayName("Проверка соответствия введеных данных студента в форму и отображаемых значений в таблице")
    @Description(
            "Этот тест проверяет заполнение всех полей регистр. формы и корректное отображение введенных данных в таблице"
    ) //подробное описание
    @Link(value = "demoqa", url = "https://demoqa.com") //url тестируемой страницы

    void successFillTest() {
        steps.openPage(FORM);
        steps.setName(firstName, lastName);
        steps.setEmailInput(userEmail);
        steps.selectGender(gender);
        steps.setUserNumber(userNumber);
        steps.setBirthDate(day, month, year);
        steps.setSubjectsInput(subjects);
        steps.selectHobbies(hobbies);
        steps.setPicture(picture);
        steps.setAddress(address, state, city);
        steps.clickButton();

        steps.checkTitle(TABLE_TITLE);
        steps.checkName("Student Name", firstName + " " + lastName);
        steps.checkEmail("Student Email", userEmail);
        steps.checkGender("Gender", gender);
        steps.checkPhone("Mobile", userNumber);
        steps.checkDate("Date of Birth", day + " " + month + "," + year);
        steps.checkSubj("Subjects", subjects);
        steps.checkHobbies("Hobbies", hobbies);
        steps.checkPic("Picture", picture);
        steps.checkAddress("Address", address);
        steps.checkStateCity("State and City", state + " " + city);
    }
}



