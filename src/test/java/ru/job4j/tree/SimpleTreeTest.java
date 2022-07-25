package ru.job4j.tree;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertThrows;
import static org.hamcrest.Matchers.is;


import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleTreeTest {

    @Test
    void when6ElFindLastThen6() {
        Tree<Integer> tree = new SimpleTree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(tree.findBy(6)).isPresent();
    }

    @Test
    void testIsBinary() {
        Tree<Integer> tree = new SimpleTree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        assertThat(tree.isBinary()).isTrue();
    }

    @Test
    void testNoBinary() {
        Tree<Integer> tree = new SimpleTree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        assertThat(tree.isBinary()).isFalse();
    }

    @Test
    void when6ElFindLastThen6Null() {
        Tree<Integer> tree = new SimpleTree<>(2);
        NoSuchElementException thrown = Assertions.assertThrows(NoSuchElementException.class, () -> {
            tree.add(1, 2);
        });
    }


    @Test
    void whenElFindNotExistThenOptionEmpty() {
        Tree<Integer> tree = new SimpleTree<>(1);
        tree.add(1, 2);
        assertThat(tree.findBy(7)).isEmpty();
    }

    @Test
    void whenChildExistOnLeafThenNotAdd() {
        Tree<Integer> tree = new SimpleTree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(tree.add(2, 6)).isFalse();
    }
}
