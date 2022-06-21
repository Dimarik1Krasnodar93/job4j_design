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
       if (column + 1 < data[row].length) {
           rsl = true;
       } else {
           if (row + 1 < data.length) {
               rsl = true;
           }
       }
        return rsl;
    }

    private void movePointer() {
       if (column + 1 >= data[row].length) {
           column = 0;
           row++;
       } else {
           column++;
       }
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        movePointer();
        return data[row][column];
    }
}