package pages;

import com.codeborne.selenide.SelenideElement;
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

    public RegistrationPage openPage() {
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
        calendarForm.click();
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

}
