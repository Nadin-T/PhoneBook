import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserDataApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите данные (Фамилия Имя Отчество датарождения номертелефона пол):");

        String input = scanner.nextLine();

        String[] data = input.split(" ");

        try {

            if (data.length != 6) {

                throw new IllegalArgumentException("Неверное количество данных. Ожидалось 6 элементов.");

            }

            String lastName = validateName(data[0]);

            String firstName = validateName(data[1]);

            String middleName = validateName(data[2]);
            

            LocalDate birthDate;
            try {
                birthDate = LocalDate.parse(data[3], 
                DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            } catch (DateTimeParseException e){
                throw new IllegalArgumentException(
                    "Неверный формат даты рождения. Ожидается 'dd.MM.yyyy'.");
            }

            long phoneNumber;
            try {
                phoneNumber = Long.parseLong(data[4]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(
                    "Неверный формат номера телефона.");
            }

            char gender = Character.toLowerCase(data[5].charAt(0));

            if (gender != 'f' && gender != 'm') {

                throw new IllegalArgumentException("Пол должен быть 'f' или 'm'.");

            }

            writeToFile(lastName, firstName, middleName, birthDate, phoneNumber, gender);

        } catch (Exception e) {

            System.err.println(e.getMessage());

        } finally {

            scanner.close();

        }

    }

    private static String validateName(String name){
        String regex = "^[a-zA-Zа-яА-Я-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);

        if (!matcher.matches()) {
            throw new IllegalArgumentException(
                "Имя, фамилия или отчество содержат недопустимые символы.");
        }

        return name;
    }

    private static void writeToFile(String lastName, String firstName, String middleName, LocalDate birthDate, long phoneNumber, char gender) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(lastName + ".txt", true))) {

            writer.write(lastName + " " + firstName + " " + middleName + " " + birthDate + " " + phoneNumber + " " + gender);

            writer.newLine();

        } catch (IOException e) {

            System.err.println("Ошибка при записи в файл: " + e.getMessage());

            e.printStackTrace();

        }

    }
}

