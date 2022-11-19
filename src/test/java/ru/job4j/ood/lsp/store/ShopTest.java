package ru.job4j.ood.lsp.store;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.model.Bread;
import ru.job4j.ood.lsp.model.Food;
import ru.job4j.ood.lsp.model.Meat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;


class ShopTest {

    @Test
    void add() {
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
        Shop shop = new Shop();
        shop.add(food1);
        shop.add(food2);
        shop.add(food3);
        shop.add(food4);
        shop.add(food5);
        shop.add(food6);
        shop.add(food7);
        List<Food> goodsShop = new ArrayList<>();
        goodsShop.add(food4);
        goodsShop.add(food5);
        goodsShop.add(food6);
        goodsShop.add(food7);
        assertThat(goodsShop.equals(shop.getList()));
    }
}