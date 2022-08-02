package ru.job4j.mycode;

import ru.job4j.collection.map.User;

import java.util.*;


public class Article {
    public static boolean generateBy(String origin, String line) {
        boolean rsl = true;
        String[] originArray = origin.toLowerCase().replaceAll("[^а-я ]", "").split(" ");
        Set<String> setOrigin = new HashSet<>();
        for (String temp : originArray) {
            setOrigin.add(temp);
        }
        String[] lineArray = line.toLowerCase().split(" ");
        for (String temp : lineArray) {
            if (!setOrigin.contains(temp)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}
