package ua.hotel.model;

import java.time.LocalDate;

public record HotelPayment(
        String paymentId,
        Booking booking,
        double amount,
        LocalDate paymentDate
) {
    public HotelPayment {
        if (paymentId == null || paymentId.isBlank())
            throw new IllegalArgumentException("Payment ID must not be empty");
        if (booking == null)
            throw new IllegalArgumentException("Booking must not be null");
        if (!Double.isFinite(amount) || amount <= 0)
            throw new IllegalArgumentException("Payment amount must be positive");
        if (paymentDate == null)
            throw new IllegalArgumentException("Payment date must not be null");
        if (paymentDate.isBefore(booking.checkInDate()))
            throw new IllegalArgumentException("Payment date must not be before check-in");

        paymentId = paymentId.trim();
    }
}
