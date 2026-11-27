
package ua.hotel.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

final class FormatHelper {
    private static final DateTimeFormatter DATE_FORMAT =
            DateTimeFormatter.ofPattern("dd.MM.yyyy");

    private FormatHelper() {
    }

    static String normalize(String value) {
        ValidationHelper.requireNotBlank(value, "Value");
        return value.trim().toLowerCase(Locale.ROOT);
    }

    static String capitalize(String value) {
        ValidationHelper.requireNotBlank(value, "Value");
        String normalized = value.trim().toLowerCase(Locale.ROOT);
        return normalized.substring(0, 1).toUpperCase(Locale.ROOT)
                + normalized.substring(1);
    }

    static String formatMoney(double amount) {
        ValidationHelper.requirePositive(amount, "Amount");
        return String.format(Locale.US, "%.2f", amount);
    }

    static String formatDate(LocalDate date) {
        ValidationHelper.requireNotNull(date, "Date");
        return date.format(DATE_FORMAT);
    }
}
