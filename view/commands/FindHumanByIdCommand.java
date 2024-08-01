package view.commands;

import model.human.Human;
import presenter.FamilyTreePresenter;

import java.util.Scanner;

public class FindHumanByIdCommand implements Command{
    private FamilyTreePresenter presenter;
    private Scanner scanner;

    public FindHumanByIdCommand(FamilyTreePresenter presenter, Scanner scanner) {
        this.presenter = presenter;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("Введите id человека: ");
        long id = scanner.nextLong();
        Human human = presenter.findHumanById(id);
        if (human != null) {
            System.out.println("Человек найден:");
            presenter.displayHumanDetails(human);
        } else {
            System.out.println("Человек с таким id не найден.");
        }
    }
}
