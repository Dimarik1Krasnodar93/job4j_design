package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

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
            return data[index];
        } else
        {
            throw new NoSuchElementException();
        }
    }
}
