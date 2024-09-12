# PhoneBook
Данное приложение запрашивает у пользователя данные для заполнения телефонной книги (Фамилия Имя Отчество, дата рождения, номер телефона, пол)

Также приложение записывает корректные данные в файл, названный по фамилии пользователя. Однофамильцы записываются в один и тот же файл в разные строки.

Приложение позволяет читать файлы, записанные данным приложением, и выводить данные из файла на консоль.

1. UserDataMenu.java содержит методы для отображения меню и получения выбора пользователя.
2. UserDataFileHandler.java содержит методы для записи и чтения данных из файла.
3. UserDataValidator.java содержит методы для валидации входных данных.
4. UserDataApp.java является точкой входа в приложение и координирует взаимодействие между различными компонентами.