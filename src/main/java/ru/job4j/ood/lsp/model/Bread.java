package ru.job4j.ood.lsp.model;

import ru.job4j.ood.lsp.model.Food;

import java.time.LocalDateTime;

public class Bread extends Food {
    public Bread() {

    }
    public Bread(String name, LocalDateTime expiryDate, LocalDateTime createDate, float price) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.createDate = createDate;
        this.price = price;
    }
}
