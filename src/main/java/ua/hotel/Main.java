package ua.hotel;

import ua.hotel.model.*;
import ua.hotel.util.HotelUtils;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== HOTEL BOOKING SYSTEM ===");

        try {
            Guest guest = new Guest(
                    "AB123456",
                    "Anna",
                    "Marius",
                    LocalDate.of(1998, 5, 15)
            );

            Room room = new Room(101, RoomType.DOUBLE, 1200.0);

            Booking booking = new Booking(
                    "BOOK-1001",
                    guest,
                    room,
                    LocalDate.of(2026, 12, 10),
                    LocalDate.of(2026, 12, 15),
                    BookingStatus.CONFIRMED
            );

            HotelPayment payment = new HotelPayment(
                    "PAY-8801",
                    booking,
                    HotelUtils.totalPrice(booking),
                    LocalDate.of(2026, 12, 10)
            );

            System.out.println(guest);
            System.out.println(room);
            System.out.println(booking);
            System.out.println(payment);

            System.out.println("Nights: " + HotelUtils.nights(booking));
            System.out.println("Total price: " + HotelUtils.totalPrice(booking));
            System.out.println("Room description: " + describeRoomType(room.type()));
            System.out.println("Booking message: " + describeBookingStatus(booking.status()));
            System.out.println("Price factor: " + room.type().getPriceFactor());

        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n--- ERROR SCENARIOS ---");

        try {
            new Room(-1, RoomType.SINGLE, 100.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Room validation: " + e.getMessage());
        }

        try {
            new Guest("P123", "John", "Smith",
                    LocalDate.of(2015, 1, 1));
        } catch (IllegalArgumentException e) {
            System.out.println("Guest validation: " + e.getMessage());
        }
    }

    public static String describeRoomType(RoomType type) {
        return switch (type) {
            case SINGLE -> "Single room";
            case DOUBLE -> "Double room";
            case SUITE -> "Suite";
            case DELUXE -> "Deluxe room";
        };
    }

    public static String describeBookingStatus(BookingStatus status) {
        return switch (status) {
            case CONFIRMED -> "Booking is confirmed";
            case CHECKED_IN -> "Guest has checked in";
            case CHECKED_OUT -> "Guest has checked out";
            case CANCELLED -> "Booking is cancelled";
        };
    }
}
