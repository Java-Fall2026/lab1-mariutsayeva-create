

package ua.hotel;

import ua.hotel.model.Booking;
import ua.hotel.model.Guest;
import ua.hotel.model.HotelPayment;
import ua.hotel.model.Room;
import ua.hotel.util.HotelUtils;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== HOTEL BOOKING SYSTEM ===");

        try {
            Guest guest = Guest.of(
                    " AB123456 ",
                    "Anna",
                    "Marius",
                    LocalDate.of(1998, 5, 15)
            );

            Room room = Room.of(101, "double", 1200.0);

            Booking booking = new Booking(
                    room,
                    guest,
                    LocalDate.of(2026, 12, 10),
                    LocalDate.of(2026, 12, 15),
                    "confirmed"
            );

            HotelPayment payment = new HotelPayment(
                    "PAY-8801",
                    booking,
                    HotelUtils.totalPrice(booking),
                    LocalDate.of(2026, 12, 10)
            );

            System.out.println("\n--- SUCCESSFUL SCENARIO ---");
            System.out.println(guest);
            System.out.println(room);
            System.out.println(booking);
            System.out.println(payment);

            System.out.println("Nights: " + HotelUtils.nights(booking));
            System.out.println("Total price: " + HotelUtils.totalPrice(booking));

        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n--- ERROR SCENARIOS ---");

        try {
            Room.of(-1, "SINGLE", 100.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Room validation: " + e.getMessage());
        }

        try {
            Guest.of(
                    "P123",
                    "John",
                    "Smith",
                    LocalDate.of(2015, 1, 1)
            );
        } catch (IllegalArgumentException e) {
            System.out.println("Guest validation: " + e.getMessage());
        }
    }
}
