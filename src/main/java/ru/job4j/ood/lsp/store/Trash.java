package ru.job4j.ood.lsp.store;

import ru.job4j.ood.lsp.model.Food;

import java.util.function.Predicate;

public class Trash extends AbstractStore {

    public static final int PERCENT_TO_TRASH = 100;
    public static final Predicate<Double> PREDICATE_TRASH = i -> i > PERCENT_TO_TRASH;

    protected boolean isNotExpired(Food food) {
        double percentExpiry = Quality.getPercentExpiry(food.getCreateDate(), food.getExpiryDate());
        return PREDICATE_TRASH.test(percentExpiry);
    }
}
