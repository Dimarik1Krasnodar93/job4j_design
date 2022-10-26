package ru.job4j.ood.lsp;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class ControlQualityTest {

    @Test
    void testMain() {
        Predicate<Food> predicateWarehouse = i -> i.getPercentExpiry() < 25;
        Predicate<Food> predicateShop = i -> i.getPercentExpiry() >= 25 && i.getPercentExpiry() <= 75;
        Predicate<Food> predicateShopDiscount = i -> i.getPercentExpiry() > 75 && i.getPercentExpiry() < 100;
        ControlQuality controlQuality = new ControlQuality(predicateWarehouse, predicateShop, predicateShopDiscount);
        Food food1 = new Bread("Bread1", LocalDateTime.of(2025, 12, 21, 0, 0),
                LocalDateTime.of(2022, 10, 21, 0, 0),  50, 5);
        Food food2 = new Bread("Bread2", LocalDateTime.of(2022, 11, 21, 0, 0),
                LocalDateTime.of(2022, 10, 24, 0, 0),  50, 5);
        Food food3 = new Meat("Meat1", LocalDateTime.of(2022, 9, 21, 0, 0),
                LocalDateTime.of(2022, 8, 21, 0, 0),  50, 5);
        Food food4 = new Meat("Meat2", LocalDateTime.of(2022, 12, 21, 0, 0),
                LocalDateTime.of(2022, 9, 21, 0, 0),  50, 5);
        Food food5 = new Meat("Meat3", LocalDateTime.of(2022, 12, 21, 0, 0),
                LocalDateTime.of(2022, 1, 21, 0, 0),  50, 5);
        Food food6 = new Meat("Meat4", LocalDateTime.of(2022, 12, 21, 0, 0),
                LocalDateTime.of(2022, 3, 21, 0, 0),  50, 5);
        Food food7 = new Meat("Meat5", LocalDateTime.of(2022, 12, 21, 0, 0),
                LocalDateTime.of(2022, 9, 21, 0, 0),  50, 5);
        controlQuality.addToStore(food1);
        controlQuality.addToStore(food2);
        controlQuality.addToStore(food3);
        controlQuality.addToStore(food4);
        controlQuality.addToStore(food5);
        controlQuality.addToStore(food6);
        controlQuality.addToStore(food7);
        List<Food> goodsShop = new ArrayList<>();
        List<Food> goodsTrash = new ArrayList<>();
        List<Food> goodsWarehouse = new ArrayList<>();
        goodsWarehouse.add(food1);
        goodsWarehouse.add(food2);
        goodsShop.add(food4);
        goodsShop.add(food5);
        goodsShop.add(food6);
        goodsShop.add(food7);
        goodsTrash.add(food3);
        assertThat(goodsShop.equals(controlQuality.getShop().getList()));
        assertThat(goodsWarehouse.equals(controlQuality.getWarehouse().getList()));
        assertThat(goodsTrash.equals(controlQuality.getTrash().getList()));
    }
}