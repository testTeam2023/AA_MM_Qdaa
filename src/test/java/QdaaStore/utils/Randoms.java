package QdaaStore.utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class Randoms {

    public static String randomArData() {
        Faker faker = new Faker(new Locale("ar"));
        // Generating a random length between 1 and 9
        int length = faker.random().nextInt(1, 10);
        StringBuilder itemNameAR = new StringBuilder();
        for (int i = 0; i < length; i++) {
            // Generating a random Arabic character
            char randomChar = faker.lorem().character();
            itemNameAR.append(randomChar);
        }
        return itemNameAR.toString();
    }
    public static String  randomStringNumber() {
        Faker faker = new Faker();
        return faker.number().toString();
    }
}
