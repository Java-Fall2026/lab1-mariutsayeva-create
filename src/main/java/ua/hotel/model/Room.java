
package ua.hotel.model;

public record Room(int roomNumber, RoomType type, double pricePerNight) {

    public Room {
        if (roomNumber < 1 || roomNumber > 999) {
            throw new IllegalArgumentException(
                    "roomNumber must be between 1 and 999, got: " + roomNumber
            );
        }

        if (type == null) {
            throw new IllegalArgumentException("Room type must not be null");
        }

        if (!Double.isFinite(pricePerNight) || pricePerNight <= 0) {
            throw new IllegalArgumentException(
                    "pricePerNight must be positive, got: " + pricePerNight
            );
        }
    }
}
