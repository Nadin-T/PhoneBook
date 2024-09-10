import java.io.*;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;

import java.time.format.DateTimeParseException;

import java.util.Scanner;

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

            String lastName = data[0];

            String firstName = data[1];

            String middleName = data[2];

            LocalDate birthDate = LocalDate.parse(data[3], DateTimeFormatter.ofPattern("dd.MM.yyyy"));

            long phoneNumber = Long.parseLong(data[4]);

            char gender = data[5].charAt(0);

            if (gender != 'f' && gender != 'm') {

                throw new IllegalArgumentException("Пол должен быть 'f' или 'm'.");

            }

            writeToFile(lastName, firstName, middleName, birthDate, phoneNumber, gender);

        } catch (Exception e) {

            System.err.println(e.getMessage());

            e.printStackTrace();

        } finally {

            scanner.close();

        }

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

