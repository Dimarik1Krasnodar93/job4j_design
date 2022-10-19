package ru.job4j.tdd;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@Disabled
class CinemaTest {

    @Test
    public void whenBuyThenGetTicket() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket).isEqualTo(new Ticket());
    }
    @Test
    public void whenFindThenNull() {
        Cinema cinema = new Cinema3D();
        Session session = new Session3D();
        cinema.add(session);
        List<Session> sessions = cinema.find(s -> true);
        assertThat(sessions).contains(session);
    }

    @Test
    void whenAddThenMoreSessions() {
        Cinema cinema = new Cinema3D();
        Session3D session = new Session3D();
        cinema.add(session);
        List<Session> sessions = cinema.find(s -> s == session);
        assertThat(sessions.size()).isEqualTo(1);
        assertThat(sessions.get(0)).isEqualTo(session);
    }
}