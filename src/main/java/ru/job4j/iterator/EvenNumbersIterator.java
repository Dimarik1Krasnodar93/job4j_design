package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Optional;

public class EvenNumbersIterator implements Iterator<Integer> {

    private int[] data;
    private int index = -1;
    private int indexHasNext = -1;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        boolean rsl = false;
        for (int i = indexHasNext + 1; i < data.length; i++) {
            if (data[i] % 2 == 0) {
                rsl = true;
                indexHasNext = i;
                break;
            }
        }
        return rsl;
    }

    @Override
    public Integer next() {
        indexHasNext = index;
        if (!hasNext()) {
            throw new NoSuchElementException();
        } else {
            for (int i = index + 1; i < data.length; i++) {
                if (data[i] % 2 == 0) {
                    index = i;
                    Optional optPointer = Optional.of(data[index]);
                    if (optPointer.isPresent()) {
                        index = i;
                        indexHasNext = i;
                        return data[index];
                    } else {
                        return next();
                    }
                }
            }
        }
        throw new NoSuchElementException();
    }
}
