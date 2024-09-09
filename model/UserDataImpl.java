package Phonebook.model;

import java.time.LocalDate;

public class UserDataImpl implements UserData{
    private String lastName;
    private String firstName;
    private String patronymic;
    private LocalDate dateOfBirth;
    private long phoneNumber;
    private Gender gender;

    public UserDataImpl(String lastName, String firstName, String patronymic, 
                    LocalDate dateOfBirth, long phoneNumber, Gender gender){
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    @Override
    public String getLastName(){
        return lastName;
    }

    @Override
    public String getFirstName(){
        return firstName;
    }

    @Override
    public String getPatronymic(){
        return patronymic;
    }

    @Override
    public LocalDate getDateOfBirth(){
        return dateOfBirth;
    }

    @Override
    public long getPhoneNumber(){
        return phoneNumber;
    }

    @Override
    public Gender getGender(){
        return gender;
    }
}
