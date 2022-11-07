package ru.job4j.ood.lsp.store;

import ru.job4j.ood.lsp.model.Food;

import java.util.function.Predicate;

public class Shop extends AbstractStore {

    public final static int PERCENT_TO_DISCOUNT = 100;
    public final static int PERCENT_FROM_DISCOUNT = 75;
    public final static int PERCENT_TO = 75;
    public final static int PERCENT_FROM = 25;

    @Override
    public boolean add(Food food) {
        boolean isAdded = false;
        if (isNotExpired(food)) {
            isAdded = super.add(food);
            double percentExpiry = Quality.getPercentExpiry(food.getCreateDate(), food.getExpiryDate());
            if (isAdded) {
                Predicate<Food> predicateShopDiscount = i -> percentExpiry > PERCENT_FROM_DISCOUNT && percentExpiry < PERCENT_TO_DISCOUNT;
                if (predicateShopDiscount.test(food)) {
                    setDiscount(food);
                }
            }
        }
        return isAdded;
    }

    protected boolean isNotExpired(Food food) {
        double percentExpiry = Quality.getPercentExpiry(food.getCreateDate(), food.getExpiryDate());
        Predicate<Food> predicateShop = i -> percentExpiry >= PERCENT_FROM && percentExpiry <= PERCENT_TO;
        return predicateShop.test(food);
    }
}
