package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Optional;

public class EvenNumbersIterator implements Iterator<Integer> {

    private int[] data;
    private int index = -1;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return nextDiv2Index() == -1 ? false : true;
    }

    private int nextDiv2Index() {
        int rsl = -1;
        for (int i = index + 1; i < data.length; i++) {
            if (data[i] % 2 == 0) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            index = nextDiv2Index();
            Optional optPointer = Optional.of(data[index]);
            if (optPointer.isPresent()) {
                return data[index];
            } else {
                return next();
            }

        } else {
            throw new NoSuchElementException();
        }
    }
}
