

package ua.hotel.model;

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

        if (paymentId == null || paymentId.trim().isEmpty()) {
            throw new IllegalArgumentException("Payment ID cannot be empty");
        }
        if (booking == null) {
            throw new IllegalArgumentException("Booking cannot be null");
        }
        if (amount <= 0 || !Double.isFinite(amount)) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        if (paymentDate == null) {
            throw new IllegalArgumentException("Payment date cannot be null");
        }
        if (paymentDate.isBefore(booking.getCheckInDate())) {
            throw new IllegalArgumentException(
                    "Payment date cannot be before check-in date");
        }

        this.paymentId = paymentId.trim();
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelPayment that = (HotelPayment) o;
        return Objects.equals(paymentId, that.paymentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentId);
    }

    @Override
    public String toString() {
        return "HotelPayment{" +
                "paymentId='" + paymentId + '\'' +
                ", booking=" + booking +
                ", amount=" + amount +
                ", paymentDate=" + paymentDate +
                ", createdAt=" + createdAt +
                '}';
    }
}
