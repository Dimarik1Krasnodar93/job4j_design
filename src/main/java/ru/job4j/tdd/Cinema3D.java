package ru.job4j.tdd;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public class Cinema3D implements Cinema {
    @Override
    public List<Session> find(Predicate<Session> filter) {
        List<Session> listsession = new ArrayList<>();
        return listsession;
    }

    @Override
    public Ticket buy(Account account, int row, int column, Calendar date) {
        return new Ticket();
    }

    @Override
    public void add(Session session) {
        return;
    }
}
