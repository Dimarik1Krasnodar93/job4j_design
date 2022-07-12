package ru.job4j.iterator;

import static org.hamcrest.Matchers.is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.assertThat;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(input, is(Arrays.asList(1, 2, 3)));
    }

    @Test
    public void whenAddBeforeNull() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, null);
        assertThat(input, is(Arrays.asList(1, null, 3)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 2, 3);
        assertThat(input, is(Arrays.asList(0, 1, 2, 3)));
    }

    @Test
    public void whenAddAfterLastNull() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 2, null);
        assertThat(input, is(Arrays.asList(0, 1, 2, null)));
    }

    @Test
    public void whenAddAfterLastThree() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3));
        ListUtils.addAfter(input, 2, 4);
        assertThat(input, is(Arrays.asList(0, 1, 2, 4, 3)));
    }

    @Test
    public void removeIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3));
        Predicate<Integer> pred = x -> x % 2 == 0 && x != 0;
        ListUtils.removeIf(input, pred);
        assertThat(input, is(Arrays.asList(0, 1, 3)));
    }

    @Test
    public void replaceIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3));
        Predicate<Integer> pred = x -> x % 2 == 0 && x != 0;
        ListUtils.replaceIf(input, pred, 9);
        assertThat(input, is(Arrays.asList(0, 1, 9, 3)));
    }

    @Test
    public void removeAll() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3));
        List<Integer> elements = new ArrayList<>(Arrays.asList(0, 1));
        ListUtils.removeAll(input, elements);
        assertThat(input, is(Arrays.asList(2, 3)));
    }
}
