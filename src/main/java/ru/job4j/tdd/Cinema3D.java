package ru.job4j.tdd;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
        if (row < 0 || column < 0
                || date.getTime().getTime() < System.currentTimeMillis()) {
            throw new IllegalArgumentException();
        }
        return new Ticket();
    }

    @Override
    public void add(Session session) {
        return;
    }
}
