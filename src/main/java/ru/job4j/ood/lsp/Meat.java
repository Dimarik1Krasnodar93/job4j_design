package ru.job4j.ood.lsp;

import java.time.LocalDateTime;

public class Meat extends Food {
    public Meat() {

    }

    public Meat(String name, LocalDateTime expiryDate, LocalDateTime createDate, float price, float discount) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = discount;
    }
}