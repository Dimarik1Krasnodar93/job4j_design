package ru.job4j.ood.lsp;

import java.util.List;

public interface Store {
    boolean addToStore(Food food);
    List<Food> getList();
}