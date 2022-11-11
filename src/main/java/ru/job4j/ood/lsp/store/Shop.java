package ru.job4j.ood.lsp.store;

import ru.job4j.ood.lsp.model.Food;

import java.util.function.Predicate;

public class Shop extends AbstractStore {

    public final static int PERCENT_TO_DISCOUNT = 100;
    public final static int PERCENT_FROM_DISCOUNT = 75;
    public final static int PERCENT_TO = 75;
    public final static int PERCENT_FROM = 25;
    public final static int DISCOUNT = 5;
    private final static Predicate<Double> DISCOUNT_CONDITION = p -> p >= PERCENT_FROM && p <= PERCENT_TO;
    @Override
    public boolean add(Food food) {
        boolean isAdded = false;
        if (isNotExpired(food)) {
            isAdded = super.add(food);
            if (isAdded) {
                if (DISCOUNT_CONDITION.test(food.getprice())) {
                    setDiscount(food);
                }
            }
        }
        return isAdded;
    }

    protected boolean isNotExpired(Food food) {
        return DISCOUNT_CONDITION.test(Quality.getPercentExpiry(food.getCreateDate(), food.getExpiryDate()));
    }

    public void setDiscount(Food food) {
        double price = food.getprice();
        food.setPrice((100 - DISCOUNT) * price / 100);
    }
}
