package ru.job4j.collection;

import java.util.Iterator;

public class SimpleStack<T> {

    private ForwardLinked<T> linked = new ForwardLinked<T>();
    int count = 0;

    public T pop() {
        T rsl = null;
        Iterator<T> iterator = linked.iterator();
        for (int i = 0; i < count; i++) {
            rsl = iterator.next();
        }
        iterator = linked.iterator();
        for (int i = 0; i < count - 1; i++) {
            rsl = iterator.next();
        }
        iterator.remove();
        count--;
        return rsl;
    }

    public void push(T value) {
        linked.add(value);
        count++;
    }
}