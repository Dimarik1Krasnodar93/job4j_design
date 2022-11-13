package ru.job4j.ood.lsp.store;

import ru.job4j.ood.lsp.model.Food;

import java.util.function.Predicate;

public class Shop extends AbstractStore {

    public final static int TERM_PERCENT_TO = 75;
    private final static Predicate<Double> PREDICATE_SHOP = p -> p >= Warehouse.TERM_TO_PERCENT && p <= TERM_PERCENT_TO;
    private final static Predicate<Double> PREDICATE_CONDITION = p -> p >= TERM_PERCENT_TO;
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
