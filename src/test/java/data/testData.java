package data;

import com.github.javafaker.Faker;

import java.util.Locale;

public class testData {
    Faker faker = new Faker(Locale.ENGLISH);
    public String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            invalidEmail = faker.internet().emailAddress().replace("@","0"),
            userPhone = faker.number().digits(10),
            userSubject = faker.options().option("Sports", "Economics", "English", "Biology"),
            userGender = faker.options().option("Male", "Female", "Other"),
            userHobbies = faker.options().option("Sports", "Reading", "Music"),
            birthYear = String.valueOf(faker.number().numberBetween(1925, 2024)),
            birthMonth = faker.options().option("January", "February", "March", "April",
                    "May", "June", "July", "August", "September", "October", "November", "December"),
            birthDate = String.valueOf(faker.number().numberBetween(1, 28)),
            userPicture = faker.options().option("image1.jpeg", "image2.jpg", "image3.jpg"),
            userAddress = faker.address().fullAddress(),
            userState = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            userCity = getCityByState(userState);

    public String getCityByState(String userState) {
        return switch (userState) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> null;
        };
    }
}
