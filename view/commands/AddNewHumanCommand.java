package view.commands;

import model.human.Gender;
import model.human.Human;
import presenter.FamilyTreePresenter;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class AddNewHumanCommand implements Command {
    private FamilyTreePresenter presenter;
    private Scanner scanner;

    public AddNewHumanCommand(FamilyTreePresenter presenter, Scanner scanner) {
        this.presenter = presenter;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        while (true) {
            try {
                System.out.println("Введите данные нового человека:");

                System.out.print("Введите имя: ");
                String name = scanner.next();

                System.out.print("Выберите пол (муж/жен): ");
                String genderInput = scanner.next();

                Gender gender;

                if (genderInput.equalsIgnoreCase("муж")) {
                    gender = Gender.Male;
                } else if (genderInput.equalsIgnoreCase("жен")) {
                    gender = Gender.Female;
                } else {
                    throw new IllegalArgumentException("Неверный пол");
                }

                System.out.print("Дата рождения (гггг-мм-дд): ");
                LocalDate dateOfBirth = LocalDate.parse(scanner.next());

                // Создаем нового человека через presenter, который сгенерирует уникальный ID
                Human newHuman = presenter.createNewHuman(name, gender, dateOfBirth);

                presenter.addHumanToTree(newHuman);

                if (newHuman != null) {
                    System.out.println("Новый человек добавлен в древо с ID: " + newHuman.getId());
                    System.out.println(newHuman);
                    break; // Выходим из цикла, если человек успешно добавлен
                } else {
                    System.out.println("Не удалось добавить нового человека.");
                    break; // Выходим из цикла при ошибке
                }
            } catch (DateTimeParseException e) {
                System.out.println("Неверный формат даты. Введите дату в формате гггг-мм-дд.");
                scanner.nextLine(); // очистка буфера сканнера
            } catch (IllegalArgumentException e) {
                System.out.println("Неверный пол. Пожалуйста, введите 'муж' или 'жен'.");
                scanner.nextLine(); // очистка буфера сканнера
            }
        }
    }
}
