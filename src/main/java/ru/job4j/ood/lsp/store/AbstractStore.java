package ru.job4j.ood.lsp.store;

import ru.job4j.ood.lsp.model.Food;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore implements Store {
    private final List<Food> goods = new ArrayList<>();
    public static final int DISCOUNT = 15;

    @Override
    public List<Food> getList() {
        return new ArrayList<>(goods);
    }

    @Override
    public boolean add(Food food) {
        return isNotExpired(food) ? goods.add(food) : false;
    }

    @Override
    public void setDiscount(Food food) {
        float price = food.getprice();
        food.setPrice((100 - DISCOUNT) * price / 100);
    }
    protected abstract boolean isNotExpired(Food food);

}
