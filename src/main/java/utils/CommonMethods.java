package utils;

import java.util.Random;

public class CommonMethods {


    public static String generateRandomEmail() {
        String chars = "abcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder emailPrefix = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            emailPrefix.append(chars.charAt(random.nextInt(chars.length())));
        }

        return emailPrefix.toString() + "@fpl.com";
    }

}
