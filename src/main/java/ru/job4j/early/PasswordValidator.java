package ru.job4j.early;


import java.util.Locale;
import java.util.function.Predicate;


public class PasswordValidator {
    private static final String PASSWORD_REGEX = "^(?=.*[`@#$%^&+=_.])";

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }

        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        Character[] characterPass = password.chars()
                .mapToObj(ch -> (char) ch)
                .toArray(Character[]::new);
        if (!checkPass(characterPass, i -> i == Character.toTitleCase(i) && Character.isAlphabetic(i))) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (!checkPass(characterPass, i -> i == Character.toLowerCase(i)  && Character.isAlphabetic(i))) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (!checkPass(characterPass, i -> Character.isDigit(i))) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (!checkPass(characterPass,  i -> !Character.isDigit(i) && !Character.isAlphabetic(i))) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }

        String passwordLowercase = password.toLowerCase(Locale.ROOT);
        if (passwordLowercase.contains("qwerty")
                ||  passwordLowercase.contains("12345")
                ||  passwordLowercase.contains("password")
                ||  passwordLowercase.contains("admin")
                ||  passwordLowercase.contains("user")) {
            throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
        }
        return password;

    }

    public static boolean checkPass(Character[] characters, Predicate<Character> predicate) {
        for (Character ch : characters) {
            if (predicate.test(ch)) {
                return true;
            }
        }
        return false;
    }

}
