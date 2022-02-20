package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {

    //locators
    final private SelenideElement firstNameInput = $("#firstName");
    final private SelenideElement lastNameInput = $("#lastName");
    final private SelenideElement emailInput = $("#userEmail");

   final private SelenideElement resultsTable = $(".table-responsive");


    //actions

    public void setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
    }

    public void setLastName(String lastName) {
        lastNameInput.setValue(lastName);
    }

    public void checkForm(String value) {
        resultsTable.shouldHave(text(value));
    }

    public void setEmailInput(String userEmail) {
        emailInput.setValue(userEmail);
    }

}
