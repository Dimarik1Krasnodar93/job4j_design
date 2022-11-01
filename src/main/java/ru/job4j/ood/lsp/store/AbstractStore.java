package ru.job4j.ood.lsp.store;

import ru.job4j.ood.lsp.model.Food;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore implements Store {
    private final List<Food> goods = new ArrayList<>();

    public AbstractStore() {

    }

    @Override
    public List<Food> getList() {
        return new ArrayList<>(goods);
    }

    @Override
    public boolean add(Food food) {
        return isNotExpired(food) ? goods.add(food) : false;
    }

    protected abstract boolean isNotExpired(Food food);

}
