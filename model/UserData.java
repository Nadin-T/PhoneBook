package Phonebook.model;

import java.time.LocalDate;

public class UserData {
    String lastName;
    String firstName;
    String patronymic;
    LocalDate birthDay;
    int phoneNumber;
    Gender gender;

    public UserData(String lastName, String firstName, String patronymic, 
                    LocalDate birthDay, int phoneNumber, Gender gender){
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.birthDay = birthDay;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    
}
