import java.time.LocalDate;
import java.util.Scanner;

public class UserDataApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            UserDataMenu.displayMenu();
            int choice = UserDataMenu.getUserChoice();

            switch (choice) {
                case 1:
                    System.out.println("Введите данные (Фамилия Имя Отчество датарождения номертелефона пол):");
                    String input = scanner.nextLine();
                    String[] data = input.split(" ");
                    if (data.length != 6) {
                        System.err.println("Неверное количество данных. Ожидалось 6 элементов.");
                        break;
                    }

                    String lastName = data[0];
                    String firstName = data[1];
                    String middleName = data[2];
                    try {
                        LocalDate birthDate = UserDataValidator.parseDate(data[3]);
                        long phoneNumber = Long.parseLong(data[4]);
                        char gender = data[5].charAt(0);
                        if (!UserDataValidator.isValidName(lastName) || !UserDataValidator.isValidName(firstName) || !UserDataValidator.isValidName(middleName)) {
                            System.err.println("Имя, фамилия или отчество содержат недопустимые символы.");
                            break;
                        }
                        if (!UserDataValidator.isValidGender(gender)) {
                            System.err.println("Пол должен быть 'f' или 'm'.");
                            break;
                        }
                        UserDataFileHandler.writeToFile(lastName, firstName, middleName, birthDate, phoneNumber, gender);
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Введите фамилию для просмотра данных:");
                    String fileName = scanner.nextLine();
                    UserDataFileHandler.readFromFile(fileName);
                    break;
                case 3:
                    System.out.println("Выход из приложения.");
                    scanner.close();
                    return;
                default:
                    System.err.println("Неверный выбор. Попробуйте еще раз.");
                    break;
            }
        }
    }
}