package ru.job4j.collection.map;

import java.util.Calendar;

public class User {
    private String name;
    private Calendar birthday;

    public User(String name, Calendar birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return birthday.getTime().getYear();
    }

    public int getMonth() {
        return birthday.getTime().getMonth();
    }

    public int getDay() {
        return birthday.getTime().getDay();
    }

    @Override
    public int hashCode() {
        return birthday.getTime().getYear() * 1000 + birthday.getTime().getMonth() * 100 + birthday.getTime().getDate() * 10 + name.length();
    }

    @Override
    public boolean equals(Object obj) {
        User user = (User) obj;
        return name.equals(user.getName()) && getYear() == user.getYear()
                && getMonth() == user.getMonth() && getDay() == getDay();
    }

}
