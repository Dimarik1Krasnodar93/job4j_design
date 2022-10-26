package ru.job4j.ood.lsp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.function.Predicate;

public class ControlQuality {
    private Store shop = new Shop();
    private Store trash = new Trash();
    private Store warehouse = new Warehouse();
    Predicate<Food> predicateWarehouse;
    Predicate<Food> predicateShop;
    Predicate<Food> predicateShopDiscount;

    public Store getShop() {
        return shop;
    }

    public Store getTrash() {
        return trash;
    }

    public Store getWarehouse() {
        return warehouse;
    }

    public ControlQuality(Predicate<Food> predicateWarehouse, Predicate<Food> predicateShop, Predicate<Food> predicateShopDiscount) {
        this.predicateWarehouse = predicateWarehouse;
        this.predicateShop = predicateShop;
        this.predicateShopDiscount = predicateShopDiscount;
    }
    public void addToStore(Food food) {
        if (predicateWarehouse.test(food)) {
            warehouse.addToStore(food);
        } else if (predicateShop.test(food)) {
            shop.addToStore(food);
        } else if (predicateShopDiscount.test(food)) {
            food.setDiscount();
            shop.addToStore(food);
        } else {
            trash.addToStore(food);
        }
    }

    public static void main(String[] args) {
        Predicate<Food> predicateWarehouse = i -> i.getPercentExpiry() < 25;
        Predicate<Food> predicateShop = i -> i.getPercentExpiry() >= 25 && i.getPercentExpiry() <= 75;
        Predicate<Food> predicateShopDiscount = i -> i.getPercentExpiry() > 75 && i.getPercentExpiry() < 100;
        ControlQuality controlQuality = new ControlQuality(predicateWarehouse, predicateShop, predicateShopDiscount);
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
        controlQuality.addToStore(food1);
        controlQuality.addToStore(food2);
        controlQuality.addToStore(food3);
        controlQuality.addToStore(food4);
        controlQuality.addToStore(food5);
        controlQuality.addToStore(food6);
    }


}
