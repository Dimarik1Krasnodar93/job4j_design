package ru.job4j.ood.lsp;

import java.util.function.Predicate;

public class Shop extends AbstractStore {

    @Override
    public boolean add(Food food) {
        boolean isAdded  = super.add(food);
        if (isAdded) {
            Predicate<Food> predicateShopDiscount = i -> i.getPercentExpiry() > 75 && i.getPercentExpiry() < 100;
            if (predicateShopDiscount.test(food)) {
                food.setDiscount();
            }
        }
        return isAdded;
    }
    protected boolean isNotExpired(Food food) {
        Predicate<Food> predicateShop = i -> i.getPercentExpiry() >= 25 && i.getPercentExpiry() <= 75;
        return predicateShop.test(food);
    }
}
