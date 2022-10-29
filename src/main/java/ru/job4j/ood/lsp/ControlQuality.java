package ru.job4j.ood.lsp;

import java.time.LocalDateTime;
import java.util.function.Predicate;

public class ControlQuality {
    private Store shop = new Shop();
    private Store trash = new Trash();
    private Store warehouse = new Warehouse();


    public Store getShop() {
        return shop;
    }

    public Store getTrash() {
        return trash;
    }

    public Store getWarehouse() {
        return warehouse;
    }

    public ControlQuality() {
    }
    public void add(Food food) {
        shop.add(food);
        warehouse.add(food);
        trash.add(food);
    }

    public static void main(String[] args) {
        ControlQuality controlQuality = new ControlQuality();
        Food food1 = new Bread("Bread1", LocalDateTime.of(2025, 12, 21, 0, 0),
                LocalDateTime.of(2022, 10, 21, 0, 0),  50, 5);
        Food food2 = new Bread("Bread2", LocalDateTime.of(2022, 11, 21, 0, 0),
                LocalDateTime.of(2022, 10, 24, 0, 0),  50, 5);
        Food food3 = new Meat("Meat", LocalDateTime.of(2022, 9, 21, 0, 0),
                LocalDateTime.of(2022, 8, 21, 0, 0),  50, 5);
        Food food4 = new Meat("Meat", LocalDateTime.of(2022, 12, 21, 0, 0),
                LocalDateTime.of(2022, 9, 21, 0, 0),  50, 5);
        Food food5 = new Meat("Meat", LocalDateTime.of(2022, 12, 21, 0, 0),
                LocalDateTime.of(2022, 1, 21, 0, 0),  50, 5);
        Food food65 = new Meat("Meat", LocalDateTime.of(2022, 12, 21, 0, 0),
                LocalDateTime.of(2022, 3, 21, 0, 0),  50, 5);
        Food food6 = new Meat("Meat", LocalDateTime.of(2022, 12, 21, 0, 0),
                LocalDateTime.of(2022, 9, 21, 0, 0),  50, 5);
        controlQuality.add(food1);
        controlQuality.add(food2);
        controlQuality.add(food3);
        controlQuality.add(food4);
        controlQuality.add(food5);
        controlQuality.add(food6);
    }


}
