package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    CalendarComponent calendarComponent = new CalendarComponent();

    final private SelenideElement
            headerTitle = $(".main-header"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            calendarForm = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            selectPicture = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            selectState = $("#react-select-3-input"),
            selectCity = $("#react-select-4-input"),
            submitButton = $("#submit"),
            headerTable = $(".modal-header"),
            resultsTable = $(".table-responsive");

    @Step("Открываем страницу {form}")
    public void openPage(String form) {
        open("/automation-practice-form");
        headerTitle.shouldHave(text(form));
    }

    @Step("Вводим фамилию, имя")
    public void setName(String firstName, String lastName) {
        firstNameInput.setValue(firstName);
        lastNameInput.setValue(lastName);
    }

    @Step("Вводим email")
    public void setEmailInput(String userEmail) {
        emailInput.setValue(userEmail);
    }

    @Step("Выбираем пол")
    public void selectGender(String gender) {
        $(byText(gender)).click();
    }

    @Step("Вводим номер телефона")
    public void setUserNumber(String userNumber) {
        userNumberInput.setValue(userNumber);
    }

    @Step("Выбираем дату рождения")
    public void setBirthDate(String day, String month, String year) {
        calendarForm.scrollTo().click();
        calendarComponent.setDate(day, month, year);
    }

    @Step("Выбираем предметы")
    public void setSubjectsInput(String subjects) {
        subjectsInput.setValue(subjects).pressEnter();
    }

    @Step("Выбираем хобби")
    public void selectHobbies(String hobbies) {
        $(byText("Sports")).click();
        $(byText("Reading")).click();
        $(byText("Music")).click();
    }

    @Step("Загружаем картинку")
    public void setPicture(String picture) {
        selectPicture.uploadFromClasspath("img/img.png");
    }

    @Step("Вводим адрес")
    public void setAddress(String address, String state, String city) {
        addressInput.setValue(address);
        selectState.setValue(state).pressEnter();
        selectCity.setValue(city).pressEnter();
    }

    @Step("Нажимаем на кнопку Submit")
    public void clickButton() {
        submitButton.click();
    }

    @Step("Проверяем заголовок открывшейся таблицы ({title})")
    public void checkTitle(String title) {
        headerTable.shouldHave(text(title));
    }

    @Step("Проверяем, что данные в таблице в поле Student Name соответствуют введенным значениям")
    public void checkName(String fieldName, String value) {
        resultsTable.shouldHave(text(fieldName), text(value));
    }

    @Step("Проверяем, что данные в таблице в поле Student Email соответствуют введенным значениям")
    public void checkEmail(String fieldName, String value) {
        resultsTable.shouldHave(text(fieldName), text(value));
    }

    @Step("Проверяем, что данные в таблице в поле Gender соответствуют выбранному значению")
    public void checkGender(String fieldName, String value) {
        resultsTable.shouldHave(text(fieldName), text(value));
    }

    @Step("Проверяем, что данные в таблице в поле Mobile соответствуют введенныму значению")
    public void checkPhone(String fieldName, String value) {
        resultsTable.shouldHave(text(fieldName), text(value));
    }

    @Step("Проверяем, что данные в таблице в поле Date of Birth соответствуют выбранному значению")
    public void checkDate(String fieldName, String value) {
        resultsTable.shouldHave(text(fieldName), text(value));
    }

    @Step("Проверяем, что данные в таблице в поле Subjects соответствуют выбранным значениям")
    public void checkSubj(String fieldName, String value) {
        resultsTable.shouldHave(text(fieldName), text(value));
    }

    @Step("Проверяем, что данные в таблице в поле Hobbies соответствуют выбранным значениям")
    public void checkHobbies(String fieldName, String value) {
        resultsTable.shouldHave(text(fieldName), text(value));
    }

    @Step("Проверяем в таблице в поле Picture, что название совпадает с названием загруженной картинки")
    public void checkPic(String fieldName, String value) {
        resultsTable.shouldHave(text(fieldName), text(value));
    }

    @Step("Проверяем, что данные в таблице в поле Address соответствуют введенному значению")
    public void checkAddress(String fieldName, String value) {
        resultsTable.shouldHave(text(fieldName), text(value));
    }

    @Step("Проверяем, что данные в таблице в поле State and City соответствуют выбранным значениям")
    public void checkStateCity(String fieldName, String value) {
        resultsTable.shouldHave(text(fieldName), text(value));
    }

   /* public RegistrationPage checkForm(String fieldName, String value) {
        headerTable.shouldHave(text("Thanks for submitting the form"));
        resultsTable.shouldHave(text (fieldName), text(value));
        return this;



   /* public RegistrationPage openPage() {
        open("/automation-practice-form");
        headerTitle.shouldHave(text("Practice Form"));
        return this;
    }

    public RegistrationPage setName(String firstName, String lastName) {
        firstNameInput.setValue(firstName);
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage setEmailInput(String userEmail) {
        emailInput.setValue(userEmail);
        return this;
    }

    public RegistrationPage selectGender(String gender) {
        $(byText(gender)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String userNumber) {
        userNumberInput.setValue(userNumber);
        return this;
    }


    public RegistrationPage setBirthDate(String day, String month, String year) {
        calendarForm.scrollTo().click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubjectsInput(String subjects) {
        subjectsInput.setValue(subjects).pressEnter();
        return this;
    }

    public RegistrationPage selectHobbies(String hobbies) {
        $(byText("Sports")).click();
        $(byText("Reading")).click();
        $(byText("Music")).click();
        return this;
    }

    public RegistrationPage setPicture(String picture) {
        selectPicture.uploadFromClasspath("img/img.png");
        return this;
    }

    public RegistrationPage setAddress(String address, String state, String city) {
        addressInput.setValue(address);
        selectState.setValue(state).pressEnter();
        selectCity.setValue(city).pressEnter();
        return this;
    }

    public RegistrationPage clickButton() {
        submitButton.click();
        return this;
    }

    public RegistrationPage checkForm(String fieldName, String value) {
        headerTable.shouldHave(text("Thanks for submitting the form"));
        resultsTable.shouldHave(text (fieldName), text(value));
        return this;
    }

    */

}
