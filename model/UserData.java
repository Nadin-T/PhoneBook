package Phonebook.model;

import java.time.LocalDate;

public interface UserData {
    String getFirstName();
    String getLastName();
    String getPatronymic();
    LocalDate getDateOfBirth();
    long getPhoneNumber();
    Gender getGender();
}
