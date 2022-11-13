package ru.job4j.ood.lsp.store;

import ru.job4j.ood.lsp.model.Food;

import java.util.function.Predicate;

public class Warehouse extends AbstractStore {

    public static final int TERM_TO_PERCENT = 25;
    public static final Predicate<Double> PREDICATE_WAREHOUSE = i -> i <= TERM_TO_PERCENT;
    protected boolean isNotExpired(Food food) {
        double percentExpiry = Quality.getPercentExpiry(food.getCreateDate(), food.getExpiryDate());
        return PREDICATE_WAREHOUSE.test(percentExpiry);
    }
}
