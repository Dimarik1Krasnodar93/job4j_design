package ru.job4j.ood.lsp.store;

import ru.job4j.ood.lsp.model.Food;

import java.util.function.Predicate;

public class Warehouse extends AbstractStore {
    public static final int FROM_PERCENT = 25;
    public static final int TO_PERCENT = 75;
    protected boolean isNotExpired(Food food) {
        double percentExpiry = Quality.getPercentExpiry(food.getCreateDate(), food.getExpiryDate());
        Predicate<Food> predicateShop = i -> percentExpiry >= FROM_PERCENT && percentExpiry <= TO_PERCENT;
        return predicateShop.test(food);
    }
}
