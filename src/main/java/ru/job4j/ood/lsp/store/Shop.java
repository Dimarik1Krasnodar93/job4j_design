package ru.job4j.ood.lsp.store;

import ru.job4j.ood.lsp.model.Food;
import ru.job4j.ood.lsp.store.AbstractStore;

import java.util.function.Predicate;

public class Shop extends AbstractStore {

    @Override
    public boolean add(Food food) {
        boolean isAdded  = super.add(food);
        double percentExpiry = QualityStatic.getPercentExpiry(food.getCreateDate(), food.getExpiryDate());
        if (isAdded) {
            Predicate<Food> predicateShopDiscount = i -> percentExpiry > 75 && percentExpiry < 100;
            if (predicateShopDiscount.test(food)) {
                food.setDiscount();
            }
        }
        return isAdded;
    }
    protected boolean isNotExpired(Food food) {
        double percentExpiry = QualityStatic.getPercentExpiry(food.getCreateDate(), food.getExpiryDate());
        Predicate<Food> predicateShop = i -> percentExpiry >= 25 && percentExpiry <= 75;
        return predicateShop.test(food);
    }
}
