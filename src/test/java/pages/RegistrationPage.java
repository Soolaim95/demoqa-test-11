package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    //locators
    final private SelenideElement
            headerTitle = $(".main-header"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            selectPicture = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            selectState = $("#react-select-3-input"),
            selectCity = $("#react-select-4-input"),
            resultsTable = $(".table-responsive");



    //actions

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        headerTitle.shouldHave(text("Practice Form"));
        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage setEmailInput(String userEmail) {
        emailInput.setValue(userEmail);
        return this;
    }

    public RegistrationPage setGender(String gender) {
        $(byText("Male")).click();
        return this;
    }

    public RegistrationPage setUserNumber(String userNumber) {
        userNumberInput.setValue(userNumber);
        return this;
    }


    public RegistrationPage setBirthDate(String month, String year) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("2");
        $(".react-datepicker__year-select").selectOptionByValue("1995");
        $(".react-datepicker__day--008").click();
        return this;
    }

    public RegistrationPage setSubjectsInput(String subjects) {
        subjectsInput.setValue("science");
        $(byText("Computer Science")).click();
        return this;
    }

    public RegistrationPage setHobbies(String hobbies) {
        $(byText("Sports")).click();
        $(byText("Reading")).click();
        $(byText("Music")).click();
        return this;
    }

    public RegistrationPage setPicture(String picture) {
        selectPicture.uploadFromClasspath("img/img.png");
        return this;
    }

    public RegistrationPage setAddress(String address) {
        addressInput.setValue("New York, 50");
        return this;
    }

    public RegistrationPage setState(String state) {
        selectState.setValue("Rajasthan").pressEnter();
        return this;
    }

    public RegistrationPage setCity(String city) {
        selectCity.setValue("Jaipur").pressEnter();
        return this;
    }

    public RegistrationPage checkForm(String value) {
        resultsTable.shouldHave(text(value));
        return this;
    }


}
