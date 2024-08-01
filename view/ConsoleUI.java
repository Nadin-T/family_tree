package view;

import presenter.FamilyTreePresenter;
import view.commands.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleUI {
    private FamilyTreePresenter presenter;
    private Scanner scanner;
    private Map<Integer, Command> commands;

    public ConsoleUI(FamilyTreePresenter presenter) {
        this.presenter = presenter;
        this.scanner = new Scanner(System.in);
        this.commands = new HashMap<>();
        initializeCommands();
    }

    private void initializeCommands() {
        commands.put(1, new AddNewHumanCommand(presenter, scanner));
        commands.put(2, new EstablishFamilyRelationshipsCommand(presenter, scanner));
        commands.put(3, new FindHumanByIdCommand(presenter, scanner));
        commands.put(4, new FindHumanByNameCommand(presenter, scanner));
        commands.put(5, new DisplayFamilyTreeCommand(presenter));
        commands.put(6, new SaveFamilyTreeToFileCommand(presenter));
        commands.put(7, new LoadFamilyTreeFromFileCommand(presenter));
        commands.put(8, new RemoveHumanCommand(presenter, scanner));
        commands.put(9, new ExitCommand());
    }

    public void start() {
        while (true) {
            displayMenu();
            int choice = getUserChoice();
            executeCommand(choice);
            if (choice == 9){
                break;
            }
        }
    }

    private void displayMenu() {
        System.out.println("Меню:");
        System.out.println("1. Добавить нового человека в древо");
        System.out.println("2. Установить семейные связи");
        System.out.println("3. Найти человека по ID");
        System.out.println("4. Найти человека по имени");
        System.out.println("5. Вывести семейное древо");
        System.out.println("6. Сохранить древо в файл");
        System.out.println("7. Загрузить древо из файла");
        System.out.println("8. Удалить человека из древа");
        System.out.println("9. Завершить работу программы");
        System.out.print("Выберите действие: ");
    }

    private int getUserChoice() {
        int choice = 0;
        while (true) {
            try {
                choice = Integer.parseInt(scanner.next());
                break;
            } catch (NumberFormatException e) {
                System.out.print("Введите корректное число: ");
            }
        }
        return choice;
    }

    private void executeCommand(int choice) {
        Command command = commands.getOrDefault(choice, () -> System.out.println("Неверная команда, повторите выбор."));
        command.execute();
    }

    public void shutdown() {
        scanner.close();
    }
}
