
package ua.hotel.util;

final class ValidationHelper {

    private ValidationHelper() {
    }

    static void requireNotNull(Object value, String fieldName) {
        if (value == null) {
            throw new IllegalArgumentException(
                    fieldName + " must not be null, got: null");
        }
    }

    static void requireNotBlank(String value, String fieldName) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(
                    fieldName + " must not be blank, got: " + value);
        }
    }

    static void requirePositive(double value, String fieldName) {
        if (value <= 0 || !Double.isFinite(value)) {
            throw new IllegalArgumentException(
                    fieldName + " must be greater than 0, got: " + value);
        }
    }

    static void requireInRange(int value, int min, int max, String fieldName) {
        if (value < min || value > max) {
            throw new IllegalArgumentException(
                    fieldName + " must be between " + min + " and " + max
                            + ", got: " + value);
        }
    }
}
