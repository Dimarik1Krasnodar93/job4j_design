package ru.job4j.ood.lsp;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.model.Bread;
import ru.job4j.ood.lsp.model.Food;
import ru.job4j.ood.lsp.model.Meat;
import ru.job4j.ood.lsp.store.Shop;
import ru.job4j.ood.lsp.store.Store;
import ru.job4j.ood.lsp.store.Warehouse;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


class ControlQualityTest {

    @Test
    void testMain() {
        List<Store> listStore = new ArrayList<>();
        ControlQuality controlQuality = new ControlQuality(listStore);
        Food food1 = new Bread("Bread1", LocalDateTime.now().plusDays(800),
                LocalDateTime.now().minusDays(50),  50, 5);
        Food food2 = new Bread("Bread2", LocalDateTime.now().plusDays(20),
                LocalDateTime.now().minusDays(10),  50, 5);
        Food food3 = new Meat("Meat1", LocalDateTime.now().minusDays(40),
                LocalDateTime.now().minusDays(110),  50, 5);
        Food food4 = new Meat("Meat2", LocalDateTime.now().plusDays(50),
                LocalDateTime.now().minusDays(70),  50, 5);
        Food food5 = new Meat("Meat3", LocalDateTime.now().plusDays(50),
                LocalDateTime.now().minusDays(220),  50, 5);
        Food food6 = new Meat("Meat4", LocalDateTime.now().plusDays(50),
                LocalDateTime.now().minusDays(140),  50, 5);
        Food food7 = new Meat("Meat5", LocalDateTime.now().plusDays(50),
                LocalDateTime.now().minusDays(30),  50, 5);
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