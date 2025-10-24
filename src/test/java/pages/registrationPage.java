package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.calendarComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class registrationPage {

    private final SelenideElement header = $("h1"),
                                firstNameInput = $("#firstName"),
                                lastNameInput = $("#lastName"),
                                emailInput = $("#userEmail"),
                                genderSelector = $("#genterWrapper"),
                                phoneInput =  $("#userNumber"),
                                subjectsInput = $("#subjectsInput"),
                                hobbiesSelector = $("#hobbiesWrapper"),
                                uploadPicture = $("#uploadPicture"),
                                addressInput = $("#currentAddress"),
                                stateInput = $("#stateCity-wrapper #state input"),
                                cityInput = $("#stateCity-wrapper #city input"),
                                submitButton = $("#submit"),
                                dateOfBirthInput = $("#dateOfBirthInput");

    calendarComponent calendar = new calendarComponent();

    public registrationPage openPage() {
        open("/automation-practice-form");
        header.shouldHave(text("Practice Form"));
        return this;
    }

    public registrationPage removeBanners() {
            executeJavaScript("$('#fixedban').remove()");
            executeJavaScript("$('footer').remove()");
            return this;
    }

    public registrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public registrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public registrationPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public registrationPage setGender(String value) {
        genderSelector.$(byText(value)).click();
        return this;
    }

    public registrationPage setPhone(String value) {
        phoneInput.setValue(value);
        return this;
    }

    public registrationPage setDateOfBirth(String year, String month, String day) {
        dateOfBirthInput.click();
        calendar.setDate(year, month, day);
        return this;
    }

    public registrationPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public registrationPage setHobbies(String value) {
       hobbiesSelector.$(byText(value)).click();
       return this;
    }

    public registrationPage setPicture(String path) {
        uploadPicture.uploadFromClasspath(path);
        return this;
    }

    public registrationPage setAddress(String value) {
       addressInput.setValue(value);
       return this;
    }

    public registrationPage setState(String value) {
        stateInput.setValue(value).pressEnter();
        return this;
    }

    public registrationPage setCity(String value) {
        cityInput.setValue(value).pressEnter();
        return this;
    }

    public registrationPage submitForm() {
        submitButton.scrollTo().click();
        return this;
    }

    public registrationPage checkOverallValidation() {
        $(".was-validated").shouldBe(visible);
        return this;
    }

    public registrationPage checkFirstNameValidation(){
        firstNameInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        return this;
    }

    public registrationPage checkLastNameValidation(){
        lastNameInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        return this;
    }

    public registrationPage checkEmailValidation(){
        emailInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        return this;
    }

    public registrationPage checkPhoneValidation(){
        phoneInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        return this;
    }

    public registrationPage checkGenderValidation() {
        genderSelector.$$("[for^='gender-radio']")
                .forEach(label -> label.shouldHave(cssValue("color", "rgba(220, 53, 69, 1)")));
        return this;
    }
}