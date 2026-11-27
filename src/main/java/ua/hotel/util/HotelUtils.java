
package ua.hotel.util;

import ua.hotel.model.Booking;

import java.time.temporal.ChronoUnit;

public final class HotelUtils {

    private HotelUtils() {
    }

    public static long nights(Booking booking) {
        if (booking == null) {
            throw new IllegalArgumentException(
                    "Booking must not be null. Actual: null");
        }

        return ChronoUnit.DAYS.between(
                booking.getCheckInDate(),
                booking.getCheckOutDate()
        );
    }

    public static double totalPrice(Booking booking) {
        if (booking == null) {
            throw new IllegalArgumentException(
                    "Booking must not be null. Actual: null");
        }

        return nights(booking) * booking.getRoom().getPricePerNight();
    }
}
