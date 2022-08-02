package ru.job4j.question;

import java.util.Objects;

public class User {

    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        User user = (User) obj;
        return user.id == id && user.name.equals(name);
    }

    @Override
    public int hashCode() {
        return id * 1000000 +  name.length() * 1000 +  name.length() != 0 ? name.toCharArray()[0] : 1;
    }
}