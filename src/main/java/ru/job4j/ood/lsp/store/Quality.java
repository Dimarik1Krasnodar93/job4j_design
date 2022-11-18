package ru.job4j.ood.lsp.store;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import static java.time.temporal.ChronoUnit.DAYS;

public class Quality {
    public static double getPercentExpiry(LocalDateTime createDate, LocalDateTime expiryDate) {
        return (DAYS.between(expiryDate, LocalDateTime.now()) * 100.00)
                / DAYS.between(expiryDate, createDate);
    }
}
