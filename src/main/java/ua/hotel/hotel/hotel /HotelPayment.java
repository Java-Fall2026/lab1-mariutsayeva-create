package ua.hotel;

import ua.common.BaseEntity;
import java.time.LocalDate;
import java.util.Objects;

public class HotelPayment extends BaseEntity {

    private final String paymentId;
    private final Booking booking;
    private final double amount;
    private final LocalDate paymentDate;

    public HotelPayment(String paymentId, Booking booking,
                        double amount, LocalDate paymentDate) {
        super();

        if (paymentId == null || paymentId.isBlank()) {
            throw new IllegalArgumentException("Payment ID cannot be empty");
        }

        if (booking == null) {
            throw new IllegalArgumentException("Booking cannot be null");
        }

        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }

        if (paymentDate == null) {
            throw new IllegalArgumentException("Payment date cannot be null");
        }

        if (paymentDate.isBefore(booking.getCheckInDate())) {
            throw new IllegalArgumentException(
                    "Payment date cannot be before check-in date");
        }

        this.paymentId = paymentId;
        this.booking = booking;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public Booking getBooking() {
        return booking;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof HotelPayment)) return false;
        HotelPayment payment = (HotelPayment) obj;
        return paymentId.equals(payment.paymentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentId);
    }
}
