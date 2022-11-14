package ru.job4j.ood.lsp.store;

import ru.job4j.ood.lsp.model.Food;

import java.util.function.Predicate;

public class Shop extends AbstractStore {

    public final static int PERCENT_TO_SHOP = 75;
    private final static Predicate<Double> PREDICATE_SHOP = p -> p > Warehouse.PERCENT_TO_WAREHOUSE && p <= Trash.PERCENT_TO_TRASH;
    private final static Predicate<Double> PREDICATE_CONDITION = p -> p >= PERCENT_TO_SHOP;
    @Override
    public boolean add(Food food) {
        boolean isAdded = false;
        if (isNotExpired(food)) {
            isAdded = super.add(food);
            if (isAdded) {
                if (PREDICATE_CONDITION.test(food.getprice())) {
                    setDiscount(food);
                }
            }
        }
        return isAdded;
    }

    protected boolean isNotExpired(Food food) {
        return PREDICATE_SHOP.test(Quality.getPercentExpiry(food.getCreateDate(), food.getExpiryDate()));
    }

    private void setDiscount(Food food) {
        double price = food.getprice();
        food.setPrice((100 - food.getDiscount()) * price / 100);
    }
}
