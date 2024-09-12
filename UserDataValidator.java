import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;

public class UserDataValidator {
    private static final Pattern NAME_PATTERN = Pattern.compile("^[a-zA-Zа-яА-Я-]+$");

    public static boolean isValidName(String name) {
        return NAME_PATTERN.matcher(name).matches();
    }

    public static LocalDate parseDate(String dateString) {
        try {
            return LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } catch (DateTimeParseException e) {
            System.err.println("Неверный формат даты: " + dateString);
            throw e;
        }
    }

    public static boolean isValidGender(char gender) {
        return gender == 'f' || gender == 'm';
    }
}
