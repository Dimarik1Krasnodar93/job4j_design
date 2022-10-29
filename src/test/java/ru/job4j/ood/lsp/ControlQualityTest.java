package ru.job4j.ood.lsp;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.*;

class ControlQualityTest {

    @Test
    void testMain() {

        ControlQuality controlQuality = new ControlQuality();
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
        controlQuality.add(food1);
        controlQuality.add(food2);
        controlQuality.add(food3);
        controlQuality.add(food4);
        controlQuality.add(food5);
        controlQuality.add(food6);
        controlQuality.add(food7);
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