package ru.job4j.mycode;

public class MyStudent implements Comparable {
    private String name;
    private int age;
    public MyStudent(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Object st2) {
        return Integer.compare(age, ((MyStudent) st2).age);
    }

    @Override
    public String toString() {
        return name + " age " + age;
    }
}