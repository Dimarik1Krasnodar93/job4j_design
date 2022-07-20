package ru.job4j.collection.map;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class TestConsole {
    public static void main(String[] args) {
        User user1 = new User("1", new GregorianCalendar(1990, 1, 25));
        User user2 = new User("1", new GregorianCalendar(1990, 1, 25));
        Object obj1 = new Object();
        Object obj2 = new Object();
        Map<User, Object> map = new HashMap<>();
        map.put(user1, obj1);
        map.put(user2, obj2);
        System.out.println(map.get(user1));
        System.out.println(map.get(user2));
        int hashCode1 = user1.hashCode();
        int hash1 = hashCode1 ^ (hashCode1 >>> 16);
        int buchet1 = hash1 % 15;
        int hashCode2 = user2.hashCode();
        int hash2 = hashCode2 ^ (hashCode2 >>> 16);
        int buchet2 = hash2 % 15;
    }
}

