package ua.hotel;

import ua.common.BaseEntity;
import java.util.Objects;

public class Room extends BaseEntity {

    private final int roomNumber;
    private final String roomType;
    private final double pricePerNight;

    public Room(int roomNumber, String roomType, double pricePerNight) {
        super();

        if (roomNumber <= 0) {
            throw new IllegalArgumentException("Room number must be greater than 0");
        }

        if (!Objects.equals(roomType, "SINGLE")
                && !Objects.equals(roomType, "DOUBLE")
                && !Objects.equals(roomType, "SUITE")
                && !Objects.equals(roomType, "DELUXE")) {
            throw new IllegalArgumentException("Invalid room type");
        }

        if (pricePerNight <= 0) {
            throw new IllegalArgumentException("Price must be greater than 0");
        }

        this.roomNumber = roomNumber;
        this.roomType = roomType;
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Room)) return false;
        Room room = (Room) obj;
        return roomNumber == room.roomNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber);
    }
}
