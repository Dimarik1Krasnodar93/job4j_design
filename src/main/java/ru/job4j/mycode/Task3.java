package ru.job4j.mycode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Task3 {
    public static List<Integer> extractDuplicates(List<Integer> left, List<Integer> right) {
        Set<Integer> setMax = new HashSet<>();
        List<Integer> maxList;
        List<Integer> minList;
        List<Integer> rsl = new ArrayList<>();

        if (left.size() >= right.size()) {
            maxList = left;
            minList = right;
        } else {
            maxList = right;
            minList = left;
        }
        for (Integer temp : maxList) {
            setMax.add(temp);
        }
        for (Integer temp : minList) {
            if (setMax.contains(temp)) {
                rsl.add(temp);
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        left.add(1);
        left.add(2);
        left.add(3);
        right.add(3);
        right.add(4);
        right.add(6);
        System.out.println(extractDuplicates(left,  right));
    }

}
