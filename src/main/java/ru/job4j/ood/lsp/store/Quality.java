package ru.job4j.ood.lsp.store;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Quality {
    public static double getPercentExpiry(LocalDateTime createDate, LocalDateTime expiryDate) {
        return  100 * (System.currentTimeMillis() - Timestamp.valueOf(expiryDate).getTime())
                / (Timestamp.valueOf(expiryDate).getTime() - Timestamp.valueOf(createDate).getTime());
    }
}
