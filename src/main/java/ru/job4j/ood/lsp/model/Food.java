package ru.job4j.ood.lsp.model;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class Food {
    protected String name;
    protected LocalDateTime expiryDate;
    protected LocalDateTime createDate;
    protected double price;
    protected double discount;

    public Food() {

    }

    public Food(String name, LocalDateTime expiryDate, LocalDateTime createDate, double price, double discount) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public double getprice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

}
