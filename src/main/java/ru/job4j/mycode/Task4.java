package ru.job4j.mycode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Task4 {
    public static List<Integer> extractUnique(List<Integer> left, List<Integer> right) {
        Set<Integer> setLeft = new HashSet<>(left);
        Set<Integer> setRight = new HashSet<>(right);
        List<Integer> rsl = new ArrayList<>();
        for (var temp : setRight) {
            if (!setLeft.contains(temp)) {
                rsl.add(temp);
            }
        }
        for (var temp : setLeft) {
            if (!setRight.contains(temp)) {
                rsl.add(temp);
            }
        }
        return rsl;
    }
}
