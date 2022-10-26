package ru.job4j.ood.lsp;

import java.time.LocalDateTime;

public class Bread extends Food {
    public Bread() {

    }
    public Bread(String name, LocalDateTime expiryDate, LocalDateTime createDate, float price, float discount) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = discount;
    }
}
