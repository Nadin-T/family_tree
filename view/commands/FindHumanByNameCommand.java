package view.commands;

import presenter.FamilyTreePresenter;

import java.util.Scanner;

public class FindHumanByNameCommand implements Command{
    private FamilyTreePresenter presenter;
    private Scanner scanner;

    public FindHumanByNameCommand(FamilyTreePresenter presenter, Scanner scanner) {
        this.presenter = presenter;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("Введите имя человека: ");
        String name = scanner.next();
        System.out.println("Найденные люди:");
        presenter.findHumansByName(name).forEach(presenter::displayHumanDetails);
    }
}
