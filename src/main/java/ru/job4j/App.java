package ru.job4j;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "1");
        map.put(1, "2");
        System.out.println(map.get(1));

    }
}
