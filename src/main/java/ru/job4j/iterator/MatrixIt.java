package ru.job4j.iterator;

import javax.swing.text.html.Option;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Optional;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = -1;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        int tempColumn = column;
        for (int i = row; i < data.length; i++) {
            for (int j = tempColumn + 1; j < data[i].length; j++) {
                return true;
            }
            tempColumn = -1;
        }
        return false;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        boolean resultFound = false;
        for (int i = row; i < data.length; i++) {
            for (int j = column + 1; j < data[i].length; j++) {
                row = i;
                column = j;
                resultFound = true;
                break;
            }
            if (resultFound) {
                break;
            }
            column = -1;
        }
        Optional optPointer = Optional.of(data[row][column]);
        if (optPointer.isPresent()) {
            return data[row][column];
        } else {
            return next();
        }
    }
}