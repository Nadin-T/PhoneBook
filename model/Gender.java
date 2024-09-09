package Phonebook.model;

public enum Gender {
    MALE('m'),
    FEMALE('f');

    private final char value;

    private Gender(char value) {
        this.value = value;
    }

    public char getValue(){
        return value;
    }
}
