package ru.job4j.collection;

import java.util.*;

public class SimpleArrayList<T> implements SimpleList<T> {

    private T[] container;

    private int size = 0;

    private int modCount = 0;

    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

    @Override
    public void add(T value) {
        size++;
        modCount++;
        if (size > container.length) {
            container = Arrays.copyOf(container, size * 2);
            container[size - 1] = value;
        }
        container[size - 1] = value;
    }

    @Override
    public T set(int index, T newValue) {
        T rsl = container[index];
        container[index] = newValue;
        modCount++;
        return rsl;
    }

    @Override
    public T remove(int index) {
        T rsl = container[index];
        modCount++;
        System.arraycopy(container, index + 1, container, index, size - index - 1);
        size--;
        return rsl;
    }

    @Override
    public T get(int index) {
        return container[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {
            int iPointer = 0;
            int expectedModCount = modCount;
            @Override
            public boolean hasNext() {
                return container.length > iPointer && container[iPointer] != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                } else {
                    if (modCount != expectedModCount) {
                        throw new ConcurrentModificationException();
                    } else {
                        return container[iPointer++];
                    }
                }
            }
        };
    }
}