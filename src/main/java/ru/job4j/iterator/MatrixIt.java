package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = -1;
    private int index = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        boolean rsl = false;
        while (movePointer()) {
            if (data[row].length > 0) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    private boolean movePointer() {
        if (column == -1) {
            column = 0;
        } else {
            if (column + 1 >= data[row].length) {
                column = 0;
                row++;
            } else {
                column++;
            }
        }
        return row < data.length && (column < data[row].length || row < data.length - 1);
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        return data[row][column];
    }
}