
package ua.hotel;

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
            throw new IllegalArgumentException("Passport number cannot be empty");
        }
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("First name cannot be empty");
        }
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("Last name cannot be empty");
        }
        if (birthDate == null) {
            throw new IllegalArgumentException("Birth date cannot be null");
        }
        if (birthDate.isAfter(LocalDate.now())
                || Period.between(birthDate, LocalDate.now()).getYears() < 18) {
            throw new IllegalArgumentException("Guest must be at least 18 years old");
        }

        this.passportNumber = passportNumber;
        this.firstName = firstName;
        this.lastName = lastName;
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
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Guest)) return false;
        Guest guest = (Guest) obj;
        return passportNumber.equals(guest.passportNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passportNumber);
    }
}
