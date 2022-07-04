package ru.job4j.collection;

import org.w3c.dom.Node;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements LinkedList<E> {
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }

        private E getItem() {
            return item;
        }

        private Node<E> getNext() {
            return next;
        }

        private void setNext(Node<E> value) {
            next = value;
        }
    }

    transient int size = 0;
    transient Node<E> first = new Node<>(null, null, null);
    transient Node<E> last = new Node<>(null, null, null);


    @Override
    public void add(E value) {
        Node temp = new Node<>(last, value, null);
        last.setNext(temp);
        last = new Node<>(last, value, null);
        size++;
        if (size == 1) {
            first = last;
        }
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> temp = first;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        return temp.getItem();
    }

    @Override
    public Iterator<E> iterator() {

        return new Iterator<E>() {
            SimpleLinkedList.Node<E> forIterator;
            @Override
            public boolean hasNext() {
                if (forIterator == null) {
                    return first.getItem() != null;
                }
                return forIterator.next != null;
            }

            @Override
            public E next() {
                E rsl;
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (forIterator == null) {
                    forIterator = first;
                } else {
                    forIterator = forIterator.next;
                }
                return forIterator.getItem();
            }
        };
    }
}