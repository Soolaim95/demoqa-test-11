package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    private SelenideElement
            setMonth = $(".react-datepicker__month-select"),
            setYear = $(".react-datepicker__year-select"),
            setDay = $(".react-datepicker__day--008");

    public CalendarComponent setDate(String month, String year) {
        setMonth.selectOption(month);
        setYear.selectOptionByValue(year);
        setDay.click();
        return this;
    }
}
