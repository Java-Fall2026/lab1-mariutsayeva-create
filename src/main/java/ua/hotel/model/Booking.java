
package ua.hotel.model;

import ua.common.BaseEntity;

import java.time.LocalDate;
import java.util.Objects;

public class Booking extends BaseEntity {

    private final Room room;
    private final Guest guest;
    private final LocalDate checkInDate;
    private final LocalDate checkOutDate;
    private String status;

    private static final String[] ALLOWED_STATUSES = {
            "CONFIRMED", "CHECKED_IN", "CHECKED_OUT", "CANCELLED"
    };

    public Booking(Room room, Guest guest, LocalDate checkInDate,
                   LocalDate checkOutDate, String status) {
        super();

        if (room == null) {
            throw new IllegalArgumentException("Room must not be null. Actual: null");
        }
        if (guest == null) {
            throw new IllegalArgumentException("Guest must not be null. Actual: null");
        }
        if (checkInDate == null) {
            throw new IllegalArgumentException(
                    "Check-in date must not be null. Actual: null");
        }
        if (checkOutDate == null) {
            throw new IllegalArgumentException(
                    "Check-out date must not be null. Actual: null");
        }
        if (!checkOutDate.isAfter(checkInDate)) {
            throw new IllegalArgumentException(
                    "Check-out date must be after check-in date. Expected: after "
                            + checkInDate + ", actual: " + checkOutDate);
        }

        this.room = room;
        this.guest = guest;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.status = validateStatus(status);
    }

    private static String validateStatus(String status) {
        if (status == null || status.isBlank()) {
            throw new IllegalArgumentException(
                    "Status must be one of [CONFIRMED, CHECKED_IN, CHECKED_OUT, CANCELLED]. "
                            + "Actual: " + status);
        }

        String normalized = status.trim().toUpperCase();

        for (String allowed : ALLOWED_STATUSES) {
            if (allowed.equals(normalized)) {
                return normalized;
            }
        }

        throw new IllegalArgumentException(
                "Status must be one of [CONFIRMED, CHECKED_IN, CHECKED_OUT, CANCELLED]. "
                        + "Actual: " + status);
    }

    public Room getRoom() {
        return room;
    }

    public Guest getGuest() {
        return guest;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public String getStatus() {
        return status;
    }

    public final void setStatus(String status) {
        this.status = validateStatus(status);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Booking)) return false;
        Booking booking = (Booking) o;
        return Objects.equals(room, booking.room)
                && Objects.equals(guest, booking.guest)
                && Objects.equals(checkInDate, booking.checkInDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(room, guest, checkInDate);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "room=" + room +
                ", guest=" + guest +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", status='" + status + '\'' +
                '}';
    }
}
