package ru.job4j.generic;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import org.hamcrest.MatcherAssert.*;
import org.hamcrest.core.Is.*;
import org.junit.Test;

public class RoleStoreTest {
    @Test
    public void whenAddAndFindThenUsernameIsPetr() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Petr"));
        Role result = store.findById("1");
        assertThat(result.getUsername(), is("Petr"));
    }

}