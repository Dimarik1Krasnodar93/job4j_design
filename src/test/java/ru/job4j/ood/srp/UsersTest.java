package ru.job4j.ood.srp;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class UsersTest {

    @Test
    void getXml() {
        var usersList = new ArrayList<>(List.of(
                new User("123", "456"),
                new User("abc", "xyz"),
                new User("job4j", "junior")
        ));
        Users users = new Users(usersList);
        String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
                + "<users>\n"
                + "    <users name=\"123\" lastName=\"456\"/>\n"
                + "    <users name=\"abc\" lastName=\"xyz\"/>\n"
                + "    <users name=\"job4j\" lastName=\"junior\"/>\n"
                + "</users>\n";
        assertThat(users.getXml()).isEqualTo(expected);
    }

    @Test
    void getJson() {
        var usersList = new ArrayList<>(List.of(
                new User("123", "456"),
                new User("abc", "xyz"),
                new User("job4j", "junior")
        ));
        Users users = new Users(usersList);
        String strRes = users.getJson();

    }
}