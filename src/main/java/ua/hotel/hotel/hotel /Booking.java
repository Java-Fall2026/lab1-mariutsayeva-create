package ua.hotel;

import ua.common.BaseEntity;
import java.time.LocalDate;
import java.util.Objects;

public class Booking extends BaseEntity {

    private final Room room;
    private final Guest guest;
    private final LocalDate checkInDate;
    private final LocalDate checkOutDate;
    private String status;

    public Booking(Room room, Guest guest,
                   LocalDate checkInDate, LocalDate checkOutDate,
                   String status) {
        super();

        if (room == null || guest == null) {
            throw new IllegalArgumentException("Room and guest cannot be null");
        }

        if (checkInDate == null || checkOutDate == null) {
            throw new IllegalArgumentException("Dates cannot be null");
        }

        if (!checkOutDate.isAfter(checkInDate)) {
            throw new IllegalArgumentException("Check-out must be after check-in");
        }

        if (!Objects.equals(status, "CONFIRMED")
                && !Objects.equals(status, "CHECKED_IN")
                && !Objects.equals(status, "CHECKED_OUT")
                && !Objects.equals(status, "CANCELLED")) {
            throw new IllegalArgumentException("Invalid booking status");
        }

        this.room = room;
        this.guest = guest;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.status = status;
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

    public void setStatus(String status) {
        if (!Objects.equals(status, "CONFIRMED")
                && !Objects.equals(status, "CHECKED_IN")
                && !Objects.equals(status, "CHECKED_OUT")
                && !Objects.equals(status, "CANCELLED")) {
            throw new IllegalArgumentException("Invalid booking status");
        }
        this.status = status;
    }

    public long nights() {
        return java.time.temporal.ChronoUnit.DAYS.between(
                checkInDate, checkOutDate);
    }

    public double totalPrice() {
        return nights() * room.getPricePerNight();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Booking)) return false;
        Booking booking = (Booking) obj;
        return room.equals(booking.room)
                && guest.equals(booking.guest)
                && checkInDate.equals(booking.checkInDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(room, guest, checkInDate);
    }
}
