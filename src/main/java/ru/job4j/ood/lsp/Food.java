package ru.job4j.ood.lsp;

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

    public double getPercentExpiry() {
        double dNumerator = Timestamp.valueOf(expiryDate).getTime() - System.currentTimeMillis();
        double dDenominator = (Timestamp.valueOf(expiryDate).getTime() - Timestamp.valueOf(createDate).getTime());
        double dResult = 100 - 100 * dNumerator / dDenominator;
        return 100 - 100 * (Timestamp.valueOf(expiryDate).getTime() - System.currentTimeMillis())
                / (Timestamp.valueOf(expiryDate).getTime() - Timestamp.valueOf(createDate).getTime());
    }

    public void setDiscount() {
        price *= (100 - discount)  * 0.01;
    }
}
