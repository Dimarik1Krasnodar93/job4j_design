package ru.job4j.tree;

import java.util.*;
import java.util.function.Predicate;

public class SimpleTree<E> implements Tree<E> {
    private final Node<E> root;

    public SimpleTree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        if (findBy(parent).isEmpty()) {
            throw new NoSuchElementException();
        }
        boolean rsl = findBy(child).isEmpty();
        if (rsl) {
            Node<E> parentNode = findBy(parent).get();
            parentNode.children.add(new Node<>(child));
        }
        return rsl;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Predicate<Node<E>> pred = s -> s.value.equals(value);
        Optional<Node<E>> rsl = binaryFind(pred);
        return rsl;
    }

    public boolean isBinary() {
        Predicate<Node<E>> pred = s -> s.children.size() > 2;
        Optional<Node<E>> rsl = binaryFind(pred);
        return !rsl.isPresent();
    }

    private Optional<Node<E>> binaryFind(Predicate<Node<E>> pred) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (pred.test(el)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }
}