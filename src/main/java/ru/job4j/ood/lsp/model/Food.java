package ru.job4j.ood.lsp.model;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class Food {
    protected String name;
    protected LocalDateTime expiryDate;
    protected LocalDateTime createDate;
    protected float price;

    public Food() {

    }

    public Food(String name, LocalDateTime expiryDate, LocalDateTime createDate, float price) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.createDate = createDate;
        this.price = price;
    }

    public float getprice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

}
