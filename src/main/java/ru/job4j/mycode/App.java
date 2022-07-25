package ru.job4j.mycode;
import java.util.*;

public class App {
    public static void main(String[] args) {
        PriorityQueue<MyStudent> prQueue = new PriorityQueue<>();
        prQueue.add(new MyStudent("4", 4));
        prQueue.add(new MyStudent("2", 2));
        prQueue.add(new MyStudent("1", 1));
        prQueue.add(new MyStudent("8", 8));
        System.out.println(prQueue.remove());
        System.out.println(prQueue.remove());
        System.out.println(prQueue.remove());
        System.out.println(prQueue.remove());
    }
}
