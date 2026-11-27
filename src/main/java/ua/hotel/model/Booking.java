
package ua.hotel.model;

import java.time.LocalDate;

public record Booking(
        String bookingId,
        Guest guest,
        Room room,
        LocalDate checkInDate,
        LocalDate checkOutDate,
        BookingStatus status
) {
    public Booking {
        if (bookingId == null || bookingId.trim().isEmpty()) {
            throw new IllegalArgumentException("Booking ID must not be empty");
        }
        if (guest == null) {
            throw new IllegalArgumentException("Guest must not be null");
        }
        if (room == null) {
            throw new IllegalArgumentException("Room must not be null");
        }
        if (checkInDate == null || checkOutDate == null) {
            throw new IllegalArgumentException("Booking dates must not be null");
        }
        if (!checkOutDate.isAfter(checkInDate)) {
            throw new IllegalArgumentException("Check-out date must be after check-in date");
        }
        if (status == null) {
            throw new IllegalArgumentException("Booking status must not be null");
        }

        bookingId = bookingId.trim();
    }

    // Залишаємо сумісність із незмінним пакетом util
    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public Room getRoom() {
        return room;
    }
}
