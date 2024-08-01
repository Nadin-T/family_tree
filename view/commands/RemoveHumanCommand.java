package view.commands;

import model.human.Human;
import presenter.FamilyTreePresenter;

import java.util.Scanner;

public class RemoveHumanCommand implements Command{
    private FamilyTreePresenter presenter;
    private Scanner scanner;

    public RemoveHumanCommand(FamilyTreePresenter presenter, Scanner scanner) {
        this.presenter = presenter;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("Введите id человека для удаления: ");
        long id = scanner.nextLong();
        Human humanToRemove = presenter.findHumanById(id);
        if (humanToRemove != null) {
            presenter.removeHumanFromTree(humanToRemove);
            System.out.println("Человек успешно удален из древа.");
        } else {
            System.out.println("Человек с таким id не найден.");
        }
    }
}
