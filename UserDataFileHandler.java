import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UserDataFileHandler {
    public static void writeToFile(String lastName, String firstName, String middleName, LocalDate birthDate, long phoneNumber, char gender) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(lastName + ".txt", true))) {
            writer.write(lastName + " " + firstName + " " + middleName + " " + birthDate + " " + phoneNumber + " " + gender);
            writer.newLine();
            System.out.println("Пользователь сохранён!");
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName + ".txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(" ");
                if (data.length == 6) {
                    String lastName = data[0];
                    String firstName = data[1];
                    String middleName = data[2];
                    LocalDate birthDate = LocalDate.parse(data[3], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    long phoneNumber = Long.parseLong(data[4]);
                    char gender = data[5].charAt(0);
                    System.out.printf("Фамилия: %s, Имя: %s, Отчество: %s, Дата рождения: %s, Номер телефона: %d, Пол: %c%n",
                            lastName, firstName, middleName, birthDate, phoneNumber, gender);
                } else {
                    System.err.println("Неверный формат данных в файле: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + fileName + ".txt");
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Ошибка при обработке данных: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
