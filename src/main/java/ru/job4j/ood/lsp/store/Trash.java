package ru.job4j.ood.lsp.store;

import ru.job4j.ood.lsp.model.Food;

import java.util.function.Predicate;

public class Trash extends AbstractStore {

    protected boolean isNotExpired(Food food) {
        double percentExpiry = Quality.getPercentExpiry(food.getCreateDate(), food.getExpiryDate());
        Predicate<Food> predicateShop = i -> percentExpiry < 0;
        return predicateShop.test(food);
    }
}
