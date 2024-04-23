package QdaaStore.utils;

import com.github.javafaker.Faker;

public class RandomArItems {
    public static String randomData() {
        Faker faker = new Faker();
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

    public static String randomItemsName(){
        Faker faker = new Faker();
       String stockName =  faker.commerce().productName() ;
       return stockName ;
    }

    }
