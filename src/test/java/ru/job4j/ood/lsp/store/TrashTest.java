package ru.job4j.ood.lsp.store;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.model.Bread;
import ru.job4j.ood.lsp.model.Food;
import ru.job4j.ood.lsp.model.Meat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class TrashTest {

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
        Trash trash = new Trash();
        trash.add(food1);
        trash.add(food2);
        trash.add(food3);
        trash.add(food4);
        trash.add(food5);
        trash.add(food6);
        trash.add(food7);
        List<Food> goodsTrash = new ArrayList<>();
        goodsTrash.add(food3);
        assertThat(goodsTrash.equals(trash.getList()));
    }
}