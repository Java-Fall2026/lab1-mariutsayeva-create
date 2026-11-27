
package ua.hotel.model;

import java.time.LocalDate;
import java.time.Period;

public record Guest(
        String passportNumber,
        String firstName,
        String lastName,
        LocalDate birthDate
) {
    public Guest {
        if (passportNumber == null || passportNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Passport number must not be empty");
        }
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("First name must not be empty");
        }
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Last name must not be empty");
        }
        if (birthDate == null) {
            throw new IllegalArgumentException("Birth date must not be null");
        }
        if (Period.between(birthDate, LocalDate.now()).getYears() < 18) {
            throw new IllegalArgumentException("Guest must be at least 18 years old");
        }

        passportNumber = passportNumber.trim();
        firstName = firstName.trim();
        lastName = lastName.trim();
    }
}
