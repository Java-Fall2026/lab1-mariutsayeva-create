

package ua.hotel.model;

import ua.common.BaseEntity;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Guest extends BaseEntity {

    private final String passportNumber;
    private final String firstName;
    private final String lastName;
    private final LocalDate birthDate;

    private Guest(String passportNumber, String firstName,
                  String lastName, LocalDate birthDate) {
        super();

        if (passportNumber == null || passportNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Passport number cannot be empty");
        }
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("First name cannot be empty");
        }
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be empty");
        }
        if (birthDate == null) {
            throw new IllegalArgumentException("Birth date cannot be null");
        }
        if (Period.between(birthDate, LocalDate.now()).getYears() < 18) {
            throw new IllegalArgumentException("Guest must be at least 18 years old");
        }

        this.passportNumber = passportNumber.trim();
        this.firstName = firstName.trim();
        this.lastName = lastName.trim();
        this.birthDate = birthDate;
    }

    public static Guest of(String passportNumber, String firstName,
                           String lastName, LocalDate birthDate) {
        return new Guest(passportNumber, firstName, lastName, birthDate);
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guest guest = (Guest) o;
        return Objects.equals(passportNumber, guest.passportNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passportNumber);
    }

    @Override
    public String toString() {
        return "Guest{" +
                "passportNumber='" + passportNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", createdAt=" + createdAt +
                '}';
    }
}
