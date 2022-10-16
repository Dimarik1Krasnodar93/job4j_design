package ru.job4j.kiss;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class MaxMinTest {

    @Test
    void max() {
        List<Integer> list = List.of(4, -5, 1, 2, 4, 3, 99, 5);
        int expected = 99;
        MaxMin maxmin = new MaxMin();
        assertThat(maxmin.max(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return compare(o1, o2);
            }
        })).isEqualTo(expected);
    }

    @Test
    void min() {
        List<Integer> list = List.of(4, -5, 1, 2, 4, 3, 99, 5);
        int expected = -5;
        MaxMin maxmin = new MaxMin();
        assertThat(maxmin.min(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return compare(o1, o2);
            }
        })).isEqualTo(expected);
    }
}