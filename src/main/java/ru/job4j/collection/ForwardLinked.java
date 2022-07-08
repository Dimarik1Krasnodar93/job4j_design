package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;

    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    public void addFirst(T value) {
        if (head == null) {
            add(value);
        } else {
            head = new Node<>(value, head);
        }
    }

    public T deleteFirst() {
        T rsl;
        if (head == null) {
            throw new NoSuchElementException();
        }
        rsl = head.value;
        Node<T> next = head.next;
        head.value = null;
        head.next = null;
        head = next;
        return rsl;
    }

    public boolean revert() {
        if (head == null || head.next == null) {
            return false;
        }
        SimpleQueue<T> queue = new SimpleQueue();
        Iterator<T> iterator = iterator();
        int i = 0;
        while (iterator.hasNext()) {
            queue.push(iterator.next());
            i++;
        }
        if (head != null) {
            while (head.next != null) {
                head = head.next;
            }
            head = null;
        }
        for (int j = 0; j < i; j++) {
            addFirst(queue.poll());
        }
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }

            public void remove() {
                if (head == node) {
                    head = null;
                }
                node.next = null;
                node = null;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
