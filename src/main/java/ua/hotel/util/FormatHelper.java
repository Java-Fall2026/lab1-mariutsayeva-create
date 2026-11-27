
package ua.hotel.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

final class FormatHelper {

    private static final DateTimeFormatter DATE_FORMAT =
            DateTimeFormatter.ofPattern("dd.MM.yyyy");

    private FormatHelper() {
    }

    static String formatDate(LocalDate date) {
        ValidationHelper.requireNotNull(date, "Date");
        return date.format(DATE_FORMAT);
    }

    static String formatMoney(double amount) {
        return String.format("%.2f", amount);
    }
}
