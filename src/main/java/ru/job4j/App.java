package ru.job4j;
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "1");
        map.put(1, "2");
        System.out.println(map.get(1));
        LinkedList<String> list = new LinkedList<>();
        list.add("Geeks1");
        list.add("for2");
        list.add("Geeks3");
        list.offer("_4");
        for (var temp : list) {
            System.out.println(temp);
        }

    }
}
