package ru.job4j.ood.lsp.model;

import ru.job4j.ood.lsp.model.Food;

import java.time.LocalDateTime;

public class Meat extends Food {
    public Meat() {

    }

    public Meat(String name, LocalDateTime expiryDate, LocalDateTime createDate, float price) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.createDate = createDate;
        this.price = price;
    }
}
