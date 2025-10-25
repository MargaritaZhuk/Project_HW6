package tests;

import data.TestData;
import org.junit.jupiter.api.Test;
import pages.components.ResultModalComponent;
import pages.RegistrationPage;


public class RegistrationFillInForm extends TestBase {
        RegistrationPage registrationPage = new RegistrationPage();
        ResultModalComponent resultModalComponent = new ResultModalComponent();
        TestData td = new TestData();

        @Test
        void fillTextFormTest() {
            registrationPage.openPage()
                            .removeBanners()
                            .setFirstName(td.firstName)
                            .setLastName(td.lastName)
                            .setEmail(td.userEmail)
                            .setGender(td.userGender)
                            .setPhone(td.userPhone)
                            .setDateOfBirth(td.birthYear, td.birthMonth, td.birthDate)
                            .setSubjects(td.userSubject)
                            .setHobbies(td.userHobbies)
                            .setPicture(td.userPicture)
                            .setAddress(td.userAddress)
                            .setState(td.userState)
                            .setCity(td.userCity)
                            .submitForm();

            resultModalComponent.checkModalIsOpen()
                                .checkResult("Student Name", td.firstName + " " + td.lastName)
                                .checkResult("Student Email", td.userEmail)
                                .checkResult("Gender", td.userGender)
                                .checkResult("Mobile", td.userPhone)
                                .checkResult("Date of Birth", td.birthDate + " " + td.birthMonth + "," + td.birthYear)
                                .checkResult("Subjects", td.userSubject)
                                .checkResult("Hobbies", td.userHobbies)
                                .checkResult("Picture", td.userPicture)
                                .checkResult("Address", td.userAddress)
                                .checkResult("State and City", td.userState + " " + td.userCity)
                                .closeModal();
        }

    @Test
    void fillMinimalFormTest() {
        registrationPage.openPage()
                        .removeBanners()
                        .setFirstName(td.firstName)
                        .setLastName(td.lastName)
                        .setGender(td.userGender)
                        .setPhone(td.userPhone)
                        .setDateOfBirth(td.birthYear, td.birthMonth, td.birthDate)
                        .submitForm();

        resultModalComponent.checkModalIsOpen()
                            .checkResult("Student Name", td.firstName + " " + td.lastName)
                            .checkEmptyResult("Student Email")
                            .checkResult("Gender", td.userGender)
                            .checkResult("Mobile", td.userPhone)
                            .checkResult("Date of Birth", td.birthDate + " " + td.birthMonth + "," + td.birthYear)
                            .checkEmptyResult("Subjects")
                            .checkEmptyResult("Hobbies")
                            .checkEmptyResult("Picture")
                            .checkEmptyResult("Address")
                            .checkEmptyResult("State and City")
                            .closeModal();

    }

    @Test
    void validationTextFormTest() {
        registrationPage.openPage()
                        .removeBanners()
                        .submitForm()
                        .checkOverallValidation()
                        .checkFirstNameValidation()
                        .checkLastNameValidation()
                        .checkGenderValidation()
                        .checkPhoneValidation();
        resultModalComponent.checkModalIsNotOpen();
    }

    @Test
    void emailValidationTest() {
        registrationPage.openPage()
                .removeBanners()
                .setFirstName(td.firstName)
                .setLastName(td.lastName)
                .setGender(td.userGender)
                .setPhone(td.userPhone)
                .setEmail(td.invalidEmail)
                .submitForm()
                .checkEmailValidation();
        resultModalComponent.checkModalIsNotOpen();
    }
}






