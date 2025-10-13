package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class fillTestForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000;
    }

    @Test
    void fullFillTextForm () {
        open("/automation-practice-form");
        $("#firstName").setValue("Margarita"); // ввести имя
        $("#lastName").setValue("Zhuk"); // ввести фамилию
        $("#userEmail").setValue("zhukrita@gmail.com"); // ввести почту
        $("#genterWrapper").$(byText("Female")).click(); // выбрать пол (радиобатон)
        $("#userNumber").setValue("9663453928"); // ввести номер телефона
        $("#dateOfBirthInput").click(); // кликнуть по полю даты рождения
        $(".react-datepicker__year-select").selectOption("1997"); // выбрать в дейтпикере год
        $(".react-datepicker__month-select").selectOption(2); // выбрать в дейтпикере месяц
        $(".react-datepicker__day--005:not(.react-datepicker__day--outside-month)").click(); // выбрать день
        $("#subjectsInput").setValue("M").pressEnter();; // // Ввести букву 'M'
        $("#hobbiesWrapper").$(byText("Sports")).click(); // Выбрать спорт
        $("#uploadPicture").uploadFromClasspath("image1.jpeg"); // загрузить картинку
        $("#currentAddress").setValue("Address 1");

        // Выбор города и штата через ввод
        $("#stateCity-wrapper #state input").setValue("NCR").pressEnter();
        $("#stateCity-wrapper #city input").setValue("Delhi").pressEnter();

        // Нажать на кнопку
        $("#submit").click();

        //Проверка заголовка
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));

        //Проверка значений CSS-селекторы

        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Margarita Zhuk"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("zhukrita@gmail.com"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Female"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("9663453928"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("05 March,1997"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Maths"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sports"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("image1.jpeg"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Address 1"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Delhi"));

    }

}
