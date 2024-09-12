import java.util.Scanner;

public class UserDataMenu {
    public static void displayMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1. Запись пользователя в файл");
        System.out.println("2. Показать данные из файла");
        System.out.println("3. Выход (q)");
    }

    public static int getUserChoice() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("q")) {
            return 3;
        }
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.err.println("Неверный ввод. Пожалуйста, выберите действие от 1 до 3 или введите 'q' для выхода.");
            return getUserChoice();
        }
    }
}
