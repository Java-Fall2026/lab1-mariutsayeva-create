
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

    public Guest(String passportNumber, String firstName,
                 String lastName, LocalDate birthDate) {
        super();

        if (passportNumber == null || passportNumber.isBlank()) {
            throw new IllegalArgumentException(
                    "Passport number must not be empty. Actual: " + passportNumber);
        }
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException(
                    "First name must not be empty. Actual: " + firstName);
        }
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException(
                    "Last name must not be empty. Actual: " + lastName);
        }
        if (birthDate == null) {
            throw new IllegalArgumentException(
                    "Birth date must not be null. Actual: " + birthDate);
        }

        int age = Period.between(birthDate, LocalDate.now()).getYears();
        if (age < 18) {
            throw new IllegalArgumentException(
                    "Guest must be at least 18 years old. Expected: >= 18, actual: " + age);
        }

        this.passportNumber = passportNumber.trim();
        this.firstName = firstName.trim();
        this.lastName = lastName.trim();
        this.birthDate = birthDate;
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
        if (!(o instanceof Guest)) return false;
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
                '}';
    }
}
