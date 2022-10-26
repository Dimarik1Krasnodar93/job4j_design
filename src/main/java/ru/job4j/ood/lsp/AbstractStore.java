package ru.job4j.ood.lsp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class AbstractStore implements Store {
    protected List<Food> goods = new ArrayList<>();

    public AbstractStore() {

    }

    @Override
    public List<Food> getList() {
        return goods;
    }

    @Override
    public boolean addToStore(Food food) {
        boolean result = false;
        goods.add(food);
        result = true;
        return result;
    }


}
