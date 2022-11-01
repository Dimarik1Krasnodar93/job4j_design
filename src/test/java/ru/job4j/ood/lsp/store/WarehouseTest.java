package ru.job4j.ood.lsp.store;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.ControlQuality;
import ru.job4j.ood.lsp.model.Bread;
import ru.job4j.ood.lsp.model.Food;
import ru.job4j.ood.lsp.model.Meat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class WarehouseTest {

    @Test
    void add() {
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
        Warehouse warehouse = new Warehouse();
        warehouse.add(food1);
        warehouse.add(food2);
        warehouse.add(food3);
        warehouse.add(food4);
        warehouse.add(food5);
        warehouse.add(food6);
        warehouse.add(food7);
        List<Food> goodsWarehouse = new ArrayList<>();
        goodsWarehouse.add(food1);
        goodsWarehouse.add(food2);
        assertThat(goodsWarehouse.equals(warehouse.getList()));
    }
}