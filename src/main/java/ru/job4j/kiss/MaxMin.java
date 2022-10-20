package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        BinaryOperator<T> binaryOperator =  BinaryOperator.maxBy(comparator);
        return findMinMax(value, binaryOperator);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        BinaryOperator<T> binaryOperator = BinaryOperator.minBy(comparator);
        return findMinMax(value, binaryOperator);
    }

    private <T> T findMinMax(List<T> value, BinaryOperator<T> bin) {
        if (value.isEmpty()) {
            throw new IllegalArgumentException();
        }
        T result = value.get(0);
        for (T temp : value) {
            result = bin.apply(result, temp);
        }
        return result;
    }

}
