package ru.job4j.ood.lsp;

import java.util.function.Predicate;

public class Shop extends AbstractStore {

    @Override
    public boolean add(Food food) {
        boolean result = isExpired(food);
        if (result) {
            Predicate<Food> predicateShopDiscount = i -> i.getPercentExpiry() > 75 && i.getPercentExpiry() < 100;
            if (predicateShopDiscount.test(food)) {
                food.setDiscount();
            }
            goods.add(food);
            result = true;
        }
        return result;
    }
    protected boolean isExpired(Food food) {
        Predicate<Food> predicateShop = i -> i.getPercentExpiry() >= 25 && i.getPercentExpiry() <= 75;
        return predicateShop.test(food);
    }
}
