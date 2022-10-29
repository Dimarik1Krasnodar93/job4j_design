package ru.job4j.ood.lsp;

import java.util.function.Predicate;

public class Warehouse extends AbstractStore {
    protected boolean isExpired(Food food) {
        Predicate<Food> predicateShop = i -> i.getPercentExpiry() >= 25 && i.getPercentExpiry() <= 75;
        return predicateShop.test(food);
    }
}
