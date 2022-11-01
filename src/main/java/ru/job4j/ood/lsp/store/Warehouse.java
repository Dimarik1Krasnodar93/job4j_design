package ru.job4j.ood.lsp.store;

import ru.job4j.ood.lsp.model.Food;
import ru.job4j.ood.lsp.store.AbstractStore;

import java.util.function.Predicate;

public class Warehouse extends AbstractStore {
    protected boolean isNotExpired(Food food) {
        double percentExpiry = QualityStatic.getPercentExpiry(food.getCreateDate(), food.getExpiryDate());
        Predicate<Food> predicateShop = i -> percentExpiry >= 25 && percentExpiry <= 75;
        return predicateShop.test(food);
    }
}
