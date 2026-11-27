
package ua.hotel.model;

import ua.common.BaseEntity;

import java.util.Objects;

public class Room extends BaseEntity {

    private final int roomNumber;
    private final String roomType;
    private double pricePerNight;

    public Room(int roomNumber, String roomType, double pricePerNight) {
        super();

        if (roomNumber <= 0) {
            throw new IllegalArgumentException(
                    "Room number must be > 0. Actual: " + roomNumber);
        }

        if (roomType == null || roomType.isBlank()) {
            throw new IllegalArgumentException(
                    "Room type must be SINGLE, DOUBLE, SUITE or DELUXE. Actual: " + roomType);
        }

        String normalizedType = roomType.trim().toUpperCase();
        if (!normalizedType.equals("SINGLE")
                && !normalizedType.equals("DOUBLE")
                && !normalizedType.equals("SUITE")
                && !normalizedType.equals("DELUXE")) {
            throw new IllegalArgumentException(
                    "Room type must be one of [SINGLE, DOUBLE, SUITE, DELUXE]. Actual: "
                            + roomType);
        }

        if (pricePerNight <= 0 || !Double.isFinite(pricePerNight)) {
            throw new IllegalArgumentException(
                    "Price per night must be > 0. Actual: " + pricePerNight);
        }

        this.roomNumber = roomNumber;
        this.roomType = normalizedType;
        this.pricePerNight = pricePerNight;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public final void setPricePerNight(double pricePerNight) {
        if (pricePerNight <= 0 || !Double.isFinite(pricePerNight)) {
            throw new IllegalArgumentException(
                    "Price per night must be > 0. Actual: " + pricePerNight);
        }
        this.pricePerNight = pricePerNight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;
        Room room = (Room) o;
        return roomNumber == room.roomNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber);
    }

    @Override
public String toString() {
    return "Room{" +
            "roomNumber=" + roomNumber +
            ", roomType='" + roomType + '\'' +
            ", pricePerNight=" + pricePerNight +
            ", createdAt=" + createdAt +
            '}';
}
}
