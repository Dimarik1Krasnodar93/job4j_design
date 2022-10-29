package ru.job4j.ood.lsp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class AbstractStore implements Store {
    protected final List<Food> goods = new ArrayList<>();

    public AbstractStore() {

    }

    @Override
    public List<Food> getList() {
        return new ArrayList<>(goods);
    }

    @Override
    public boolean add(Food food) {
        return isExpired(food) ? false : goods.add(food);
    }

    protected abstract boolean isExpired(Food food);

}
