package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byText;

public class CalendarComponent {

    private SelenideElement
            setMonth = $(".react-datepicker__month-select"),
            setYear = $(".react-datepicker__year-select");

    public CalendarComponent setDate(String day, String month, String year) {
        setMonth.selectOption(month);
        setYear.selectOptionByValue(year);
        $(byText(day)).click();
        return this;
    }
}
