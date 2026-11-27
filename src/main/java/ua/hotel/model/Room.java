package ua.hotel.model;

public record Room(int roomNumber, RoomType type, double pricePerNight) {

    public Room {
        if (roomNumber < 1 || roomNumber > 999)
            throw new IllegalArgumentException("Invalid room number");
        if (type == null)
            throw new IllegalArgumentException("Room type must not be null");
        if (!Double.isFinite(pricePerNight) || pricePerNight <= 0)
            throw new IllegalArgumentException("Price must be positive");
    }

    public double getPricePerNight() {
        return pricePerNight;
    }
}
