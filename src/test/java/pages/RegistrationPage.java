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

    @Step("��������� �������� {form}")
    public void openPage(String form) {
        open("/automation-practice-form");
        headerTitle.shouldHave(text(form));
    }

    @Step("������ �������, ���")
    public void setName(String firstName, String lastName) {
        firstNameInput.setValue(firstName);
        lastNameInput.setValue(lastName);
    }

    @Step("������ email")
    public void setEmailInput(String userEmail) {
        emailInput.setValue(userEmail);
    }

    @Step("�������� ���")
    public void selectGender(String gender) {
        $(byText(gender)).click();
    }

    @Step("������ ����� ��������")
    public void setUserNumber(String userNumber) {
        userNumberInput.setValue(userNumber);
    }

    @Step("�������� ���� ��������")
    public void setBirthDate(String day, String month, String year) {
        calendarForm.scrollTo().click();
        calendarComponent.setDate(day, month, year);
    }

    @Step("�������� ��������")
    public void setSubjectsInput(String subjects) {
        subjectsInput.setValue(subjects).pressEnter();
    }

    @Step("�������� �����")
    public void selectHobbies(String hobbies) {
        $(byText("Sports")).click();
        $(byText("Reading")).click();
        $(byText("Music")).click();
    }

    @Step("��������� ��������")
    public void setPicture(String picture) {
        selectPicture.uploadFromClasspath("img/img.png");
    }

    @Step("������ �����")
    public void setAddress(String address, String state, String city) {
        addressInput.setValue(address);
        selectState.setValue(state).pressEnter();
        selectCity.setValue(city).pressEnter();
    }

    @Step("�������� �� ������ Submit")
    public void clickButton() {
        submitButton.click();
    }

    @Step("��������� ��������� ����������� ������� ({title})")
    public void checkTitle(String title) {
        headerTable.shouldHave(text(title));
    }

    @Step("���������, ��� ������ � ������� � ���� Student Name ������������� ��������� ���������")
    public void checkName(String fieldName, String value) {
        resultsTable.shouldHave(text(fieldName), text(value));
    }

    @Step("���������, ��� ������ � ������� � ���� Student Email ������������� ��������� ���������")
    public void checkEmail(String fieldName, String value) {
        resultsTable.shouldHave(text(fieldName), text(value));
    }

    @Step("���������, ��� ������ � ������� � ���� Gender ������������� ���������� ��������")
    public void checkGender(String fieldName, String value) {
        resultsTable.shouldHave(text(fieldName), text(value));
    }

    @Step("���������, ��� ������ � ������� � ���� Mobile ������������� ���������� ��������")
    public void checkPhone(String fieldName, String value) {
        resultsTable.shouldHave(text(fieldName), text(value));
    }

    @Step("���������, ��� ������ � ������� � ���� Date of Birth ������������� ���������� ��������")
    public void checkDate(String fieldName, String value) {
        resultsTable.shouldHave(text(fieldName), text(value));
    }

    @Step("���������, ��� ������ � ������� � ���� Subjects ������������� ��������� ���������")
    public void checkSubj(String fieldName, String value) {
        resultsTable.shouldHave(text(fieldName), text(value));
    }

    @Step("���������, ��� ������ � ������� � ���� Hobbies ������������� ��������� ���������")
    public void checkHobbies(String fieldName, String value) {
        resultsTable.shouldHave(text(fieldName), text(value));
    }

    @Step("��������� � ������� � ���� Picture, ��� �������� ��������� � ��������� ����������� ��������")
    public void checkPic(String fieldName, String value) {
        resultsTable.shouldHave(text(fieldName), text(value));
    }

    @Step("���������, ��� ������ � ������� � ���� Address ������������� ���������� ��������")
    public void checkAddress(String fieldName, String value) {
        resultsTable.shouldHave(text(fieldName), text(value));
    }

    @Step("���������, ��� ������ � ������� � ���� State and City ������������� ��������� ���������")
    public void checkStateCity(String fieldName, String value) {
        resultsTable.shouldHave(text(fieldName), text(value));
    }
}
