package ru.job4j.early;


import java.util.Arrays;
import java.util.Locale;
import java.util.function.Predicate;


public class PasswordValidator {

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
        if (!checkPass(characterPass, i -> Character.isUpperCase(i))) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (!checkPass(characterPass, i -> Character.isLowerCase(i))) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (!checkPass(characterPass, i -> Character.isDigit(i))) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (!checkPass(characterPass,  i -> !Character.isDigit(i) && !Character.isAlphabetic(i))) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        String passwordLowercase = password.toLowerCase(Locale.ROOT);
        String[] strExclude = {"qwerty", "12345", "password", "admin", "user"};
        if (Arrays.stream(strExclude).filter(i -> passwordLowercase.contains(i)).count() > 0) {
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
