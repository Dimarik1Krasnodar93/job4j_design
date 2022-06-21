package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Optional;

public class EvenNumbersIterator implements Iterator<Integer> {

    private int[] data;
    private int index = 0;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        boolean rsl = false;
        for (int i = index; i < data.length; i++) {
            if (data[i] % 2 == 0) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        } else {
            for (int i = index; i < data.length; i++) {
                if (data[i] % 2 == 0) {
                    index = i;
                    Optional optPointer = Optional.of(data[index]);
                    if (optPointer.isPresent()) {
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
