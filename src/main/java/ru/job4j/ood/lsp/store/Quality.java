package ru.job4j.ood.lsp.store;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Quality {
    public static double getPercentExpiry(LocalDateTime createDate, LocalDateTime expiryDate) {
        double dNumerator = Timestamp.valueOf(expiryDate).getTime() - System.currentTimeMillis();
        double dDenominator = (Timestamp.valueOf(expiryDate).getTime() - Timestamp.valueOf(createDate).getTime());
        double dResult = 100 - 100 * dNumerator / dDenominator;
        return 100 - 100 * (Timestamp.valueOf(expiryDate).getTime() - System.currentTimeMillis())
                / (Timestamp.valueOf(expiryDate).getTime() - Timestamp.valueOf(createDate).getTime());
    }
}
