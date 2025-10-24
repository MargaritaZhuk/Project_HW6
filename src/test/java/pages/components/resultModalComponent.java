package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class resultModalComponent {

    private final SelenideElement modalHeader = $(".modal-header"),
            resultsTable = $(".table-responsive"),
            closeButton = $("#closeLargeModal");

    public resultModalComponent checkModalIsOpen() {
        modalHeader.shouldHave(text("Thanks for submitting the form"));
        return this;
    }

    public void checkModalIsNotOpen() {
        modalHeader.shouldNotBe(visible);
    }

    public resultModalComponent checkResult(String key, String value) {
        resultsTable.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }

    public resultModalComponent checkEmptyResult(String key) {
        resultsTable.$(byText(key)).parent().$$("td").get(1).shouldBe(empty);
        return this;
    }

    public void closeModal() {
        closeButton.click();
        checkModalIsNotOpen();
    }
}
