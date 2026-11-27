
package ua.hotel.model;

import ua.common.BaseEntity;
import java.util.Objects;

public class Room extends BaseEntity {

    private final int roomNumber;
    private final String roomType;
    private double pricePerNight;

    private Room(int roomNumber, String roomType, double pricePerNight) {
        super();

        if (roomNumber <= 0) {
            throw new IllegalArgumentException("Room number must be positive");
        }
        if (roomType == null || roomType.trim().isEmpty()) {
            throw new IllegalArgumentException("Room type cannot be empty");
        }

        String normalizedType = roomType.trim().toUpperCase();
        if (!normalizedType.equals("SINGLE")
                && !normalizedType.equals("DOUBLE")
                && !normalizedType.equals("SUITE")
                && !normalizedType.equals("DELUXE")) {
            throw new IllegalArgumentException(
                    "Invalid room type: " + roomType);
        }

        if (pricePerNight <= 0 || !Double.isFinite(pricePerNight)) {
            throw new IllegalArgumentException(
                    "Price per night must be positive");
        }

        this.roomNumber = roomNumber;
        this.roomType = normalizedType;
        this.pricePerNight = pricePerNight;
    }

    public static Room of(int roomNumber, String roomType,
                          double pricePerNight) {
        return new Room(roomNumber, roomType, pricePerNight);
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
                    "Price per night must be positive");
        }
        this.pricePerNight = pricePerNight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
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


  
