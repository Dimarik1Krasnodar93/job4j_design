package ru.job4j.ood.lsp.model;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class Food {
    protected String name;



    protected LocalDateTime expiryDate;
    protected LocalDateTime createDate;
    protected float price;
    protected float discount;

    public Food() {

    }

    public Food(String name, LocalDateTime expiryDate, LocalDateTime createDate, float price, float discount) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = discount;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setDiscount() {
        price *= (100 - discount)  * 0.01;
    }
}
