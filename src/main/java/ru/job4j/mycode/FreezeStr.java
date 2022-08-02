package ru.job4j.mycode;

import java.util.HashMap;
import java.util.Map;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        boolean rsl = true;
        char[] charLeft = left.toCharArray();
        char[] charRight = right.toCharArray();
        Map<String, Integer> setLeft = new HashMap<>();
        for (char temp : charLeft) {
            Integer count = setLeft.get(String.valueOf(temp));
            setLeft.put(String.valueOf(temp), count == null ? 1 : ++count);
        }
        for (char temp : charRight) {
            Integer count = setLeft.get(String.valueOf(temp));
            count = count == null ? -1 : --count;
            if (count < 0) {
                rsl = false;
                break;
            }
            setLeft.put(String.valueOf(temp), count);
        }
        if (left.length() != right.length()) {
            rsl = false;
        }
        return rsl;
    }
}
